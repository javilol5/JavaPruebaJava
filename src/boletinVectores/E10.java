package boletinVectores;

//10. Deseña a función que realice o borrado dun elemento nunha táboa.
//A táboa e o valor se pasan como parámetros
//Facer o exercicio para os dous casos:
//Táboa desordeada.
//Táboa ordeada.

public class E10 {
    public static void main(String[] args) {
        int[] ordenada = {1,2,3,4,5,6,7,8,9,10};
        int[] desordenada = {1,4,6,9,2,10,3,5,7,8};

        ordenada = borrarOrdenado(ordenada, 5);
        desordenada = borrarDesordenado(desordenada, 5);

        System.out.println(java.util.Arrays.toString(ordenada));
        System.out.println(java.util.Arrays.toString(desordenada));
    }

    public static int[] borrarOrdenado(int[] tabla, int valor) {
        int posicion = -1;

        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] == valor) {
                posicion = i;
                break;
            }
            if (tabla[i] > valor) {
                break;
            }
        }

        if (posicion == -1) return tabla;

        int[] nueva = new int[tabla.length - 1];

        for (int i = 0, j = 0; i < tabla.length; i++) {
            if (i != posicion) {
                nueva[j] = tabla[i];
                j++;
            }

        }

        return nueva;
    }

    public static int[] borrarDesordenado(int[] tabla, int valor) {
        int posicion = -1;

        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] == valor) {
                posicion = i;
                break;
            }
        }

        if (posicion == -1) return tabla;

        tabla[posicion] = tabla[tabla.length - 1];

        int[] nueva = new int[tabla.length - 1];
        for (int i = 0; i < nueva.length; i++) {
            nueva[i] = tabla[i];
        }

        return nueva;
    }
}