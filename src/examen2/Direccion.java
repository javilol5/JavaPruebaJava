package examen2;

import java.sql.*;

/*
Crear clase direccion sin propiedades ni constructor
metodos publicos:
motodo estatico public boolena comprobarDireccion (String direccion)
solo puede ser: Praza, Calle, Baixada, Parroquia.
continuado de el nombre que puede ser cualquier cosa.
acabado por un "-"
seguido de "Num:" seguido de un numero
seguido de "Portal:" seguido de una letra o numero representando el portal
seguido de "Planta:" seguido de un numero

 */
public class Direccion {

    public static boolean ComprobarDireccion(String direccion) {
        //Praza Compostela - NUM: 4 Portal: 10 Planta: 4
//        "{nomeRua} - NUM: {num} Portal: {numPortal} Planta: {numPlanta}"
        if (direccion == null) {
            return false;
        }

        String[] partes = direccion.split("-");
        if (partes.length != 2) {
            return false;
        }
        String nomerua = partes[1];
        String[] tipos = {"Praza", "Calle", "Baixada", "Parroquia"};

        String parte0 = partes[0];

        boolean tipoValido = false;

        for (int i = 0; i < tipos.length; i++) {
            if (parte0.startsWith(tipos[i])) {
                tipoValido = true;
                break;
            }
        }

        if (!tipoValido) {
            return false;
        }
        if (!nomerua.contains("Num:")) {
            return false;
        }

        String[] numSplit = nomerua.split("Num:");

        if (numSplit.length != 2) {
            return false;
        }

        String resto = numSplit[1];

        if (!resto.contains("Portal:")) {
            return false;
        }

        String[] portalSplit = resto.split("Portal:");

        if (portalSplit.length != 2) {
            return false;
        }

        String despuesPortal = portalSplit[1];

        if (!despuesPortal.contains("Planta:")) {
            return false;
        }

        String[] plantaSplit = despuesPortal.split("Planta:");

        if (plantaSplit.length != 2) {
            return false;
        }

        String numero = numSplit[1].split("Portal:")[0];
        String portal = portalSplit[1].split("Planta:")[0];
        String planta = plantaSplit[1];

        try {
            Integer.parseInt(numero);
            Integer.parseInt(planta);
        } catch (NumberFormatException e) {
            return false;
        }

        if (portal.length() != 1 || !Character.isLetterOrDigit(portal.charAt(0))) {
            return false;
        }

        return true;
    }

}

