import java.util.List;

/**
 * La interfaz ITaskManager define las operaciones que pueden realizarse
 * sobre la gestión de tareas, como agregar tareas, asignarlas a usuarios
 * y obtener la lista de tareas.
 */
interface ITaskManager {

    /**
     * Agrega una nueva tarea al gestor de tareas.
     *
     * @param task La tarea que se va a agregar.
     */
    void addTask(Task task);

    /**
     * Asigna una tarea a un usuario específico.
     *
     * @param task La tarea que se va a asignar.
     * @param user El usuario al que se asignará la tarea.
     */
    void assignTaskToUser(Task task, User user);

    /**
     * Obtiene la lista de todas las tareas gestionadas.
     *
     * @return Una lista que contiene todas las tareas.
     */
    List<Task> getTasks();
}
