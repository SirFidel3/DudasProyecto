package proyectfinal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UsuarioPr")
public class UsuarioPr extends HttpServlet {
	private static final long serialVersionUID = 1L;


	//login
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resultat = "";
		try {
			resultat = baseDatos.selectUsuaris(request.getParameter("email"), request.getParameter("password"));
		} catch (Exception e) {
			System.out.println("Error al descarregar taula");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.getWriter().append(resultat);
	}


	/*register*/
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			baseDatos.insertUsuari(request.getParameter("dni"), request.getParameter("name"),
					request.getParameter("surnames"), request.getParameter("email"), request.getParameter("password"),
					request.getParameter("date"), request.getParameter("address"), request.getParameter("card"));
		} catch (Exception e) {
			System.out.println("Error al insertar usuari");
		}
		response.addHeader("Access-Control-Allow-Origin", "*");
	}

}
