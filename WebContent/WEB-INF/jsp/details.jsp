<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details</title>
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
						<li class="active has-sub"><a class="js-arrow" href="hotels">
								Les Hotels </a></li>
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

							
								<h3>${hot.nomHotel}</h3>
							
						</div>
					</div>
				</div>
			</div>


		</div>
<div class="main-content">
			<div class="section__content section__content--p30">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">

							<h3>Ajouter un avis</h3>
							<div class="overview-wrap">
								<form:form method="post" action="saveAvis"
									modelAttribute="av" enctype="multipart/form-data">
									<div class="form-group">
										<label for="datePublication">Date de publication</label>
										<form:input path="datePublication" class="form-control" id="datePublication" />
									</div>
									<div class="form-group">
										<label for="commentaire">Commentaire</label>
										<form:input path="commentaire" class="form-control"
											id="commentaire" />
									</div>
									
									<button type="submit" class="btn btn-primary">Ajouter</button>

								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
					<div class="section__content section__content--p30">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<h3>Liste des Avis</h3>
							<div class="overview-wrap">
								<div class="table-responsive table--no-card m-b-30">
									<table class="table table-borderless table-striped table-earning">
										<thead class="thead-dark">
											<tr>
												<th scope="col">Date de Publication</th>
												<th scope="col">Commentaire</th>
												<th scope="col">NomVoyageur</th>
											
											</tr>
										</thead>
										<c:forEach items="${listAvis}" var="avis">
											<tr>
												<td>${avis.datePublication}</td>
												<td>${avis.commentaire}</td>
												<td>${avis.voyageur.nomVoyageur}</td>
										
											</tr>
										</c:forEach>
									</table>
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