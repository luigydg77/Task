/**
 * La interfaz ITask define el comportamiento de una tarea
 * que permite asignar usuarios, completar tareas y gestionar su estado.
 */
public interface ITask {

    /**
     * Asigna un usuario a la tarea.
     *
     * @param user El usuario que se va a asignar a la tarea.
     */
    void assignUser(User user);

    /**
     * Marca la tarea como completada.
     */
    void completeTask();

    /**
     * Obtiene el estado actual de la tarea.
     *
     * @return Una cadena que representa el estado de la tarea.
     */
    String getStatus();

    /**
     * Actualiza el estado de la tarea a completada o pendiente.
     *
     * @param completed true si la tarea se completa, false si permanece pendiente.
     */
    void updateStatus(boolean completed);
}
