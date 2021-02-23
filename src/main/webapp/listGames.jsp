<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es-ES" variant="euro" />

<section id="games">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="card" style="background:#f0c3a5">
					<div class="card-header">
						<h4>Listado de Juegos</h4>
					</div>
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>#</th>
								<th>Cover</th>
								<th>Nombre</th>
								<th>Descripción</th>
								<th>Precio</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="table-body">
							<!-- Iteramos cada elemento de la lista de games -->
							<c:forEach var="game" items="${games}" varStatus="status">
								<c:if test="${game.balance==0}">
									<tr>
										<td style="background-color:#FF0000"><b>${status.count}</b></td>
										<td><img src="img/${game.cover}" class="mr-3" style="width:100px"></td>
										<td><b>${game.name}</b></td>
										<td><b>${game.description}</b></td>
										<td><b>FREE</b></td>
										<td><a
											href="${pageContext.request.contextPath}/game?action=edit&idGame=${game.id}"
											class="btn btn-secondary"> <i
												class="fas fa-angle-double-right"></i> Editar
										</a></td>
									</tr>
								</c:if>
								<c:if test="${game.balance!=0}">
									<tr>
										<td style="background-color:#FF0000"><b>${status.count}</b></td>
										<td><img src="img/${game.cover}" class="mr-3" style="width:100px"></td>
										<td><b>${game.name}</b></td>
										<td><b>${game.description}</b></td>
										<td><b><fmt:formatNumber value="${game.balance}"
												type="currency" currencySymbol="€" /></b></td>
										<td><a
											href="${pageContext.request.contextPath}/game?action=edit&idGame=${game.id}"
											class="btn btn-secondary"> <i
												class="fas fa-angle-double-right"></i> Editar
										</a></td>
									</tr>
								</c:if>

							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<!--Inicio Tarjetas para los totales-->
			<div class="col-md-3">
				<div class="card text-center bg-dark text-white mb-3">
					<div class="card-body">
						<h3>Saldo Total</h3>
						<h4 class="display-4">
							<fmt:formatNumber value="${saldoTotal}" type="currency" />
						</h4>
					</div>
				</div>

				<div class="card text-center bg-dark text-white mb-3">
					<div class="card-body">
						<h3>Total Games</h3>
						<h4 class="display-4">
							<i class="fas fa-gamepad"></i> ${totalGames}
						</h4>
					</div>
				</div>
			</div>
			<!--Fin Tarjetas para los totales-->

		</div>
	</div>
</section>
