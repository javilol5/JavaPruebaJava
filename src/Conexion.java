import java.sql.*;

public class Conexion {

    public static void main (String args []) {
        Connection conexion;
        Statement sentencia;
        String sql;
        PreparedStatement sentenciaP;
        ResultSet resultados;
        String url = "jdbc:postgresql://10.0.8.173:5432/usuarios";

        try{
            conexion = DriverManager.getConnection(url, "postgres", "postgres");
            System.out.println("conectado");
            String crearTaboasql = " CREATE TABLE persoas(nome VARCHAR (50),"
                    +"dni VARCHAR (9), edade INTEGER);";
            //sentencia = conexion.createStatement();
            //sentencia.execute((crearTaboasql));
            //sentencia.executeUpdate("INSERT INTO persoas (nome, dni, edade)"+"VALUES ('Pepe','1234J', 18)");
            //sentencia.executeUpdate("INSERT INTO persoas (nome, dni, edade)"+"VALUES ('Juan','1276O', 24)");
            //sentencia.executeUpdate("INSERT INTO persoas (nome, dni, edade)"+"VALUES ('Aaron','2398P', 89)");
            sql = "INSERT INTO persoas(nome, dni, edade) VALUES (?,?,?)";
            sentenciaP = conexion.prepareStatement(sql);
            sentenciaP.setString(1,"Roque3");
            sentenciaP.setString(2,"123452");
            sentenciaP.setInt(3,28);
            //sentenciaP.executeUpdate(); Para que se haga lo de arriba de sql y eso
            sql = "SELECT nome, dni, edade FROM persoas";
            sentenciaP = conexion.prepareStatement(sql);
            resultados = sentenciaP.executeQuery();
            if (resultados.isBeforeFirst()) System.out.println("antos do primerito encontrados");
            while(resultados.next()){
                if (resultados.isBeforeFirst()) System.out.println("e o primeiro encontrados");
                else if (resultados.isLast()) System.out.println("e o último encontrado");

                String n = resultados.getString("nome");
                String d = resultados.getString("dni");
                int e = resultados.getInt("edade");
                System.out.println("Nombre: "+n+", dni: "+d+", edade: "+e);
            }
            resultados.close();
            sentenciaP.close();
            conexion.close();


            System.out.println(UsuarioDAO.obterUsuario("12345678J"));
            UsuarioDAO.modificarUsuario("12345678J", novoNome, novoEdade);

























        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
