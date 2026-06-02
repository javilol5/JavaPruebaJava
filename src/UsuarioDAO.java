import java.sql.*;

public class UsuarioDAO {

    private static Connection conectaBD (String ip, int puerto, String nome, String usuario, String contraseña) {
        Connection con = null;
        String url = "jdbc:postgresql://" + ip.strip() + ":" + puerto + "/" + nome.strip();
        try{
            con = DriverManager.getConnection(url, usuario, contraseña);
        }catch (SQLException e) {
            System.out.println("error al conectar con el servidor: " + ip + ":" + puerto);
        }
        return con;
    }


    public static void crearUsuario(Persoa usuario) {
        if (usuario != null) {
            Connection conexion = conectaBD ( "10.0.8.173",5432,"usuarios","postgres", "postgres");
            String sql = "INSERT INTO Persoa(nome, dni, edade) + VALUES (?, ?, ?);";


            try{
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, usuario.getNome());
                sentencia.setString(2, usuario.getDni());
                sentencia.setInt(3, usuario.getEdade());
                //sentencia.executeUpdate();
                System.out.println("Usuario creado con éxito");
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al crear el usuario: " + e.getMessage());
            }
        }

    }



}

