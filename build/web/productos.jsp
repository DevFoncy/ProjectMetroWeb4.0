
<%@page import="java.util.Calendar"%>
<%@page import="Modelo.DTO.Producto"%>
<%@page import="java.util.Vector"%>
<%@page import="Modelo.DAO.ProductoDAO"%>
<%@include file="header.jsp" %>

<div class="RightSide">
    
    
      <div class="bredCrum" style="margin-bottom:38px;">
        <h4><a href="#" class="select">Nuestros Productos</a> </h4>
      </div>
    
    <% 
            int NB_PRODUIT_PAGE = 9 ;
            
            int pageCourante = 1;
            if(request.getParameter("page") != null)
            {
                pageCourante = Integer.parseInt(request.getParameter("page"));
            }
    
            String keyword = "";
            
            if(request.getParameter("keyword") != null)
                keyword = request.getParameter("keyword");
            
            
            ProductoDAO dao = new ProductoDAO();
            Vector<Producto> productos = dao.findAll(keyword);
            
            int nbTotalePages = 0;
            if(productos != null)
                nbTotalePages = productos.size() / NB_PRODUIT_PAGE + 1;
            
            int init = ((pageCourante - 1) * NB_PRODUIT_PAGE);
            
            String cls = "";
            
            boolean arret = true ;
            int t = 0 ;
          %>

<% 
while(t < NB_PRODUIT_PAGE/3 )
{
%>
      <div class="catrow">

        <ul>

   <% 
            for(int i = init; i < init + 3; i++)
            { 
                cls = "" ;
                if(productos == null || i >= productos.size())
                {
                    break;
                }

                if(i >= init + 2)
                { 
                    cls+= "last ";

                }

                if(productos.get(i).getFechaCreacion().getYear()+1900 >= 2014)
                {
                    cls+= "new ";
                }
        %>
 
          <li class="<%= cls %>"   >
              
              <div class="catThum">
                  <a href="article.jsp?id=<%= productos.get(i).getIdproducto()%>">
                      <img width="203" height="186" src="<%= productos.get(i).getImagen()%>" alt="" />
                  </a>
<%
if(productos.get(i).getFechaCreacion().getYear()+1900 >= 2014)
{
%>
                <div class="new"></div>
                
<%}%>
            </div>
            <div class="catDetail">
              <h4><a href="article.jsp?id=<%= productos.get(i).getIdproducto()%>"><%= productos.get(i).getNombre()%> </a></h4>
              <p><%= productos.get(i).getPrecio()%>$</p>
            </div>
              
          </li>
          <% } %>
        
        </ul>
              
        <div class="clr"></div>
      </div>

<% 
t++ ;
init += 3 ;
}%>        
      
      <div class="paging">
        <div class="pagingDiv">
            <span class="label">Pagina 
                <b class="blue"><%= pageCourante %></b> de <%= nbTotalePages %></span>
                
                <% if(!(pageCourante <= 1) ){ %>
                <span class="back">
                    <a href="?page=<%= pageCourante - 1 %>"><img src="images/back.gif" alt="" /></a>
                </span>
                 <% } %>   
                 
                  <% if(!(pageCourante >= nbTotalePages) ){ %>
                <span class="next">
                    <a href="?page=<%= pageCourante + 1 %>"><img src="images/next.gif" alt="" /></a>
                </span>
                <% } %>
        </div>
                
        <div class="clr"></div>
      </div>
    </div>



<%@include file="footer.jsp" %>