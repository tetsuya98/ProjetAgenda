<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.*" %>
<%@ page import="modele.Contact" %>
<%@ page import="modele.RendezVous" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
		<title>Liste des contacts</title>
	</head>
	<body>
		<header>
	    	<nav class="light-blue accent-4">
	    		<div class="nav-wrapper">
	      			<a href="index.html" class="brand-logo left">TD6</a>
	      			<ul id="nav-mobile" class="right hide-on-med-and-down">
	        			<li><a href="addContactFormServlet">Nouveau Contact</a></li>
	        			<li><a href="ListContactServlet">Liste Contacts</a></li>
	      			</ul>
	    		</div>
	  		</nav>
    	</header>
		<h1>Liste des contacts </h1>
		<table class="centered">
			<thead>
				<th>Prénom</th>
				<th>Nom</th>
				<th>Adresse</th>
				<th>Ville</th>
				<th>Code Postal</th>
				<th>Portable</th>
				<th>Fixe</th>
				<th>Rdv</th>
			</thead>
			<tbody>
			<%
				Iterator it = ((Collection)request.getAttribute("listContacts")).iterator();
				while(it.hasNext()) {
					Contact contact = (Contact)it.next();
			%>
			<tr>
				<td><%= contact.getPrenom() %></td>
				<td><%= contact.getNom() %></td>
				<td><%= contact.getAdresse() %></td>
				<td><%= contact.getVille() %></td>
				<td><%= contact.getCodePostal() %></td>
				<td><%= contact.getTelephone() %></td>
				<td><%= contact.getMobile() %></td>
				<td>
					<ul>
							<%
								Iterator it2 = (contact.getLesRendezVous()).iterator();
								while(it2.hasNext()) {
									RendezVous rdv = (RendezVous)it2.next();
							%>
								<li><%= rdv.getDate() %> - <%= rdv.getLibelle() %></li>
							<%
								}
							%>
					</ul>
				</td>
			</tr>
			<%
				}
			%>
			</tbody>
		</table>
	</body>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</html>
