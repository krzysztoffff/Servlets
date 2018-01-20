package pl.coderslab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_02
 */
@WebServlet("/Servlet_02")
public class Servlet_02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bin = request.getParameter("bin");
		boolean binCheck = true;
		double convert = 0;
		double result = 0;
		int j = 0;
		for(int i = bin.length()-1; i >= 0; i--){
			char c = bin.charAt(i);
			if( c == '0' || c == '1'){
				convert = Math.pow(2, j);
				j++;
				result += convert * Double.parseDouble(String.valueOf(c));
				binCheck = true;
			
			}else{
				binCheck = false;
				break;
			}
			
		}
		
		if(binCheck == false){
			
			
			response.getWriter().println("Wprowadź poprawny kod zero jedynkowy");
			
		}else{
			response.getWriter().println("bin: " + bin + " decimal " + result);
		}
		
			
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
