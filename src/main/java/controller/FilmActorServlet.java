package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Actor;
import model.ActorDAO;
import model.FilmActor;
import model.FilmActorDAO;

/**
 * Servlet implementation class FilmActorServlet
 */
@WebServlet("/FilmActorServlet")
public class FilmActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmActorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idActor = Integer.parseInt(request.getParameter("id"));

		FilmActorDAO faDAO = new FilmActorDAO();
		
		List<FilmActor> lista = faDAO.read(idActor);
		ActorDAO aDAO = new ActorDAO();
		
		Actor a = aDAO.read(idActor); 
		
		request.setAttribute("films", lista);
		request.setAttribute("actor", a);
		
		getServletContext().getRequestDispatcher("/view/peliculasActor.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
