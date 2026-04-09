public class Hora {
    public int horas;
    public int minutos;
    public int segundos;

    public Hora() {
        horas = 0;
        minutos = 0;
        segundos = 0;
    }

    public Hora(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Hora(String hora) {
        String[] partes = hora.split(":");

        this.horas = Integer.parseInt(partes[0]);
        this.minutos = Integer.parseInt(partes[1]);
        this.segundos = Integer.parseInt(partes[2]);
    }

    public Hora(double hora) {

        this.horas = (int) hora;
        double fraccion = hora - this.horas;

        double minutosDecimal = fraccion * 60;
        this.minutos = (int) minutosDecimal;

        double segundosDecimal = (minutosDecimal - this.minutos) * 60;
        this.segundos = (int) Math.round(segundosDecimal);

    }

    public Integer getHoras() {
        return this.horas;
    }
    public void setHoras(String nome) {
        this.horas = horas;
    }

    public Integer getMinutos() {
        return this.minutos;
    }
    public void setMinutos(String nome) {
        this.minutos = minutos;
    }

    public Integer getSegundos() {
        return this.segundos;
    }
    public void setSegundos(String nome) {
        this.segundos = segundos;
    }

    public static void main(String [] args) {
        Hora h1 = new Hora(12.23);

        System.out.println(h1.getHoras());
        System.out.println(h1.getMinutos());
        System.out.println(h1.getSegundos());
    }

}

