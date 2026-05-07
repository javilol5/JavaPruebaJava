public class Circulo extends Punto{
    private int radio;

    public Circulo (int x, int y, int radio) {
        super(x,y);
        this.radio = radio;
    }

    public void setR(int radio) {
        this.radio = radio;
    }
    public int getRadio() {
        return radio;
    }
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }




}
