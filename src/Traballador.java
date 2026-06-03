public class Traballador extends Persoa{

    public double salario;
    public String estaturaT;

    public Traballador (String nome, String dni, int edade/*, double estatura*/, double salario, String estaturaT ) {
        super(nome,dni,edade/*,estatura*/);
        this.salario = salario;
        this.estaturaT = estaturaT;
    }

    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(salario + estatura);
    }

    public static void main (String [] args) {
        Traballador t = new Traballador("Pepe","1111H",37/*,1.81*/, 1490, "XL");
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
