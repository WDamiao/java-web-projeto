package denuncia.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.ArrayList;
import denuncia.model.Denuncia;

/**
 * Servlet implementation class consultarDenunciaController
 */
@WebServlet("/consultarDenunciaController")
public class consultarDenunciaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public consultarDenunciaController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String pais = request.getParameter("pais");
		ArrayList<Denuncia> denuncias = new Denuncia().buscarDenunciaPorPais(pais);
	
		for(Denuncia denuncia : denuncias)
			System.out.println("[Denuncia]: " + denuncia.getPais());
	
	}

}
