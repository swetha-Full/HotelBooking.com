package hotelBooking.com;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(name="welcome",urlPatterns= {"/welcome"})
public class Welcome extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 
		response.sendRedirect("UserQuery.html");
	}
}
