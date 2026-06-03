import java.sql.*;
import java.util.Scanner;

public class UsuarioDAO {

    static Connection conectaBD(String ip, int puerto, String nome, String usuario, String contraseña) {
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

    public static Persoa obterUsuario (String dni) {
        Persoa p = null;
        if (dni != null || dni.length() != 0) {
            Connection conexion = conectaBD("10.0.8.173",5432,"usuarios","postgres","postgres");
            String sql = "SELECT nome, dni, edade FROM persoas WHERE dni = ?";
            try {
                PreparedStatement sentencia = conexion.prepareStatement(sql);
                sentencia.setString(1, dni);
                ResultSet consulta = sentencia.executeQuery();
                consulta.next();
                String nom = consulta.getString("nome");
                String d = consulta.getString("dni");
                int ed = consulta.getInt("edade");
                p = new Persoa(nom, d, ed);
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al importar el usuario: " + e.getMessage());
            }
        }
        return p;
    }

    public static Persoa modificarUsuario(String dni) {

        if (dni != null || dni.length() != 0) {

            Connection conexion = conectaBD("10.0.8.173", 5432, "usuarios", "postgres", "postgres");

            String sql = "SELECT nome, dni, edadeFROM persoas WHERE dni = ?";

            try {
                PreparedStatement sentencia = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                sentencia.setString(1, dni);
                ResultSet consulta = sentencia.executeQuery();
                if (consulta.first()) {
                    Scanner teclado = new Scanner(System.in);
                    System.out.println("Introduce el nuevo nombre del usuario:");
                    String novoNome = teclado.nextLine();
                    System.out.println("Introduce la nueva edad del usuario:");
                    int novoEdade = teclado.nextInt();

                    consulta.updateString("nome", novoNome);
                    consulta.updateInt("edade", novoEdade);
                    consulta.updateRow();
                    System.out.println("Usuario modificado con éxito");
                }


                conexion.close();

            } catch (SQLException e) {
                System.out.println("Erro ao modificar o usuario: " + e.getMessage());
            }
        }

        return null;
    }



}

