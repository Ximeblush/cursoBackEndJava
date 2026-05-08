public class Main {
    public static void main(String[] args) {
        Moto moto1 = new Moto("AB123CD", "Honda", "Wave", 110);

        System.out.println(moto1.getMarca());
        System.out.println(moto1.getKilometros());

        moto1.setMarca("Yamaha");
        System.out.println(moto1.getMarca());

        Moto moto2 = new Moto();

        System.out.println("Cantidad de motos creadas: " + Moto.cantidadMotos);
        System.out.println(moto2.getMarca()); // null, porque no se le asignó ningún valor a la marca de moto2

        moto2.setMarca("Suzuki");
        System.out.println(moto2.getMarca());

        Moto moto3 = moto1; // moto3 referencia a la misma moto que moto1
        System.out.println(moto3.getMarca());
        moto3.setMarca("Kawasaki");
        System.out.println(moto1.getMarca()); // Kawasaki, porque moto3 y moto1 son la misma moto, cualquier cambio en moto3 afecta a moto1 y viceversa

        System.out.println(Moto.cantidadMotos); // 2, porque solo se crearon dos objetos Moto (moto1 y moto2), moto3 no es un nuevo objeto, sino una referencia a moto1
    }
}
