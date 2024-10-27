import java.util.Scanner;

/**
 * La clase Main es el punto de entrada de la aplicación de gestión de tareas.
 * Permite agregar tareas, asignarlas a usuarios, ver tareas existentes
 * y cambiar el estado de las tareas.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Usando la fábrica para crear un TaskManager
        TaskManager taskManager = new TaskManager(); // Inicializa el administrador de tareas.

        // Fábricas para crear tareas y usuarios
        TaskFactory taskFactory = new TaskFactory();
        UserFactory userFactory = new UserFactory();

        while (true) {
            // Muestra las opciones disponibles al usuario
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Asignar Tarea a Usuario");
            System.out.println("3. Ver Tareas");
            System.out.println("4. Cambiar Estado de Tarea"); // Opción para cambiar el estado
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            int choice = scanner.nextInt(); // Lee la opción seleccionada por el usuario
            scanner.nextLine(); // Consumir el salto de línea

            try {
                switch (choice) {
                    case 1:
                        // Opción para agregar una nueva tarea
                        System.out.print("Ingresa el nombre de la tarea: ");
                        String taskName = scanner.nextLine();
                        Task newTask = taskFactory.createTask(taskName); // Crear tarea usando la fábrica
                        taskManager.addTask(newTask); // Agrega la tarea al administrador
                        System.out.println("Tarea agregada: " + newTask);
                        break;

                    case 2:
                        // Opción para asignar una tarea a un usuario
                        if (taskManager.getTasks().isEmpty()) {
                            throw new NoTasksException("No hay tareas disponibles para asignar.");
                        }
                        System.out.println("Lista de Tareas:");
                        int index = 1;
                        for (Task task : taskManager.getTasks()) {
                            System.out.println(index + ". " + task); // Mostrar tareas numeradas
                            index++;
                        }
                        System.out.print("Elige el número de la tarea a asignar: ");
                        int taskIndex = scanner.nextInt() - 1; // Restar 1 para obtener el índice
                        scanner.nextLine(); // Consumir el salto de línea

                        if (taskIndex >= 0 && taskIndex < taskManager.getTasks().size()) {
                            System.out.print("Ingresa el nombre del usuario: ");
                            String userName = scanner.nextLine();
                            User user = userFactory.createUser(userName); // Crear usuario usando la fábrica
                            Task taskToAssign = taskManager.getTasks().get(taskIndex);
                            taskManager.assignTaskToUser(taskToAssign, user); // Asigna la tarea al usuario
                            System.out.println("Asignada " + taskToAssign + " a " + user.getName());
                        } else {
                            System.out.println("Número de tarea inválido.");
                        }
                        break;

                    case 3:
                        // Opción para ver las tareas existentes
                        if (taskManager.getTasks().isEmpty()) {
                            System.out.println("No hay tareas agregadas.");
                        } else {
                            System.out.println("Tareas:");
                            for (Task task : taskManager.getTasks()) {
                                System.out.println(task + " - Asignada a: " +
                                        (task.getAssignedUser() != null ? task.getAssignedUser().getName() : "Nadie"));
                            }
                        }
                        break;

                    case 4: // Opción para cambiar el estado de una tarea
                        if (taskManager.getTasks().isEmpty()) {
                            throw new NoTasksException("No hay tareas disponibles para cambiar el estado.");
                        }
                        System.out.println("Lista de Tareas para cambiar estado:");
                        index = 1;
                        for (Task task : taskManager.getTasks()) {
                            System.out.println(index + ". " + task); // Mostrar tareas numeradas
                            index++;
                        }
                        System.out.print("Elige el número de la tarea a cambiar estado: ");
                        int taskToChangeIndex = scanner.nextInt() - 1; // Restar 1 para obtener el índice
                        scanner.nextLine(); // Consumir el salto de línea

                        if (taskToChangeIndex >= 0 && taskToChangeIndex < taskManager.getTasks().size()) {
                            Task taskToChange = taskManager.getTasks().get(taskToChangeIndex);
                            System.out.print("¿Está la tarea " + taskToChange + " completada? (sí/no): ");
                            String statusInput = scanner.nextLine().trim().toLowerCase().replaceAll("[áéíóú]", ""); // Convertir a minúsculas y quitar acentos
                            boolean completedStatus = statusInput.equals("sí") || statusInput.equals("si");

                            taskToChange.updateStatus(completedStatus); // Cambia el estado de la tarea
                            System.out.println("Estado de " + taskToChange + " actualizado a " +
                                    (completedStatus ? "Completada" : "Pendiente"));
                        } else {
                            System.out.println("Número de tarea inválido.");
                        }
                        break;

                    case 0:
                        System.exit(0); // Sale de la aplicación
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (NoTasksException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error: " + e.getMessage());
            }
        }
    }
}

/**
 * Excepción personalizada que se lanza cuando no hay tareas disponibles
 * para realizar una acción específica.
 */
class NoTasksException extends Exception {
    /**
     * Constructor de la excepción NoTasksException.
     *
     * @param message El mensaje que describe el error.
     */
    public NoTasksException(String message) {
        super(message);
    }
}
