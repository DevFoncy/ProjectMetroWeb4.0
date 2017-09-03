
<%@page import="java.util.Calendar"%>
<%@page import="Modelo.DTO.Producto"%>
<%@page import="java.util.Vector"%>
<%@page import="Modelo.DAO.ProductoDAO"%>
<%@include file="header.jsp" %>

<%
Cliente cliente = (Cliente)request.getSession().getAttribute("client");

if(cliente == null)
{
    response.sendRedirect("index.jsp?con");
    return ;
}

%>
    <div class="RightSide" >
    
        <div class="bredCrum">
            <h4><a href="index.html">Recepcion</a>   >>   <a href="#" class="select">Mi Cuenta </a> </h4>
        </div>
        <form action="CuentaServlet" method="GET" >
            
        <center>
        <table style="padding-top: 100px;">
            <tr>
                <td>login : </td>
                <td><input value="<%= cliente.getLogin()%>"  disabled="true" style="background-color: #E6E6E6" > </td>
                
                <td>
                    <input type="hidden" name="login" value="<%= cliente.getLogin()%>" >
                </td>
            </tr>

            <tr>
                <td>Nombre : </td>
                <td><input name="nom" value="<%= cliente.getNombre()%>" > </td>
            </tr>
            
            <tr>
                <td>Apellidos : </td>
                <td><input name="prenom" value="<%= cliente.getApellidos()%>"></td>
            </tr>
            
            <tr>
                <td>Contraseña : </td>
                <td><input type="password" name="mdp" value="<%= cliente.getContraseña()%>"></td>
            </tr>
            
            <tr>
                <td>
                    <input type="submit" value="Modificar">
                </td>
                <td>
                    <input type="reset" value="Cancelar">
                </td>
            </tr>
            
    </table>
    </center>
    </form>
    
</div>

<%@include file="footer.jsp" %>