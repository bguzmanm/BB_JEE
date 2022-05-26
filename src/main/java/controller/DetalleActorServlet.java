package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Actor;
import model.ActorDAO;

/**
 * Servlet implementation class DetalleActorServlet
 */
@WebServlet("/DetalleActorServlet")
public class DetalleActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetalleActorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String op = request.getParameter("op");
		
		String strId = request.getParameter("id");
		int id = 0;
		if (strId != null)
			id = Integer.parseInt(strId);
		
		ActorDAO aDAO = new ActorDAO();
		
		if (op==null && id > 0) {
			//código para consultar un usuario
			
			Actor a = aDAO.read(id);
			
			request.setAttribute("actor", a);
			
			getServletContext().getRequestDispatcher("/view/actorDetails.jsp").forward(request, response);	
		} else if (id == 0) {
			
			getServletContext().getRequestDispatcher("/view/actorDetails.jsp").forward(request, response);
			
		} else if (op.equalsIgnoreCase("del")) {
			//código para borrar un usuario
			
			aDAO.delete(id);
			
			response.sendRedirect(request.getContextPath() + "/ActorServlet");
			
		} 
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO actualiza Actor
		
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Actor a = new Actor(id, nombre, apellido);
		ActorDAO aDAO = new ActorDAO();
		
		aDAO.update(a);
		
		response.sendRedirect(request.getContextPath() + "/ActorServlet");
		
	}
	
	

}
