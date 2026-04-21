public class exemplosArray {

    public static String main (String [] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        char[] letras = new char[10];
        letras[0] = 'a';
        letras[1] = 'b';

        for (int i = 0; i < 10; i++) {
            System.out.println("A letra e: " + letras[i]);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Onumero e: " + numeros[i]);
        }

        for (int n : numeros) {
            System.out.println("Onumero e: " + n);
        }


        String[] nomes;
        nomes = new String[10];
        nomes[0] = "Hugo";
        nomes[1] = "Pedro";
        nomes[2] = new String("Ana");

        Persoa[] equipo;
        equipo = new Persoa[5];
        equipo[0] = new Persoa("Ramon", "4567U", 23);
        equipo[1] = new Persoa("Jose", "8642H", 32);
        equipo[2] = new Persoa("Carmen", "9876Y", 41);
        equipo[3] = new Persoa("Tina", "1234R", 17);
        equipo[4] = new Persoa("Pili", "3258T", 33);


//        int mediaEdade() {
//            int edades = 0;
//            int personas = 0;
//
//            for (Persoa persona : equipo) {
//                edades = edades + persona.getEdade();
//                personas++;
//            }
//
//            return edades / personas;
//        }
        int suma = 0;
        int personitas = 0;
        for (int i = 0; i < 5; i++) {
            //Persoa integrante = equipo [i]
            suma = suma + equipo[i].edade;
            personitas += 1;
            System.out.println("A media de edade e: " + suma/equipo.length);

        }


//        int cantidadLetras() {
//            int cantletras = 0;
//
//            for (Persoa persona : equipo) {
//                int longitud = persona.getNome().length();
//                cantletras += longitud;
//            }
//
//            return cantletras;
//        }


        for (Persoa p: equipo){
            int numLetras = 0;
            for (;numLetras < p.nome.length(); numLetras++){
                numLetras++;
                System.out.println("As letras contadas de " + p.nome + " son: " + numLetras);
                System.out.println("As letras de " + p.nome + " son " + p.nome.length());
            }
        }

//        String dniBajo() {
//            String menorDni = equipo[0].getDni();
//            char menorLetra = menorDni.charAt(menorDni.length() - 1);
//
//            for (Persoa persona : equipo) {
//                String dniActual = persona.getDni();
//                char letraActual = dniActual.charAt(dniActual.length() - 1);
//
//                if (letraActual < menorLetra) {
//                    menorLetra = letraActual;
//                    menorDni = dniActual;
//                }
//            }
//
//            return menorDni;
//        }


        Persoa dniMenor = equipo[0];
        for (int i = 1; i < equipo.length; i++){
            if (dniMenor.dni.compareTo(equipo[i].dni)>0){
                dniMenor = equipo[i];
            }
        }
        System.out.println("O dni " + dniMenor.dni + " de " + dniMenor.nome + " e lexicograficamente menor");

    }

}
