<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Voyageurs</title>
<!-- Fontfaces CSS-->
<link href="css/font-face.css" rel="stylesheet" media="all">
<link href="vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link href="vendor/font-awesome-5/css/fontawesome-all.min.css"
	rel="stylesheet" media="all">
<link href="vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet"
	media="all">

<!-- Vendor CSS-->
<link href="vendor/animsition/animsition.min.css" rel="stylesheet"
	media="all">
<link
	href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all">
<link href="vendor/wow/animate.css" rel="stylesheet" media="all">
<link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet"
	media="all">
<link href="vendor/slick/slick.css" rel="stylesheet" media="all">
<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
<link href="vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all">

<!-- Main CSS-->
<link href="css/theme.css" rel="stylesheet" media="all">

</head>


<body>
	<div class="page-wrapper">
		<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar d-none d-lg-block">
			<div class="logo">
				<a href="index.jsp"><img src="images/icon/logo-mini.png"
					alt="Cool Admin" /></a>
			</div>
			<div class="menu-sidebar__content js-scrollbar1">
				<nav class="navbar-sidebar">
					<ul class="list-unstyled navbar__list">
						<li class="active has-sub"><a class="js-arrow"
							href="voyageurs"> Les voyageurs </a></li>
						<li class="active has-sub"><a class="js-arrow"
							href="reservations"> Les Réservations </a></li>
							<li class="active has-sub"><a class="js-arrow"
							href="hotels"> Les Hotels </a></li>
						<li><a href="chart.html"> <i class="fas fa-chart-bar"></i>Statistiques
						</a></li>
					</ul>
				</nav>
			</div>
		</aside>
	</div>
	<div class="page-container">
		<!-- HEADER DESKTOP-->
		<header class="header-desktop">
			<div class="section__content section__content--p30">
				<div class="container-fluid">
					<div class="header-wrap">
						<button class="au-btn au-btn-icon au-btn--blue">
							<a href="login.jsp" style="color: white">Se Connecter</a>
						</button>
						<div class="header-button">
							<div class="noti-wrap">
								<div class="noti__item js-item-menu"></div>

							</div>

						</div>
					</div>

				</div>
			</div>
		</header>

		<div class="main-content">
			<div class="section__content section__content--p30">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">

							<h3>Ajouter un voyageur</h3>
							<div class="overview-wrap">
								<form:form method="post" action="saveVoyageur"
									modelAttribute="v">
									<div class="form-group">
										<label for="nom">Nom</label>
										<form:input path="nomVoyageur" class="form-control" id="nom" />
									</div>
									<div class="form-group">
										<label for="prenom">Prénom</label>
										<form:input path="prenomVoyageur" class="form-control"
											id="prenom" />
									</div>
									<div class="form-group">
										<label for="reservation">Reservation</label>
										<form:select multiple="true" path="listReservation"
											class="form-control" id="reservation">
											<form:options items="${listReservation}" var="r"
												itemValue="idReservation" itemLabel="libelle" />
										</form:select>
									</div>
									<button type="submit" class="btn btn-primary">Ajouter</button>

								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>

			<br>
			<div class="section__content section__content--p30">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<h3>Liste des Voyageurs</h3>
							<div class="overview-wrap">
								<div class="table-responsive table--no-card m-b-30">
									<table
										class="table table-borderless table-striped table-earning">
										<thead class="thead-dark">
											<tr>
												<th scope="col">Nom</th>
												<th scope="col">Prenom</th>
												<th scope="col">Action</th>
											</tr>
										</thead>
										<c:forEach items="${listVoyageur}" var="voy">
											<tr>
												<td>${voy.nomVoyageur}</td>
												<td>${voy.prenomVoyageur}</td>
												<td><a href="delete/${voy.idVoyageur}">Supprimer</a></td>
											</tr>
										</c:forEach>
									</table>
									<nav aria-label="Page navigation example">
										<ul class="pagination justify-content-center">
											<c:url value="/voyageurs" var="prev">
												<c:param name="page" value="${page-1}" />
											</c:url>
											<c:if test="${page>1}">
												<li class="page-item"><a
													href="<c:out value="${prev}"/>" class="page-link">Précédent</a>
												</li>
											</c:if>
											<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
												<c:choose>
													<c:when test="${page == i.index}">
														<li class="page-item"><span>${i.index}</span></li>
													</c:when>
													<c:otherwise>
														<c:url value="/voyageurs" var="url">
															<c:param name="page" value="${i.index}" />
														</c:url>
														<li class="page-item"><a
															href='<c:out value="${url} "/>' class="page-link">${i.index}</a>
													</c:otherwise>
												</c:choose>

											</c:forEach>
											<c:url value="/voyageurs" var="next">
												<c:param name="page" value="${page+1 }" />
											</c:url>
											<c:if test="${page +1 <= maxPages }">
												<li class="page-item"><a
													href='<c:out value="${next}"/>' class="page-link">Suivant</a>

												</li>
											</c:if>
										</ul>


									</nav>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<script src="vendor/bootstrap-4.1/bootstrap.min.js"></script>
</body>
</html>