

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Usuario u1 = new Usuario("admin","admin");
	Usuario u2 = new Usuario("usuario","contrasena");
	Usuario u3 = new Usuario("123","123");
	Usuario u4= new Usuario("Tony","Stark");
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        usuarios.add(u4);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("VERBO POST");
		String usuario = request.getParameter("usuario");
		String contrasena = request.getParameter("contrasena");
		Boolean encontrado = false;
		for(int i=0; i<usuarios.size();i++) {
			if (usuario.equals(usuarios.get(i).getUsuario()) && contrasena.equals(usuarios.get(i).getContrasena())) {
				encontrado = true;
			}
		}
		RequestDispatcher rd;
		if (encontrado) {
			System.out.println("Log-in");
			rd = request.getRequestDispatcher("loginExitoso.jsp");
			request.setAttribute("usuario",usuario);
		} else {
			rd = request.getRequestDispatcher("index.html");
		}
		
		//Ejecutamos la accion de ir
		rd.forward(request, response);
		
	}

}
