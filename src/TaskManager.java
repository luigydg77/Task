import java.util.ArrayList;
import java.util.List;

/**
 * La clase TaskManager es responsable de gestionar las tareas.
 * Permite agregar nuevas tareas, asignarlas a usuarios y obtener la lista de tareas existentes.
 */
class TaskManager implements ITaskManager {
    private List<Task> tasks; // Lista que contiene las tareas

    /**
     * Constructor que inicializa la lista de tareas.
     * Se crea una nueva instancia de ArrayList para almacenar las tareas.
     */
    public TaskManager() {
        tasks = new ArrayList<>(); // Inicializa la lista de tareas
    }

    /**
     * Agrega una nueva tarea a la lista de tareas.
     *
     * @param task la tarea a agregar.
     */
    @Override
    public void addTask(Task task) {
        tasks.add(task); // Agrega la tarea a la lista
    }

    /**
     * Asigna un usuario a una tarea especificada.
     *
     * @param task la tarea a la que se le asignará el usuario.
     * @param user el usuario que se asignará a la tarea.
     */
    @Override
    public void assignTaskToUser(Task task, User user) {
        task.assignUser(user); // Asigna el usuario a la tarea
    }

    /**
     * Devuelve la lista de tareas existentes.
     *
     * @return la lista de tareas.
     */
    @Override
    public List<Task> getTasks() {
        return tasks; // Devuelve la lista de tareas
    }
}
