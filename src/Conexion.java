import java.sql.*;
import UsuarioDAO;

public class Conexion {

    public static void main (String args []) {
        Connection conexion;
        Statement sentencia;
        String sql;
        String url = "jdbc:postgresql://10.0.8.173:5432/usuarios";

        try {
            conexion = DriverManager.getConnection(url, "postgres", "postgres");
            System.out.println("Conectado");
            String crearTaboaSQL = "CREATE TABLE persoas(nome VARCHAR (50),dni VARCHAR (9),edade INTEGER);";
            sentencia = conexion.createStatement();
//            sentencia.execute(crearTaboaSQL);
//
//
//            sentencia.executeUpdate("INSERT INTO persoas(nome, dni, edade)" + "VALUES ('Pepe', '12345678J',23);");
//            sentencia.executeUpdate("INSERT INTO persoas(nome, dni, edade)" + "VALUES ('Manuel', '23456781P',27);");
//            sentencia.executeUpdate("INSERT INTO persoas(nome, dni, edade)" + "VALUES ('Daniel', '32145678F',98);");
//            sentencia.executeUpdate("INSERT INTO persoas(nome, dni, edade)" + "VALUES ('Juan', '87654321J',18);");
            System.out.println("Datos insertados");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        resultados.close();
        sentenciaP.close();
        conexion.close();
        //Usando obxecto DAO
        UsuarioDAO.crearUsuario (new Persoa("Victor","88888",45,1.90));


    }



}
