<%-- 
    Document   : menu.jsp
    Created on : 16 de out. de 2024, 08:05:37
    Author     : 2108761
--%>

<%@page import="data.Banco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
        
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            
            out.print("LOGIN = " + login);
            out.print("<br>");
            out.print("SENHA = " + senha);
            out.print("<br>");
            out.print("<br>");
            
            Banco b = new Banco();
            String nomeCompleto = b.getUsuario(login);
            out.print("<h1>" + nomeCompleto + "</h1>");
            %>
    </body>
</html>
