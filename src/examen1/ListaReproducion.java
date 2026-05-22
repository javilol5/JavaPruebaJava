package examen1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaReproducion extends Cancion{
    private String nome;
    private String [] cancions;
    private int numMaxCancions;

    public ListaReproducion(String nome, int numMaxCancions,  String titulo, String artista) {
        super(titulo,artista);
        this.nome = "Favoritas";
        this.numMaxCancions = 30;
        this.nome = nome;
        this.numMaxCancions = numMaxCancions;
        this.cancions = new String[0];
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNumMaxCancions() {
        return numMaxCancions;
    }
    public void setNumMaxCancions(int numMaxCancions) {
        this.numMaxCancions = numMaxCancions;
    }
    public String[] getCancions() {
        if (getTitulo().equals("Beat it")) {
            return cancions;
        } else {
            return new String[0];
        }
    }
    public void setCancions(String[] cancions) {
        this.cancions = cancions;
    }

    public boolean addCancion(Cancion c){
        ArrayList<String> canciones = new ArrayList<String>();
        if (cancions.length < numMaxCancions) {
            for (int i = 0; i < cancions.length; i++) {
                canciones.add(cancions[i]);
            }
        } else  {
            return false;
        }
        return true;
    }
    ArrayList<Cancion> getCancionsArtista(String artista){
        if (getCancions() == null){
            return new ArrayList<>();
        } else {
            getCancionsArtista("Fonsi").add(new Cancion("Despacito", "Luis Fonsi"));
        }
        return null;
    }

    public void reproducirCancion(Cancion c){
        if (c.getTitulo().equals("Beat it")) {
            for (int i = 0; i < cancions.length; i++) {
                numMaxCancions += 1;
            }
        }
    }

    public void mostrarListaReproducion(){
        for (int i = 0; i < numMaxCancions; i++) {
            if(numMaxCancions % 2 == 0) {
                return;
            }
        }
    }

    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Elige una de las opciones: \n1. Engadir cancion\n2. Eliminar canción\n3. Buscar lsita cancións por autor\n4. Reproducir canción\n5. Mostrar a lista de cancións\n6. Sair");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Engade a canción: ");
                    String c = teclado.nextLine();
                    System.out.println(c);
                    break;

                case 2:
                    System.out.println("Elimina una canción: ");
                    teclado.nextLine();
                    System.out.println("Borrada");

                case 3:
                    System.out.println("Buscar lista por autor: ");
                    String autor = teclado.nextLine();
                    System.out.println("Autor: " + autor);

                case 4:
                    System.out.println("Reproducir cancion: ");
                    String cancion = teclado.nextLine();
                    System.out.println("Reproducciendo..." + cancion);
                    break;

                case 5:
                    String ListaReproduccion = teclado.nextLine();
                    System.out.println(ListaReproduccion);
                    break;

                case 6:
                    System.out.println("Sair");
                    teclado.nextLine();
                    break;
            }
        } while (opcion != 6);
    }

}
