package ejerciciosClase.clase_7;

public class Cliente {

    private String nombre;
    private String email;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        setEmail(email);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        //Asegurá que email contenga un @ antes de asignarlo
        if (email.contains("@")) {
            this.email = email;
        } else { 
            System.out.println("No es un mail");
        }
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + " | Email: " + email;
    }
}
