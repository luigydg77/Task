/**
 * La clase UserFactory es una fábrica para crear instancias de la clase User.
 * Utiliza el patrón de diseño de fábrica para separar la creación de usuarios de su uso,
 * lo que facilita la gestión y la modificación de las instancias de User en el futuro.
 */
class UserFactory {

    /**
     * Crea una nueva instancia de User con el nombre especificado.
     *
     * @param name el nombre del usuario a crear.
     * @return una nueva instancia de User.
     */
    public User createUser(String name) {
        return new User(name);
    }
}
