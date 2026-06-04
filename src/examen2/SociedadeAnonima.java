package examen2;

/*Clase sociedade anonima
crear clase q modele una empresa

atributos:
razonSocial, cadea de caracteres : privado
cif, cadea de caracteres: privado
actividadePrincipal, cadea de caracteres: privado
representateLegal, cadea de caracteres: privado
oficians, lista de obxectos Oficia

Metodos publicos
getters y setters,
public boolena equals (Object o) que de volta un valor boolenao si o cif e igual o de otura sociedad pasada por parametro
public String toString()
 */
import java.util.ArrayList;

public class SociedadeAnonima {

    private String razonSocial;
    private String cif;
    private String actividadePrincipal;
    private String representanteLegal;
    private ArrayList<Oficina> oficinas;


    public SociedadeAnonima(String razonSocial, String cif, String actividadePrincipal, String representanteLegal) {
        this.razonSocial = razonSocial;
        this.cif = cif;
        this.actividadePrincipal = actividadePrincipal;
        this.representanteLegal = representanteLegal;
        this.oficinas = new ArrayList<>();
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public void setCif(String cif) {
        this.cif = cif;
    }
    public void setActividadePrincipal(String actividadePrincipal) {
        this.actividadePrincipal = actividadePrincipal;
    }
    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }
    public void setOficinas(ArrayList<Oficina> oficinas) {
        this.oficinas = oficinas;
    }

    public String getRazonSocial() {
        return razonSocial;
    }
    public String getCif() {
        return cif;
    }
    public String getActividadePrincipal() {
        return actividadePrincipal;
    }
    public String getRepresentanteLegal() {
        return representanteLegal;
    }
    public ArrayList<Oficina> getOficinas() {
        return oficinas;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SociedadeAnonima outra = (SociedadeAnonima) o;

        return this.cif.equals(outra.cif);


    }

    @Override
    public String toString() {
        return "SociedadeAnonima{" + "razonSocial='" +
                razonSocial + '\'' + ", cif='" +
                cif + '\'' + ", actividadePrincipal='" +
                actividadePrincipal + '\'' + ", representanteLegal='" +
                representanteLegal + '\'' + ", oficinas=" +
                oficinas + '}';
    }
}
