/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import APIs.APIpacientes;
import APIs.doctoresAPI;
import APIs.pacientesAPI;
import Controllers.pruebaxD.Doctor;
import Controllers.pruebaxD.Paciente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "abrirRegistroExpedientes", urlPatterns = {"/abrirRegistroExpedientes"})
public class abrirRegistroExpedientes extends HttpServlet {

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
            out.println("<title>Servlet abrirRegistroExpedientes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet abrirRegistroExpedientes at " + request.getContextPath() + "</h1>");
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
        String doctor = request.getParameter("doctor");
        String paciente = request.getParameter("paciente");
        RequestDispatcher requestD;
        requestD = request.getRequestDispatcher("registroExpedientes.jsp");
         ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.getDeserializationConfig().with(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        APIpacientes pac = new APIpacientes();
        String result = pac.find_JSON(String.class, paciente);
        Paciente p = mapper.readValue(result, Paciente.class);
        
        pacientesAPI paci = new pacientesAPI();
        String resul = paci.findAll_JSON(String.class);
        List<pruebaxD.DocumentosPacientes> documentos = mapper.readValue(resul, new TypeReference<List<pruebaxD.DocumentosPacientes>>() {
        });
        List<pruebaxD.DocumentosPacientes> documentosPaciente = new ArrayList();
        for (pruebaxD.DocumentosPacientes documento : documentos) {
            if (documento.getPaciente().getCurp().equals(p.getCurp())) {
                documentosPaciente.add(documento);
            }
        }
        doctoresAPI doc = new doctoresAPI();
        String docr = doc.find_JSON(String.class, doctor);
        Doctor docC = mapper.readValue(docr, Doctor.class);
        request.setAttribute("paciente", p);
        request.setAttribute("doctor",docC);
        request.setAttribute("documentos", documentosPaciente);
        
       requestD.forward(request, response);
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
