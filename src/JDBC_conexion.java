import java.sql.*; // Importa las clases necesarias para trabajar con JDBC

public class JDBC_conexion {

    // URL de conexión a la base de datos MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/bd_babelduo";

    // Usuario de la base de datos
    private static final String USER = "root";

    // Contraseña de la base de datos
    private static final String PASSWORD = "";

    public static void main(String[] args) {

        try {

            // Carga el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establece la conexión con la base de datos
            Connection conexion =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            System.out.println("Conexion exitosa");

            // Permite ejecutar sentencias SQL
            Statement statement = conexion.createStatement();

            // ==============================
            // INSERTAR PRIMER REGISTRO
            // ==============================

            String insert1 =
                    "INSERT INTO users(first_name,last_name,email,password,language_id) "
                    + "VALUES ('Carlos Andres', 'Lopez Marin', "
                    + "'carlos1@gmail.com', '12345', 1)";

            statement.executeUpdate(insert1);

            System.out.println("Primer registro insertado correctamente");

            // ==============================
            // INSERTAR SEGUNDO REGISTRO
            // ==============================

            String insert2 =
                    "INSERT INTO users(first_name,last_name,email,password,language_id) "
                    + "VALUES ('Maria Lopez', 'Gomez Ruiz', "
                    + "'maria@gmail.com', '54321', 2)";

            statement.executeUpdate(insert2);

            System.out.println("Segundo registro insertado correctamente");

            // ==============================
            // INSERTAR TERCER REGISTRO
            // ==============================

            String insert3 =
                    "INSERT INTO users(first_name,last_name,email,password,language_id) "
                    + "VALUES ('Jesus Maria', 'Cardona Restrepo', "
                    + "'jesus12@gmail.com', '678945', 6)";

            statement.executeUpdate(insert3);

            System.out.println("Tercer registro insertado correctamente");


            // Cerrar recursos
           
            statement.close();
            conexion.close();

            System.out.println("Conexion cerrada");

        } catch (ClassNotFoundException e) {

            // Error si no se encuentra el driver JDBC
            System.out.println(
                    "Error Driver: " + e.getMessage()
            );

        } catch (SQLException e) {

            // Error relacionado con MySQL
            System.out.println(
                    "Error SQL: " + e.getMessage()
            );
        }
    }
}