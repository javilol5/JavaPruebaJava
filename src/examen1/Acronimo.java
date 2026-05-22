package examen1;

public class Acronimo {
    public static String crearAcronimo = "Little By Little";
    public static void main(String[] args) {
        String espacios = crearAcronimo.trim();
        char letra1 = espacios.charAt(0);
        char letra2 = espacios.charAt(7);
        char letra3 = espacios.charAt(10);
        System.out.println( letra1 + "" + letra2 + "" + letra3);
    }
}
