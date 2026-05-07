
//9. Crear a función que reciba como parámetro unha táboa
//unidimensional e devolte outra táboa cos valores da primeira,
//pero na que non haxa repeticións nos valores.

package boletinVectores;

import java.util.ArrayList;
import java.util.List;

public class E9 {
    public static void main(String[] args) {

        int[] datos = {1,2,4,4,5,3,1,2,3,0,5,4,12};

        List<Integer> resultado = recorer(datos);

        System.out.println(resultado);
    }

    public static List<Integer> recorer(int[] listaOriginal){
        List<Integer> lista = new ArrayList<>();

        for (int num : listaOriginal) {
            if (!lista.contains(num)) {
                lista.add(num);

            }
            System.out.println(lista);
        }

        return lista;
    }
}
