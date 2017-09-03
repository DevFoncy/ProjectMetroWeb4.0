<%@page import="CarritoCompras.CompraOnline"%>
<%@page import="Modelo.DTO.Producto"%>
<%@page import="Modelo.DAO.ProductoDAO"%>
<%@page import="CarritoCompras.Carrito"%>
<%@page import="Modelo.DTO.Cliente"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Metro</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/slideshow.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
<script type="text/javascript" src="js/jquery.cycle.js"></script>
<script type="text/javascript" src="js/jquery.functions.js"></script>
<script src="js/cufon-yui.js" type="text/javascript"></script>
<script src="js/Comfortaa_400.font.js" type="text/javascript"></script>
<script type="text/javascript">
			Cufon.replace('h1', { fontFamily: 'Comfortaa' });
			Cufon.replace('h2', { fontFamily: 'Comfortaa' });
			Cufon.replace('h3', { fontFamily: 'Comfortaa' });
			Cufon.replace('h4', { fontFamily: 'Comfortaa' });
		</script>
<script type="text/javascript" src="assets/js/font-delicious.js"></script>

</head>
<body>
<div id="Layout">
  <!-- BEGIN HEADER -->
  <div id="Top">
    <div id="Logo">
      <h1><a href="index.jsp">
              <img height="100" src="images/logo.png" /></a>
      </h1>
    </div>
    <!-- end div #Logo -->
    <div id="TopContent">
      <ul>
<% 
if(session.getAttribute("panier") == null )
{
    session.setAttribute("panier", new Carrito());
}

Carrito panier = (Carrito)session.getAttribute("panier");

double prixT = 0 ;

for(CompraOnline lp : panier.getLignesPanier())
    prixT += lp.getCantidad()*lp.getProducto().getPrecio();


%>

        <li class="cart"><a href="carrito.jsp">Carrito de Compras</a></li>
        <li class="cart-value">
            <span class="blue"><a href="carrito.jsp"><%= panier.getNumberProducto()%> productos</a></span> | <span>$<%= prixT %> </span></li>
      </ul>
    </div>
    <!-- end div #TopContent -->
    <div id="Nav">
      <div class="NavBody">
        <ul>
            <li> <a href="index.jsp">INICIO</a></li>
            <li> <a href="productos.jsp">NUESTROS PRODUCTOS</a></li>
            <li> <a href="micuenta.jsp">MI CUENTA</a></li>
          <li> <a href="Contactanos.jsp">CONTACTANOS</a></li>
          <li class="search">
              <form action="productos.jsp" method="GET">
                <input type="image" class="action" src="images/search-action.jpg" />
                <input name="keyword" type="text" class="searchfeild" />
            </form>
          </li>
        </ul>
      </div>
    </div>
    <!-- end div #Nav -->
  </div>
  <div id="Content">
    <div class="LeftSide">
        
        <!-- Connexion DIV -->
        <% if(session.getAttribute("client") == null){ %>
            <div class="leftBox">
              <h3>Conexion</h3>
              <div class="leftBoxBody">
              <form method="GET" action="ConnexionServlet">
              <ul class="cat-link" style="margin-top:-20px">
                  <li>
                      Login : <input type="text" name="login" style=" width:100%" />
                  </li>
                  <li>
                      Contraseña : <input type="password" name="mdp" style="width:100%" />
                  </li>
                  </ul>
                  <a href="#" style="margin:5px">Registrarse</a>
                 <input style="margin-left:20px;margin-right:-20px;" type="submit" value="Acceder" />
                      </form>

              </div>
            </div>
        <% }else{ %>
            <div class="leftBox">
                <h3>Bienvenidos</h3>
              <div class="leftBoxBody">
                  <p style="margin-top: -15px; margin-left: -10px ">Bienvenidos <b> <%= ((Cliente)session.getAttribute("client")).getNombre()%></b></p>
              <ul class="cat-link" >
                  <li>
                      <a href="micuenta.jsp"> Mi Cuenta </a>
                  </li>
                  <li>
                      <a href="carrito.jsp"> Carrito </a>
                  </li>
                  <li>
                      <a href="mispedidos.jsp"> Mis pedidos </a>
                  </li>
                  <li>
                      <a href="DeconnexionServlet"> Deconexion.. </a>
                  </li>
                  </ul>

              </div>
            </div>
        <% } %>
      
    </div>
    <!-- end div #LeftSide -->
    