<%-- 
    Document   : listaExpedientes
    Created on : 16/05/2022, 04:47:12 AM
    Author     : Carlos
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${(empty paciente) and (empty doctor)}">
    <c:redirect url = "index.html"/>
</c:if>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Lista de expedientes</title>
    </head>
    <body>
        <section class="seccion">
            <table id="tableCSS">
                <tr>     
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Curp</th>
                    <th>Correo</th>
                    <th>Teléfono</th>
                    <th>ver documentos</th>
                </tr>
                <tr>
                    <c:choose>
                        <c:when test="${doctor.ceudla}">
                    <c:forEach var="paciente" items="${pacientes}">     
                                <td>${paciente.nombres}</td>
                                <td>${paciente.apellidos}</td>                   
                                <td>${paciente.curp}</td>
                                <td>${paciente.correo}</td>
                                <td>${paciente.telefono}</td>
                                <c:if test="${paciente.doctorAsignado == doctor.curp}">
                                <td><a href="comprobarHuella.jsp">Ver</a></td>
                                </c:if>
                            <tr>
                    </c:forEach>
                        </c:when>
                    <c:otherwise>
                        <td>No tiene acceso a ver la lista de cedulas</td>
                    </c:otherwise>
                    </c:choose>
                </tr>
            </table>  
        </section> 
    </body>
</html>
