/**
 * La clase TaskFactory es una fábrica para crear instancias de la clase Task.
 * Utiliza el patrón de diseño de fábrica para separar la creación de tareas de su uso,
 * lo que facilita la gestión y la modificación de las instancias de Task en el futuro.
 */
class TaskFactory {

    /**
     * Crea una nueva instancia de Task con el nombre especificado.
     *
     * @param name el nombre de la tarea a crear.
     * @return una nueva instancia de Task.
     */
    public Task createTask(String name) {
        return new Task(name);
    }
}
