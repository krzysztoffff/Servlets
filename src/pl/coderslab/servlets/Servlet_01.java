package pl.coderslab.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_01
 */
@WebServlet("/Servlet_01")
public class Servlet_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet_01() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// tablica zawiera dolara do zł, euro do zł, euro do dolara,  
		double[] exchangeRate = { 3.83, 4.26, 1.1908};
		double res = 0;
		String cashString = request.getParameter("cash");
		double cash;
		try {
			cash = Double.parseDouble(cashString);
		String exchange = request.getParameter("exchange");

		if (exchange.equals("eur_usd")) {
			res = cash * exchangeRate[2];
			response.getWriter().println(cash + " EUR " +res+ " USD ");
		}

		if (exchange.equals("usd_eur")) {
			res = cash / exchangeRate[2];
			response.getWriter().println(cash + " USD " +res+ " EUR ");
		}

		if (exchange.equals("eur_pln")) {
			res = cash * exchangeRate[1];
			response.getWriter().println(cash + " EUR " +res+ " PLN ");
		}

		if (exchange.equals("pln_eur")) {
			res = cash / exchangeRate[1];
			response.getWriter().println(cash + " PLN " +res+ " EUR ");
		}
		
		if (exchange.equals("usd_pln")) {
			res = cash * exchangeRate[0];
			response.getWriter().println(cash + " USD " +res+ " PLN ");
		}
		
		if (exchange.equals("pln_usd")) {
			res = cash / exchangeRate[0];
			response.getWriter().println(cash + " PLN " +res+ " USD ");
		}
		
		} catch (NumberFormatException e) {
			response.getWriter().println(e + " Enter a double value!");
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
