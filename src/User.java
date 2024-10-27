/**
 * La clase User representa un usuario que puede ser asignado a tareas.
 * Implementa la interfaz IUser.
 */
class User implements IUser {

    private String name; // Nombre del usuario

    /**
     * Constructor para crear un nuevo usuario con el nombre especificado.
     *
     * @param name El nombre del usuario.
     */
    public User(String name) {
        this.name = name; // Inicializa el nombre del usuario
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    @Override
    public String getName() {
        return name; // Retorna el nombre del usuario
    }
}
