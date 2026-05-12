public abstract class Punto {

    public double x;
    public double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();

    @Override
    public String toString() {
        return "Punto{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

//    public static void main(String [] args) {
//        Punto p1 = new Punto(2,3);
//        System.out.println(p1);
//    }
}
