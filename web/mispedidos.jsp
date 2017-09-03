
<%@page import="Modelo.DTO.DetalleOrden"%>
<%@page import="Modelo.DAO.*"%>
<%@page import="Modelo.DTO.Orden"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="Modelo.DTO.Producto"%>
<%@page import="java.util.Vector"%>
<%@include file="header.jsp" %>

<%    Cliente cliente = (Cliente) request.getSession().getAttribute("client");


    
    if (cliente == null)
    {
        response.sendRedirect("index.jsp?con");
        return;
    }
    
    Vector<Orden> cmd = (new OrdenDAO()).findByLogin(cliente.getLogin());    
    
    if(cmd == null)
        cmd = new Vector<Orden>();
    

%>


<div class="RightSide">
    <div class="bredCrum">
        <h4><a href="#" class="select"> Mis pedidos</a> </h4>
    </div>    



    <table  style="border-style:solid  ;width: 100%; text-align: center">
        
        <%
            for(Orden c : cmd)
            {
                String etat = "En Attente";
                if(c.getEstado()== 1)
                    etat = "Valide";
                if(c.getEstado()== 2)
                    etat = "Refuse";
                
        %>
        <tr style="text-align: left">
            <td colspan="2" style="background-color: #E6E6E6; font-size: larger; color: #000000">
                <b>Orden Numero : </b><%= c.getIdorden()%> <b> creo el </b><%= c.getFechaOrden()%>  
            </td>
        
            <td colspan="1" style="background-color: #E6E6E6; font-size: larger; color: #000000; color: green">
                <center><b>(<%= etat %>)</b></center>
            </td>
            
        </tr>
        
        <% 
        
            DetalleOrdenDAO daolc = new DetalleOrdenDAO();
            Vector<DetalleOrden> lc = daolc.findAll(c.getIdorden());
            
            for(DetalleOrden l : lc){
                Producto a = (new ProductoDAO()).findByID(l.getIdproducto());
        
        %>
        
        <tr>
            <td>
                <%= a.getNombre()%>
            </td>
            <td>
                <%= a.getPrecio()%> $
            </td>
            <td>
                <%= l.getNbr() %>
            </td>
            
            
        </tr>
        <% } %>
        
        <tr>
            <td colspan="5" style="text-align: right; padding-right: 20px; font-size: 20px;border-style: dashed; border-width: 1px">
               Precio Total : <%= c.getPrecioTotal()%>
            </td>
            
        </tr>
        
        <% } %>
    </table>    


</div>



<%@include file="footer.jsp" %>