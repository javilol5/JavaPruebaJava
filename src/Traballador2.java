public class Traballador2 extends Persoa{

    public double salario;
    public String estaturaT;

    public Traballador2 (String nome, String dni, int edade, double estatura, double salario, String estaturaT ) {
        super(nome,dni,edade/*,estatura*/);
        this.salario = salario;
        this.estaturaT = estaturaT;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(salario + estatura);
    }

    @Override
    public boolean equals(Object outro) {
        Traballador2 outroTraballador = (Traballador2) outro;
        if (this.estatura == outroTraballador.estatura) return true;
        return false;
    }

    public static void main (String [] args) {
        Traballador2 t = new Traballador2("Juan","2222J",46,1.93, 1380, "M");
        Persoa p = new Persoa("Pepe", "1111H", 37/*, 1.81*/);
        Persoa persoas [] = new Persoa[2];
        persoas[0] = p;
        persoas[1] = t;
        Persoa unTraballador = t;
        System.out.println("executando exemplo traballador");
        System.out.println(persoas[1].estatura);
        System.out.println(unTraballador.estatura);
        System.out.println(t.estatura);
        unTraballador.mostrarDatos();;
        t.mostrarDatos();
    }
}
