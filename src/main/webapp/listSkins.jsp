<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es-ES" variant="euro" />

<section id="skins">
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class="card" style="background:#f0c3a5">
					<div class="card-header">
						<h4>Listado de Skins</h4>
					</div>
					<table class="table table-striped">
						<thead class="thead-dark">
							<tr>
								<th>#</th>
								<th>Cover</th>
								<th>Nombre Skins</th>
								<th>Precio</th>
								<th>Stock</th>
								<th>Nombre Juego</th>
								<th></th>
							</tr>
						</thead>
						<tbody id="table-body">
							<!-- Iteramos cada elemento de la lista de skins -->
							<c:forEach var="skin" items="${skins}" varStatus="status">
								<c:if test="${skin.price==0}">
									<tr>
										<td style="background-color:#FF0000"><b>${status.count}</b></td>
										<td><img src="img/${skin.cover}" class="mr-3" style="width:100px"></td>
										<td><b>${skin.name}</b></td>
										<td><b>FREE</b></td>
										<td><b>${skin.stock}</b></td>
										<td><b>${skin.game.name}</b></td>
										<td><a
											href="${pageContext.request.contextPath}/skin?action=edit&idSkin=${skin.id}"
											class="btn btn-secondary"> <i
												class="fas fa-angle-double-right"></i> Editar
										</a></td>
									</tr>
								</c:if>
								<c:if test="${skin.price!=0}">
									<tr>
										<td style="background-color:#FF0000"><b>${status.count}</b></td>
										<td><img src="img/${skin.cover}" class="mr-3" style="width:100px"></td>
										<td><b>${skin.name}</b></td>
										<td><b><fmt:formatNumber value="${skin.price}"
												type="currency" currencySymbol="€" /></b></td>
										<td><b>${skin.stock}</b></td>
										<td><b>${skin.game.name}</b></td>
										<td><a
											href="${pageContext.request.contextPath}/skin?action=edit&idSkin=${skin.id}"
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
						<h3>Total Games</h3>
						<h4 class="display-4">
							<i class="fas fa-gamepad"></i> ${totalSkins}
						</h4>
					</div>
				</div>
			</div>
			<!--Fin Tarjetas para los totales-->

		</div>
	</div>
</section>
