/*Conectarse BD
Definir Consulta
Crear statement/prepare statement
executar statement
recorrer resulset y crear lista objetos
retornar lista
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO2 {
    public static ArrayList<Persoa> obterUsuarios() {

        ArrayList<Persoa> lista = new ArrayList<>();

        Connection conexion = UsuarioDAO.conectaBD(
                "10.0.8.173",
                5432,
                "usuarios",
                "postgres",
                "postgres");

        String sql = "SELECT nome, dni, edade, estatura FROM persoas";

        try {

            PreparedStatement sentencia =
                    conexion.prepareStatement(sql);

            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String nome = resultados.getString("nome");
                String dni = resultados.getString("dni");
                int edade = resultados.getInt("edade");
                double estatura = resultados.getDouble("estatura");

                Persoa p = new Persoa(nome, dni, edade/*,estatura*/);

                lista.add(p);
            }

            resultados.close();
            sentencia.close();
            conexion.close();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return lista;
    }
}
