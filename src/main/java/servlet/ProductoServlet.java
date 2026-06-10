package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet encargado de procesar el registro de productos
 * del sistema de inventario de la papelería.
 *
 * @author Asus
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    /**
     * Método GET utilizado para consultar información.
     *
     * @param request solicitud HTTP enviada por el cliente
     * @param response respuesta HTTP enviada al cliente
     * @throws ServletException si ocurre un error en el servlet
     * @throws IOException si ocurre un error de entrada o salida
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Mensaje de prueba para solicitudes GET
        response.getWriter().println("Consulta de productos mediante GET");
    }

    /**
     * Método POST utilizado para recibir los datos enviados
     * desde el formulario de registro de productos.
     *
     * @param request solicitud HTTP enviada por el cliente
     * @param response respuesta HTTP enviada al cliente
     * @throws ServletException si ocurre un error en el servlet
     * @throws IOException si ocurre un error de entrada o salida
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener los datos enviados desde el formulario
        String nombre = request.getParameter("nombre");
        String precioTexto = request.getParameter("precio");
        String cantidadTexto = request.getParameter("cantidad");

        // Validar que el nombre no esté vacío
        if (nombre == null || nombre.trim().isEmpty()) {
            response.getWriter().println("Error: El nombre del producto es obligatorio.");
            return;
        }

        try {

            // Convertir los datos numéricos
            double precio = Double.parseDouble(precioTexto);
            int cantidad = Integer.parseInt(cantidadTexto);

            // Validar precio
            if (precio <= 0) {
                response.getWriter().println("Error: El precio debe ser mayor que cero.");
                return;
            }

            // Validar cantidad
            if (cantidad < 0) {
                response.getWriter().println("Error: La cantidad no puede ser negativa.");
                return;
            }

            // Enviar los datos a la página JSP
            request.setAttribute("nombre", nombre);
            request.setAttribute("precio", precio);
            request.setAttribute("cantidad", cantidad);

            // Mostrar el resultado
            request.getRequestDispatcher("resultado.jsp")
                    .forward(request, response);

        } catch (NumberFormatException e) {

            // Mensaje en caso de error de conversión
            response.getWriter().println("Error: Los valores ingresados no son válidos.");
        }
    }
}