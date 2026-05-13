public class Cilindro2 extends Circulo implements Area, Volumen, Perimetro {
    private double altura;

    public Cilindro2(int radio, double altura) {
        super(radio);
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return 2 * Math.PI * getRadio() * (getRadio() + altura);
    }

    @Override
    public double calcularVolumen() {
        return Math.PI * Math.pow(getRadio(), 2) * altura;
    }
}
