<%@page import="CarritoCompras.CompraOnline"%>
<%@page import="CarritoCompras.Carrito"%>
<%@page import="java.util.Calendar"%>
<%@page import="Modelo.DTO.Producto"%>
<%@page import="java.util.Vector"%>
<%@page import="Modelo.DAO.ProductoDAO"%>
<%@include file="header.jsp" %>



<div class="RightSide">     

    <div class="bredCrum">
        <h4><a href="#" class="select"> Su carrito de compra  </a> </h4>
    </div>
    <div class="cartDetail">
        <div class="headings">
            <ul>
                <li class="perview">MUESTRA</li>
                <li class="proName">NOMBRE PRODUCTO</li>
                <li class="priceHead">PRECIO</li>
                <li class="quanitity">CANTIDAD</li>
                <li class="total">TOTAL</li>
            </ul>
            <div class="clr"></div>
        </div>

<%
int i = 0 ;

for(CompraOnline lp : panier.getLignesPanier())
{
    i++;
%>
        
        <div class="proList">
            <ul>
                <li class="number"> <%= i %>. </li>
                <li class="thumbMail">
                    <a href="#"><img width="82" height="60" src="<%= lp.getProducto().getImagen()%>" alt=""/></a>
                </li>							
                
                <li class="proName">
                    <a href="#"><%= lp.getProducto().getNombre()%></a>
                </li>
                
                <li class="priceHead">$<%= lp.getProducto().getPrecio()%></li>
                
                <li class="quanitity">
                    <div class="icons">
                        <a href="CarritoServlet?op=add&sender=carrito.jsp&id=<%= lp.getProducto().getIdproducto()%>" title="plus-pro"><img src="images/plus-pro.gif" alt="plus-pro"/></a>
                        <a href="CarritoServlet?op=sous&sender=carrito.jsp&id=<%= lp.getProducto().getIdproducto()%>" title="minus-pro"><img src="images/minus-pro.gif" alt="minus-pro"/></a>
                    </div>
                    <div class="box"><%= lp.getCantidad()%></div>
                </li>
                
                <li class="total">$<%= lp.getProducto().getPrecio()* lp.getCantidad()%>
                    <span><a href="CarritoServlet?op=rem&sender=carrito.jsp&id=<%= lp.getProducto().getIdproducto()%>" title="Remove"><img src="images/cross.gif" alt="Remove"/></a></span>
                </li>
                
                
            </ul>
            <div class="clr"></div>
        </div>
<%
}
%>
        <div class="totalShiping">
            <div class="txtTotal"><h4>PRECIO TOTAL  =</h4></div>
            <div class="toalPrice">$ <%= prixT %></div>
        </div>
        <div class="clr"></div>
    </div>


    <div class="clr"></div>
    <div class="paging">
        
        <% 
        if(panier.getLignesPanier().size() > 0)
        {
        %>
        <div class="pagingDiv"><a href="OrdenServlet" title="Check Out"><img src="images/check.png" alt="Check Out"/></a></div>
        <%}%>
        
        <div class="pagingInfo"><h4><a href="productos.jsp" title="CONTINUE SHOPPING">CONTINUAR</a></h4></div>
        <div class="clr"></div> 
    </div>
</div>    



<%@include file="footer.jsp" %>