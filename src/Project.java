import java.util.ArrayList;
import java.util.List;

/**
 * La clase Project representa un proyecto que puede contener tareas.
 * Implementa la interfaz IProject.
 */
class Project implements IProject {

    private String name; // Nombre del proyecto
    private List<Task> tasks; // Lista de tareas asociadas al proyecto

    /**
     * Constructor para crear un nuevo proyecto con un nombre específico.
     *
     * @param name El nombre del proyecto.
     */
    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>(); // Inicializa la lista de tareas
    }

    /**
     * Agrega una tarea al proyecto.
     *
     * @param task La tarea a agregar.
     */
    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Obtiene el nombre del proyecto.
     *
     * @return El nombre del proyecto como una cadena.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Obtiene la lista de tareas asociadas al proyecto.
     *
     * @return Una lista de tareas.
     */
    public List<Task> getTasks() {
        return tasks;
    }
}
