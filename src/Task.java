/**
 * La clase Task representa una tarea que puede ser asignada a un usuario y tiene un estado de completado.
 * Implementa la interfaz ITask.
 */
class Task implements ITask {

    private String name; // Nombre de la tarea
    private User assignedUser; // Usuario asignado a la tarea
    private boolean completed; // Estado de la tarea (completada o pendiente)

    /**
     * Constructor para crear una nueva tarea con un nombre específico.
     *
     * @param name El nombre de la tarea.
     */
    public Task(String name) {
        this.name = name;
        this.completed = false; // Inicializa el estado de la tarea como no completada
    }

    /**
     * Asigna un usuario a la tarea.
     *
     * @param user El usuario a asignar a la tarea.
     */
    @Override
    public void assignUser(User user) {
        this.assignedUser = user;
    }

    /**
     * Marca la tarea como completada.
     */
    @Override
    public void completeTask() {
        this.completed = true; // Cambia el estado a completado
    }

    /**
     * Obtiene el estado actual de la tarea.
     *
     * @return El estado de la tarea como "Completed" o "Pending".
     */
    @Override
    public String getStatus() {
        return completed ? "Completed" : "Pending"; // Retorna el estado de la tarea
    }

    /**
     * Devuelve una representación en forma de cadena de la tarea.
     *
     * @return Una cadena que representa el nombre y el estado de la tarea.
     */
    @Override
    public String toString() {
        return "Tarea: " + name + ", Estado: " + getStatus(); // Representación de la tarea
    }

    /**
     * Actualiza el estado de la tarea.
     *
     * @param completed El nuevo estado de la tarea (true para completada, false para pendiente).
     */
    @Override
    public void updateStatus(boolean completed) {
        this.completed = completed; // Cambia el estado
    }

    /**
     * Obtiene el usuario asignado a la tarea.
     *
     * @return El usuario asignado a la tarea.
     */
    public User getAssignedUser() {
        return assignedUser; // Retorna el usuario asignado
    }
}
