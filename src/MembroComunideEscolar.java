public class MembroComunideEscolar extends Persoa {
    private int codigoCentro;
    private String nomeCentro;

    public MembroComunideEscolar (String nome, String dni, int edade, int codCentro, String nomCentro){
        super(nome,dni,edade);
        this.codigoCentro = codCentro;
        this.nomeCentro = nomCentro;
    }

    public MembroComunideEscolar() {
        super();
        this.codigoCentro = 0;
        this.nomeCentro = "desconocido";

    }

    public int getCodigoCentro() {
        return this.codigoCentro;
    }

    public void setCodigoCentro(int novoCodCentro){
        if (novoCodCentro>0) codigoCentro = novoCodCentro;
        else codigoCentro = 0;
    }

}
