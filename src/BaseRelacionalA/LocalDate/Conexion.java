package BaseRelacionalA.LocalDate;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Conexion {
    /**
     * Parametros de conexion
     */
    static String bd = "postgres";
    static String login = "oracle";
    static String password = "oracle";
    static String url = "jdbc:postgresql://localhost:5432/" + bd;

    Connection connection = null;

    /**
     * Constructor de DbConnection
     */
    public Conexion() {
        try {
            //obtenemos la conexión
            connection = DriverManager.getConnection(url, login, password);

            if (connection != null) {
                System.out.println("Conexión a base de datos " + bd + " OK\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Permite retornar la conexión
     */
    public Connection getConnection() {
        return connection;
    }

    public void desconectar() {
        connection = null;
    }

    public void insertarProducto(String codigo, String nombre, float precio, String fechaCaducidad) throws SQLException {
        // Creo un objeto de tipo SimpleDateFormat para poder asignar el formato deseado
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormateada = LocalDate.parse(fechaCaducidad, format);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        // Declaro un tipo Date nulo para poder asignarlo después
        Date fecha = null;
        try {
            fecha = (Date) df.parse(fechaCaducidad); // asigno a fecha el objeto df parseado con el String que recibo en método
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("paerseo mal");
        }
        java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime()); // Creo una fecha de SQL que lo requiere el PreparedStatement y le paso como parametro el date.getTime()
        java.sql.Date fechaSQL1 = java.sql.Date.valueOf(dataFormateada);
        PreparedStatement insertar = connection.prepareStatement("INSERT INTO produtos values (?,?,?,?)");
        // Le paso al insert cada parámetro que quiero insertar en el index que corresponde:
        insertar.setString(1, codigo);
        insertar.setString(2, nombre);
        insertar.setFloat(3, precio);
        insertar.setDate(4, fechaSQL1);
        insertar.execute();
    }

    public void listaProductos() throws SQLException {
        Statement consulta = connection.createStatement(); // Creo un objeto de tipo Statement y le asigno el método createStatement del objeto de conexion
        ResultSet r = consulta.executeQuery("SELECT * from produtos order by codigo"); // Creo un objeto de tipo Resultset y le asigno la query que preciso
        int fila = 1;
        while (r.next()) {
            // Recojo los valores de cada columna de la tabla en función de su index:
            String codigo = r.getString(1);
            String nombre = r.getString(2);
            float prezo = r.getFloat(3);
            String fechaCaducidad = r.getDate(4).toString(); // Por simplicidad, la paso a String
            System.out.println("Fila " + fila + ": " + codigo + " " + nombre + " " + prezo + " " + fechaCaducidad);
            fila++;
        }
    }

    public void actualizaPrecio(String codigo, float prezo) throws SQLException {
        PreparedStatement modificar = connection.prepareStatement("update produtos set prezo = ? * 2 where codigo = ?");
        modificar.setFloat(1, prezo);
        modificar.setString(2, codigo);
        modificar.execute();
    }

    public void eliminarProducto(String codigo) throws SQLException {
        PreparedStatement eliminar = connection.prepareStatement("DELETE FROM produtos where codigo = ?");
        eliminar.setString(1, codigo);
        eliminar.execute();
    }
}
