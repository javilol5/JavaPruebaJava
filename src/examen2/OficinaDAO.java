package examen2;
import java.sql.*;
import java.util.ArrayList;

/*
Completar la clase con los siguentes metodos:
public static ArrayList<Oficina> importarOficinasPorCif (String cif)
onde o metodo fai unha consulta na taboa oficinas
seleccionando os centros de traballo dunha empresa polo seu codigo de identificacion fiscal (cif)

As oficinas obtidas se devoltan nunha lista de obxectos da clase Oficina

 */
public class OficinaDAO {
    /**
     * Xestión da táboa oficina en PostgreSQL.
     */

    //  Conexión
    String url = "jdbc:postgresql://10.0.8.173:5432/oficina";
    String usuario = "postgres";
    String contrasinal = "postgres";


    static Connection conectar(String url, String usuario, String contrasinal) {
        Connection con = null;
        System.out.println("Conectando á base de datos...");
        try {
            con = DriverManager.getConnection(url, usuario, contrasinal);
        } catch (SQLException e) {
            System.out.println("Erro realizando a conexión a base de datos.\n");
        }
        System.out.println("Conexión establecida correctamente.\n");
        return con;
    }

    //  creación da táboa

    public static void crearTaboa()  {
        Connection con = conectar("jdbc:postgresql://10.0.8.173:5432/oficina", "postgres", "postgres");
        String sql = """
                CREATE TABLE IF NOT EXISTS oficina (
                    cif         VARCHAR(9)   PRIMARY KEY,
                    nome        VARCHAR(100) NOT NULL,
                    direccion   VARCHAR(200) NOT NULL,
                    localidade  VARCHAR(100) NOT NULL,
                    provincia   VARCHAR(100) NOT NULL
                )
                """;
        try {
            Statement st = con.createStatement();
            st.execute(sql);
            con.close();
            System.out.println("Táboa 'oficina' creada (ou xa existía).\n");
        } catch ( SQLException e){
            System.out.println("Erro o crear a táboa");
        }
    }

    //  inserción de datos de exemplo

    public static void inserirDatosExemplo(){
        Connection con = null;
        try {
            con = conectar("jdbc:postgresql://10.0.8.173:5432/oficina", "postgres", "postgres");
            String sql = """ 
INSERT INTO oficina (cif, nome, direccion, localidade, provincia)
                                VALUES ("B36012345", "Industrias Galicia S.L.",       "Rúa do Mar 12",          "Vigo",          "Pontevedra") """;
            Statement ps = con.createStatement();
            ps.executeUpdate(sql);
            sql = """
 INSERT INTO oficina (cif, nome, direccion, localidade, provincia)
                          VALUES ("A15098765", "Construcións do Norte S.A.",    "Avda. da Coruña 45",     "A Coruña",      "A Coruña") """;
            ps.executeUpdate(sql);
            sql = """ 
INSERT INTO oficina (cif, nome, direccion, localidade, provincia)
                          VALUES ("B27054321", "Servizos Lugo S.L.",            "Praza Maior 3",          "Lugo",          "Lugo") """;

            ps.executeUpdate(sql);
            sql = """ 
INSERT INTO oficina (cif, nome, direccion, localidade, provincia)
                        VALUES ("A32011223", "Tecnoloxías Ourense S.A.",      "Rúa Progreso, 88",        "Ourense",       "Ourense") """;
            ps.executeUpdate(sql);
            sql = """ 
INSERT INTO oficina (cif, nome, direccion, localidade, provincia)
                          VALUES ("B36099887", "Pesca e Mar Cooperativa",       "Porto Pesqueiro, s/n",    "Marín",         "Pontevedra") """;
            ps.executeUpdate(sql);
            con.close();
            System.out.printf("Datos de exemplo insertados");
        }catch (SQLException e){
            System.out.println("Erro o insertar os datos de exemplo: " + e.getMessage());
        }
    }
    public static ArrayList<Oficina> importarOficinasPorCif(String cif) {

        ArrayList<Oficina> oficinas = new ArrayList<>();

        String sql = """
            SELECT nome, direccion, localidade, provincia
            FROM oficina
            WHERE cif = ?
            """;

        try {
            Connection con = conectar("jdbc:postgresql://10.0.8.173:5432/oficina", "postgres", "postgres");

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cif);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Oficina o = new Oficina(
                        rs.getString("nome"),
                        rs.getString("direccion"),
                        rs.getString("localidade"),
                        rs.getString("provincia")
                );

                oficinas.add(o);
            }

            con.close();

        } catch (SQLException e) {
            System.out.println("Error al importar oficinas: " + e.getMessage());
        }

        return oficinas;
    }
    public static void actualizarOficina(Oficina o, String cif) {

        String sql = """
            UPDATE oficina
            SET nome = ?,
                direccion = ?,
                localidade = ?,
                provincia = ?
            WHERE cif = ?
            """;

        try {

            Connection con = conectar("jdbc:postgresql://10.0.8.173:5432/oficina", "postgres", "postgres");

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, o.getNome());
            ps.setString(2, o.getDireccion());
            ps.setString(3, o.getLocalidade());
            ps.setString(4, o.getProvincia());
            ps.setString(5, cif);

            int filas = ps.executeUpdate();

            System.out.println("Filas actualizadas: " + filas);

            con.close();

        } catch (SQLException e) {
            System.out.println("Erro ao actualizar oficina: " + e.getMessage());
        }
    }
}