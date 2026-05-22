package examen1;

public class Cancion implements Comparable<Cancion> {
    private String titulo;
    private String artista;
    private int numReproducciones;

    public Cancion(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
        this.numReproducciones = 0;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public int getReproducciones() {
        return numReproducciones;
    }
    public void setReproducciones(int numReproducciones) {
        this.numReproducciones = numReproducciones;
        this.numReproducciones += 1;
    }
    @Override
    public String toString() {
        return getTitulo() + " " + getArtista() + " " + getReproducciones();
    }
    @Override
    public int compareTo(Cancion o) {
        if (this.numReproducciones < o.numReproducciones) {
            return 1;
        } else if (this.numReproducciones > o.numReproducciones) {
            return -1;
        } else {
            return 0;
        }
    }
}
