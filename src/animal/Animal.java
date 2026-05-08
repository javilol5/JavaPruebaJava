package animal;

interface Son {
    void vox();
}

interface Viviparo {
    static final boolean viviparo = true;
}


public class Animal implements Comparable<Animal>{
    int numPatas;

    public Animal(int patas) {numPatas = patas;}

    public static void rascarConPata() {
        System.out.println("Rascando con la pata");
    }

    @Override
    public int compareTo(Animal otro) {
        if (this.numPatas == otro.numPatas) return 0;
        else return this.numPatas - otro.numPatas;
    }

    public static void main (String args[]) {
        Animal serpiente = new Animal(0);
        Animal perro = new Animal(4);
        System.out.println(perro.compareTo(serpiente));
    }
}
