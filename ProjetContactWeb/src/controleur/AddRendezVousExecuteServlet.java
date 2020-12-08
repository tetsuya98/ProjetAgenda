package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Contact;
import modele.ContactManagerRemote;
import modele.RendezVous;
import modele.RendezVousManagerRemote;

/**
 * Servlet implementation class AddRendezVousExecuteServlet
 */
@WebServlet("/AddRendezVousExecuteServlet")
public class AddRendezVousExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRendezVousExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RendezVous rdv = new RendezVous();
    	rdv.setLibelle(request.getParameter("rdv.libelle"));
    	rdv.setHeureDebut(request.getParameter("rdv.heuredebut"));
    	rdv.setHeureFin(request.getParameter("rdv.heurefin"));
    	rdv.setDate(request.getParameter("rdv.date"));
    	RendezVousManagerRemote rendezVousManagerRemote = EjbLocator.getLocator().getRendezVousManager();
    	RendezVous newRdv = rendezVousManagerRemote.ajouterRdv(rdv);
    	ContactManagerRemote contactManagerRemote = EjbLocator.getLocator().getContactManager();
    	
    	String[] tmp = request.getParameterValues("rdv.lesContacts");
        ArrayList<Integer> cles = new ArrayList<Integer>();
        for (String index:tmp)
        {
            int cle = Integer.parseInt(index);
            cles.add(new Integer(cle));
        }
        System.out.println("test");
        rendezVousManagerRemote.addContacts(newRdv, cles);
    	
    	RequestDispatcher rd = null;
    	if(newRdv.getId() > 0) {
    		rd = request.getRequestDispatcher("/WEB-INF/jsps/rdvAdded.jsp");
    	}
    	else {
    		rd = request.getRequestDispatcher("/WEB-INF/jsps/rdvNotAdded.jsp");
    	}
    	rd.forward(request, response);
    }

}
