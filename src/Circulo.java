public class Circulo extends Punto2 implements Area, Perimetro{
    private int radio;

    public Circulo (int x, int y, int radio) {
        super(x,y);
        this.radio = radio;
    }

    public Circulo(int radio) {
    }

    public void setR(int radio) {
        this.radio = radio;
    }
    public int getRadio() {
        return radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return Math.PI * 2 * radio;
    }


}
