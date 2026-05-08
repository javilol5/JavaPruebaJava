package animal;

interface Son {
    void vox();
}

interface Viviparo {
    static final boolean viviparo = true;
}


public class Animal {
    int numPatas;

    public Animal(int patas) {numPatas = patas;}

    public static void rascarConPata() {
        System.out.println("Rascando con la pata");
    }
}
