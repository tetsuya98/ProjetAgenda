<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="modele.Contact" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd%22%3E
<html>
    <head>
        <title>
            Rendez-Vous
        </title>
    </head>
    <body>
        Ajoutons un rendez-vous : <br/>
        <form method="post" action="AddRendezVousExecuteServlet">
            date :<br/>
            <input type="text" name="rdv.date"/><br/>
            Heure début :<br/>
            <input type="text" name="rdv.heuredebut"/><br/>
            Heure Fin :<br/>
            <input type="text" name="rdv.heurefin"/><br/>
            Libellé :<br/>
            <input type="text" name="rdv.libelle"/><br/>
            Participants :<br/>
            <select name="rdv.lesContacts" size="10" multiple> 
            <%
            Iterator it = ((Collection)request.getAttribute("listContacts")).iterator();
            while(it.hasNext()) {
            Contact contact = (Contact)it.next();
            %>
            <option value=<%= contact.getId()%>><%= contact.getNom() +" "+ contact.getPrenom() %></option>
            <%
            }
            %>
            </select> 
            <input type="submit"/>
        </form>
    </body>
</html>