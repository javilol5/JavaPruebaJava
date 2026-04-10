public class Alumno extends MembroComunideEscolar{

    public String curso;
    public int asignaturas;




    public Alumno (String nome, String dni, int edade, int codCentro, String nomCentro, String curso, int asignaturas){
        super(nome,dni,edade,codCentro,nomCentro);
        this.curso = curso;
        this.asignaturas = asignaturas;
    }

    public Alumno() {
        super();
        curso = "desconocido";
        asignaturas = 0;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getAsignaturas() {
        return this.asignaturas;
    }

    public void setAsignaturas(int nome) {
        this.asignaturas = asignaturas;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "curso='" + curso + '\'' +
                ", asignaturas=" + asignaturas +
                '}';
    }

    public static void main(String [] args) {
        Alumno a2 = new Alumno("a","a",1,2,"a","a",2);
        System.out.println(a2.nome + " " + a2.dni + " " + a2.edade + " ");
    }
}
