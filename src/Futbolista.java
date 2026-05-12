import java.util.Comparator;

public class Futbolista extends Persoa implements Comparable<Persoa> {

    public int numGoles;

    public Futbolista (String nome, String dni, int edade, double estatura, int numGoles) {
        super(nome,dni,edade,estatura);
        this.numGoles = numGoles;
    }

    public int getNumGoles() {
        return numGoles;
    }

    public void setNumGoles(int numGoles) {
        this.numGoles = numGoles;
    }

    @Override
    public String toString() {
        return "-----------------------------" +
                "\nFutbolista: " + nome +
                "\nDni:        " + dni +
                "\nEdad:       " + edade +
                "\nAltura:     " + estatura +
                "\nGoles:      " + numGoles +
                "\n-----------------------------";}

    // equals  dni
    @Override
    public boolean equals(Object obj) {

        Futbolista otroFutbolista = (Futbolista) obj;
        if (this.dni == otroFutbolista.dni) return true;
        return false;
    }


    // comparador dni

    public int compareTo(Futbolista otro) {
        return this.dni.compareTo(otro.dni);
    }

    // comparador nome
    public static Comparator<Futbolista> comparadorNome = new Comparator<Futbolista>() {
        @Override
        public int compare(Futbolista f1, Futbolista f2) {
            return f1.nome.compareToIgnoreCase(f2.nome);
        }
    };

    // comparador numGoles
    public static Comparator<Futbolista> comparadorNumGoles = new Comparator<Futbolista>() {

        @Override
        public int compare(Futbolista f1, Futbolista f2) {
            return Integer.compare(f1.numGoles, f2.numGoles);
        }
    };

    public static void main(String [] args) {
        Futbolista f1 = new Futbolista("Messi","1010M",38,1.70, 672);
        Futbolista f2 = new Futbolista("Cr7","7777C",41,1.87, 971);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f1.compareTo(f2));
        System.out.println(f1.equals(f2));
        System.out.println(f1.nome.equals(f2.nome));
        f2.setNome("Messi");
        System.out.println(f1.nome.equals(f2.nome));


    }
}
