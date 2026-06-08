package modelo;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {

    ConexionBD conexionBD = new ConexionBD();
    Connection conexion;

    public void insertarProducto(Producto producto) {

        conexion = conexionBD.conectar();

        String sql = "INSERT INTO productos(nombre_producto, precio, cantidad) VALUES(?,?,?)";

        try {

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, producto.getNombreProducto());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getCantidad());

            ps.executeUpdate();

            System.out.println("Producto registrado correctamente");

        } catch (SQLException e) {

            System.out.println("Error al insertar " + e);

        }
    }

    public void consultarProductos() {

        conexion = conexionBD.conectar();

        String sql = "SELECT * FROM productos";

        try {

            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("ID: " + rs.getInt("id_producto"));
                System.out.println("Nombre: " + rs.getString("nombre_producto"));
                System.out.println("Precio: " + rs.getDouble("precio"));
                System.out.println("Cantidad: " + rs.getInt("cantidad"));
                System.out.println("-------------------------");
            }

        } catch (SQLException e) {

            System.out.println("Error al consultar " + e);

        }
    }

    public void actualizarProducto(int id, double precioNuevo) {

        conexion = conexionBD.conectar();

        String sql = "UPDATE productos SET precio=? WHERE id_producto=?";

        try {

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setDouble(1, precioNuevo);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Producto actualizado");

        } catch (SQLException e) {

            System.out.println("Error al actualizar " + e);

        }
    }

    public void eliminarProducto(int id) {

        conexion = conexionBD.conectar();

        String sql = "DELETE FROM productos WHERE id_producto=?";

        try {

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Producto eliminado");

        } catch (SQLException e) {

            System.out.println("Error al eliminar " + e);

        }
    }
}