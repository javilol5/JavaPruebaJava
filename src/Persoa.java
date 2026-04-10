public class Persoa {
    public String nome;
    public String dni;
    public int edade;

    public Persoa() {
        nome = "";
        dni = "0000000F";
        edade = 0;
    }

    public Persoa(String nome, String dni, int edade) {
        this.nome = nome;
        this.dni = dni;
        this.edade = edade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void main(String [] args) {
        Persoa p1 = new Persoa();
        Persoa p2 = new Persoa("Manuel","1234F",45);
        System.out.println(p1.nome);
        System.out.println(p2.nome + " " + p2.dni + " " + p2.edade);
    }



}
