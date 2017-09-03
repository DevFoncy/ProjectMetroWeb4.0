
<%@page import="java.util.Calendar"%>
<%@page import="Modelo.DTO.Producto"%>
<%@page import="java.util.Vector"%>
<%@page import="Modelo.DAO.ProductoDAO"%>
<%@include file="header.jsp" %>

<div class="RightSide">
    <div class="bredCrum">
        <h4><a href="index.html">Recepcion</a>   >>   <a href="#" class="select">CONTACTANOS</a> </h4>
    </div>
    
    
    
        
    <form style=" padding: 180px; padding-top:50px;" id="contact_form" action="#" method="POST" enctype="multipart/form-data">
	<div class="row">
		<label for="name">Nombre :</label><br />
		<input id="name" class="input" name="name" type="text" value="" size="30" /><br />
	</div>
	<div class="row">
		<label for="email">Email : </label><br />
		<input id="email" class="input" name="email" type="text" value="" size="30" /><br />
	</div>
	<div class="row">
		<label for="message">Mensaje : </label><br />
		<textarea id="message" class="input" name="message" rows="7" cols="30"></textarea><br />
	</div>
	<input id="submit_button" type="submit" value="Enviar" />
</form>				
        
        
    
    
    
</div>

<%@include file="footer.jsp" %>