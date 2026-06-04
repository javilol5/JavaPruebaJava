package examen2;

import java.util.Comparator;

public class Oficina {
    private String nome;
    private String direccion;
    private String localidade;
    private String provincia;

    public Oficina(String nome, String direccion, String localidade, String provincia) {
        this.nome = nome;
        this.direccion = direccion;
        this.localidade = localidade;
        this.provincia = provincia;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNome() {
        return nome;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getProvincia() {
        return provincia;
    }

    @Override
    public String toString() {
        return "Oficina{" +
                "nome='" + nome + '\'' +
                ", direccion='" + direccion + '\'' +
                ", localidade='" + localidade + '\'' +
                ", provincia='" + provincia + '\'' +
                '}';
    }

    /*
    interface comparator Crear la interfaz Comparator en la clase Ofician para que permita hacer la comparacion entre oficians. El metodo comparara
    por nome, provincia, localidade, e direccion(en ese orden)

     */

    public static Comparator<Oficina> COMPARADOR_OFICINAS = new Comparator<Oficina>() {
        @Override
        public int compare(Oficina ofi1, Oficina ofi2) {

            int resultado = ofi1.nome.compareTo(ofi2.nome);

            if (resultado == 0) {
                resultado = ofi1.provincia.compareTo(ofi2.provincia);
            }

            if (resultado == 0) {
                resultado = ofi1.localidade.compareTo(ofi2.localidade);
            }

            if (resultado == 0) {
                resultado = ofi1.direccion.compareTo(ofi2.direccion);
            }

            return resultado;
        }
    };


}

