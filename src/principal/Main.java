package principal;

import modelo.Producto;
import modelo.ProductoDAO;

public class Main {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();

        Producto producto = new Producto();

        producto.setNombreProducto("Cuaderno");
        producto.setPrecio(5500);
        producto.setCantidad(20);

        dao.insertarProducto(producto);

        dao.consultarProductos();

        dao.actualizarProducto(1, 6000);

        dao.eliminarProducto(1);

    }
}