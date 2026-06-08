/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

   @Override
protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    response.getWriter().println("Consulta de productos mediante GET");
}

@Override
protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    String nombre = request.getParameter("nombre");
    String precio = request.getParameter("precio");
    String cantidad = request.getParameter("cantidad");

    request.setAttribute("nombre", nombre);
    request.setAttribute("precio", precio);
    request.setAttribute("cantidad", cantidad);

    request.getRequestDispatcher("resultado.jsp")
            .forward(request, response);
   }
}
