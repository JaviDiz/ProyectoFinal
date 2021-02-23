<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.store.dto.User"%>
<%

// Recuperan usuari de la sessió si existeix 
User usuari = (User) session.getAttribute("user");
request.setAttribute("usuari", usuari);



// Recuperam genere per configurar el menú actiu

%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″>
        <!--Si volen que la pàgina es carregui cada 5 segons  -->
        <!--<meta http-equiv="refresh" content="5;url=${pageContext.request.contextPath}/client">-->

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>

        <title>GAMES</title>
        <style>
        	.fondo{
        		background:url("img/banner-rust.jpg") no-repeat;
        		color:white;
        	}
        	.jumbotron{
        		padding-top:5px;
        		padding-bottom:5px;
        		margin:0px;
        	}
        </style>
    </head>
    <body>
        <!--Header-->
        <jsp:include page="/common/jumbotron.jsp" />  
        <jsp:include page="/common/header.jsp" />  
      

        <!--Botones de navegacion-->
        <section id="actions" class="py-4 mb-4 bg-light">
		    <div class="container">
		        <div class="row">
		            <div class="col-md-3 mt-2">
		                <a href="${pageContext.request.contextPath}/client?action=list" class="btn btn-dark btn-block">
		                    <i class="fas fa-lock"></i> Ver Clientes - Admin
		                </a>
		            </div>
                    <div class="col-md-3 mt-2">
                        <a href="${pageContext.request.contextPath}/client?action=listPremium" class="btn btn-dark btn-block">
                            <i class="fas fa-lock"></i> Clientes Premium - Admin
                        </a>
                    </div>
                    <div class="col-md-3 mt-2">
                        <a href="${pageContext.request.contextPath}/game?action=list" class="btn btn-dark btn-block">
                            <i class="fas fa-lock"></i> Ver Juegos - Admin
                        </a>
                    </div>
                    <div class="col-md-3 mt-2">
                        <a href="${pageContext.request.contextPath}/skin?action=list" class="btn btn-dark btn-block">
                            <i class="fas fa-lock"></i> Ver Skins - Admin
                        </a>
                    </div>
                    <div class="col-md-3 mt-2">
                        <a href="${pageContext.request.contextPath}/gameClient?action=list" class="btn btn-dark btn-block">
                            <i class="fas fa-eye"></i> Ver Juegos - Cliente
                        </a>
                    </div>
                    <div class="col-md-3 mt-2">
                        <a href="${pageContext.request.contextPath}/skinClient?action=list" class="btn btn-dark btn-block">
                            <i class="fas fa-eye"></i> Ver Skins - Cliente
                        </a>
                    </div>
		        </div>
		    </div>
		</section>

        <!--Listado Clientes --> 
        <jsp:include page="/listGamesClient.jsp"/>
        


        <!--Footer-->
        <jsp:include page="/common/footer.jsp" /> 

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="js/ajax.js">
        </script>
    </body>
</html>
