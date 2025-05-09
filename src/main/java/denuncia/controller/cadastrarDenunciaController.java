package denuncia.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import denuncia.model.Denuncia;

/**
 * Servlet implementation class cadastrarDenunciaController
 */
@WebServlet("/cadastrarDenunciaController")
public class cadastrarDenunciaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cadastrarDenunciaController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		this.doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String pais = request.getParameter("pais");
		String tipo = request.getParameter("tipo");
		int qtdDenuncia;
		int casosConfirmados;
		String gravidade = request.getParameter("gravidade");
		String mensagem;
		
		if (pais !=null && !pais.isEmpty() && request.getParameter("qtdDenuncia") != null 
				&& !request.getParameter("qtdDenuncia").isEmpty() && request.getParameter("tipo") != null
				&& !request.getParameter("tipo").isEmpty() && request.getParameter("casosConfirmados") != null
				&& !request.getParameter("casosConfirmados").isEmpty() && request.getParameter("gravidade") != null
				&& !request.getParameter("gravidade").isEmpty()){
			
			qtdDenuncia = Integer.parseInt(request.getParameter("qtdDenuncia"));
			casosConfirmados = Integer.parseInt(request.getParameter("casosConfirmados"));
			Denuncia denuncia = new Denuncia(pais, tipo, qtdDenuncia, casosConfirmados, gravidade);
			denuncia.salvar();
			
			mensagem = "Denuncia cadastrada com sucesso";
			
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarDenuncia.jsp");
			dispatcher.forward(request, response);
		} else {
			mensagem = "Preencha os campos corretamente";
			
			request.setAttribute("mensagem", mensagem);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarDenuncia.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
