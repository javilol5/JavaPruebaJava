/*
Crear a aplicación que simula o rexistro das temperaturas, o longo dun día, nunha estación meteorolóxica. A aplicación mostrará un menú coas opcións:
Novo rexistro (o introduciremos manualmente, ainda que se supón que o sistema debería estar automatizado).
Listar rexistros.
Mostar a estatística (cos valores máximo, mínimo e promedio das temperaturas rexistradas ata o momento dende a primeira lectura do dia.
Saír.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class EstacionMetereoloxica {

    public static void mostrarMenu() {
        System.out.println("\n--- ESTACIÓN METEOROLÓXICA ---");
        System.out.println("1. Novo rexistro");
        System.out.println("2. Listar rexistros");
        System.out.println("3. Mostrar estatística");
        System.out.println("0. Saír");
    }

    public static void novoRexistro(ArrayList<Double> rexistros, Scanner sc) {
        System.out.print("Introduce a temperatura: ");
        double temperatura = sc.nextDouble();

        rexistros.add(temperatura);

        System.out.println("Rexistro gardado correctamente.");
    }

    public static void listarRexistros(ArrayList<Double> rexistros) {

        if (rexistros.size() == 0) {
            System.out.println("Non hai rexistros.");
        } else {

            System.out.println("\n--- LISTA DE REXISTROS ---");

            for (int i = 0; i < rexistros.size(); i++) {
                System.out.println(
                        "Rexistro " + (i + 1) + " -> " +
                                rexistros.get(i) + " ºC"
                );
            }
        }
    }

    public static void mostrarEstatistica(ArrayList<Double> rexistros) {

        if (rexistros.size() == 0) {
            System.out.println("Non hai datos para calcular estatísticas.");
        } else {

            double maxima = rexistros.get(0);
            double minima = rexistros.get(0);
            double suma = 0;

            for (int i = 0; i < rexistros.size(); i++) {

                double temperatura = rexistros.get(i);

                if (temperatura > maxima) {
                    maxima = temperatura;
                }

                if (temperatura < minima) {
                    minima = temperatura;
                }

                suma = suma + temperatura;
            }

            double promedio = suma / rexistros.size();

            System.out.println("\n--- ESTATÍSTICAS ---");
            System.out.println("Temperatura máxima: " + maxima + " ºC");
            System.out.println("Temperatura mínima: " + minima + " ºC");
            System.out.println("Temperatura promedio: " + promedio + " ºC");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Double> rexistros = new ArrayList<>();

        int opcion = -1;

        while (opcion != 0) {

            mostrarMenu();

            System.out.print("Escolle unha opción: ");
            opcion = sc.nextInt();

            if (opcion == 1) {

                novoRexistro(rexistros, sc);

            } else if (opcion == 2) {

                listarRexistros(rexistros);

            } else if (opcion == 3) {

                mostrarEstatistica(rexistros);

            } else if (opcion == 0) {

                System.out.println("Saíndo da aplicación...");

            } else {

                System.out.println("Opción non válida.");
            }
        }

        sc.close();
    }
}