public class Moto {
    // atributos
    private String matricula;
    private String marca;
    private String modelo;
    private int potencia;
    private double kilometros;
    private boolean ultimaRevision;

    // Tema: static
    // Atributo estático: pertenece a la clase y cuenta cuántas motos se crearon.
    public static int cantidadMotos = 0;
    // Metodos

    // constructores

    public Moto() {
        cantidadMotos++;
    }

    public Moto(String matricula, String marca, String modelo, int potencia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.kilometros = 0;
        this.ultimaRevision = false;
        cantidadMotos++;
    }

    // getters/setters

    public String getMarca() {
        return this.marca;
    }

    public double getKilometros() {
        return this.kilometros;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    // métodos propios de la clase

}
