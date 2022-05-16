<%-- 
    Document   : registroExpedientes
    Created on : 16/05/2022, 04:43:53 AM
    Author     : Carlos
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${(empty documentos) and (empty doctor)}">
    <c:redirect url = "index.html"/>
</c:if>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <section class="seccion2">
            <h1 class="datos">Datos del paciente</h1>
            <table id="tableCSS2">
                <tr>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Telefono</th>
                    <th>Doctor Asignado</th>
                </tr>
                <tr>
                    <td>${paciente.nombres}</td>
                    <td>${paciente.apellidos}</td>
                    <td>${paciente.telefono}</td>
                    <td>${paciente.doctorAsignado}</td>
                </tr>
            </table>
        </section>
        <section class="seccion">
            <div>
                <h1 class="registros">Registros del paciente</h1>
                <table id="tableCSS2">
                    <tr>
                        <th>Fecha</th>
                        <th>Archivo adjunto</th>
                    </tr>
                    <tr>
                         <c:forEach var="documento" items="${documentos}">
                        <td>${documento.fechaCreacion}</td>
                        <td>${documento.documentoPath}</td>
                        </c:forEach>
                    </tr>
                </table>
                <c:if test="${not empty doctor}">
                    <input id="formFileSm" name="logotipo" type="file" accept="image/*"  required> 
                </c:if>
            </div>
        </section>
    </body>
</html>
