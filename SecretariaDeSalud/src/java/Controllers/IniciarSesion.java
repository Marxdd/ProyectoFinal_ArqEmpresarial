/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import APIs.APIpacientes;
import APIs.doctoresAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos
 */
@WebServlet(name = "IniciarSesion", urlPatterns = {"/IniciarSesion"})
public class IniciarSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IniciarSesion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IniciarSesion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           String curp = request.getParameter("curp");
        String contra = request.getParameter("contrasena");
        String destino = "registro.html";
        RequestDispatcher requestD = request.getRequestDispatcher(destino);
        if (comprobarCredenciales(curp, contra)) {
             requestD.forward(request, response);
        }else{
        try (PrintWriter out = response.getWriter()) {
                out.println("<script type='text/javascript'>alert('Credenciales incorrectas');location='index.html';</script>");
            }
        
        processRequest(request, response);
        }
    }

    
    private static boolean comprobarCredenciales(String curp,String contra){
         doctoresAPI doc = new doctoresAPI();
        String resultados = doc.findAll_JSON(String.class);
        APIpacientes pac = new APIpacientes();
        String resultados2 = pac.findAll_JSON(String.class);
     //   System.out.println("doctores");
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        try {
            List<pruebaxD.Doctor> doctores = mapper.readValue(resultados, new TypeReference<List<pruebaxD.Doctor>>() {});
            //System.out.println(doctores);
            for (pruebaxD.Doctor doctore : doctores) {
                if (contra.equalsIgnoreCase(doctore.getContraseña()) && curp.equalsIgnoreCase(doctore.getCurp())) {
                    return true;
                }
            }
            System.out.println("pacientes");
            List<pruebaxD.Paciente> pacientes = mapper.readValue(resultados2, new TypeReference<List<pruebaxD.Paciente>>() {});
            for (pruebaxD.Paciente paciente : pacientes) {
                  if (contra.equalsIgnoreCase(paciente.getContraseña()) && curp.equalsIgnoreCase(paciente.getCurp())) {
                    return true;
                }
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(pruebaxD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
