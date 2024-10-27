/**
 * La interfaz IProject define el comportamiento de un proyecto
 * que permite agregar tareas y obtener el nombre del proyecto.
 */
public interface IProject {

    /**
     * Agrega una tarea al proyecto.
     *
     * @param task La tarea que se va a agregar al proyecto.
     */
    void addTask(Task task);

    /**
     * Obtiene el nombre del proyecto.
     *
     * @return El nombre del proyecto como una cadena.
     */
    String getName();
}
