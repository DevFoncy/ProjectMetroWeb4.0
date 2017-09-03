<%@page import="java.util.Calendar"%>
<%@page import="Modelo.DTO.Producto"%>
<%@page import="java.util.Vector"%>
<%@page import="Modelo.DAO.ProductoDAO"%>
<%@include file="header.jsp" %>

<% 
    int id = -1;
    
    if(request.getParameter("id") != null)
     id = (Integer.parseInt(request.getParameter("id")));
    
    Producto producto = (new ProductoDAO()).findByID(id);
    
    if(producto == null)
        producto = new Producto("", "", 0, "", 0);
    
%>

<div class="RightSide">     

    <div class="bredCrum">
        <h4><a href="#" class="select"> <%= producto.getNombre()%></a></h4> 
    </div>
    <div class="productDetial">
        <div class="mainThumb"><img src="<%= producto.getImagen()%>" alt="" width="471" height="260"/></div>
        <div class="rightProduct">
            <div class="cartBtn fl">
                <a href="CarritoServlet?op=add&sender=article.jsp&id=<%= id %>" title="ADD to Cart" class="addToCart"></a>
            </div>
            <div class="clr"></div>	
        </div>
    </div>
    <div class="detailInfo">
        <h2>Detalles del Producto: </h2>
        <p> <%= producto.getDescripcion()%> </p>
    </div>

    <div class="clr"></div>
    <div class="paging">
        <div class="pagingDiv price">$ <%= producto.getPrecio()%></div>
        
        <div class="pagingInfo">
            <img src="images/plus.gif" alt=""/>
            <a href="CarritoServlet?op=add&sender=article.jsp&id=<%= id %>">Añadir al Carrito</a>
        </div>
        
        <div class="clr"></div> 
    </div>
</div>    

<%@include file="footer.jsp" %>