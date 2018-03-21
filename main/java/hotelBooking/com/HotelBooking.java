package hotelBooking.com;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import hotel.Hotels;


@WebServlet(name="hotelBooking",urlPatterns= {"/hotelBooking"})
public class HotelBooking extends HttpServlet {
	static List<Hotel> list = new LinkedList<Hotel>();

	public static double computeOffer(double discounts, double cost, int days) {
		double bill = cost * days;
		double offer = (discounts / 100) * bill;
		double totalBill = bill - offer;
		return totalBill;
	}

	public static boolean foundAHotel(double bill, double money) {
		if (money >= bill)
			return true;

		else
			return false;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {
		double SelectedHotelPrice = 0;
		LinkedList<Double> a = new LinkedList<Double>();
		// double[] cost = new double[10];
		int j = 0;
		String bookedHotelName = "";
		double amountPayableByUser = 0, discountPercentage = 0;
		boolean result = false;
		int discountDays = 0;
response.setContentType("text/html");
		
		PrintWriter out = response.getWriter(); 
	    String rating=request.getParameter("rating"); 
	   int userRating=Integer.parseInt(rating);
	    String Money=request.getParameter("userMoney");
	    double userMoney=Double.parseDouble(Money);
	    String Days=request.getParameter("days");
	    int days=Integer.parseInt(Days);
	    

		Hotel hotel1 = new Hotel("The Park", 5, 90, 20, 2);
		Hotel hotel2 = new Hotel("Hotel Hyaat", 5, 82, 12, 3);
		Hotel hotel3 = new Hotel("Raddisson", 3, 60, 18, 3);
		Hotel hotel4 = new Hotel("RainTree", 3, 58, 15, 2);
		Hotel hotel5 = new Hotel(" Accord", 1, 41.55, 12, 3);
		Hotel hotel6 = new Hotel("Fortune", 1, 43, 15, 4);

		list.add(hotel1);
		list.add(hotel2);
		list.add(hotel3);
		list.add(hotel4);
		list.add(hotel5);
		list.add(hotel6);
		Collections.sort(list);
		if (userRating == 1 || userRating == 3 || userRating == 5) {
			for (Hotel h : list) {
				if (userRating == h.ratings) {
					if (days >= h.discountDays) {
						amountPayableByUser = computeOffer(h.discountPercentage, h.costPerDay, days);

					} else {
						amountPayableByUser = h.costPerDay * days;
					}
					a.add(amountPayableByUser);
					Collections.sort(a);

				}

			}
		
		for (Hotel ht : list) {
			if (userRating == ht.ratings)

			{
				if (days >= ht.discountDays)

				{
					amountPayableByUser = computeOffer(ht.discountPercentage, ht.costPerDay, days);

				} else {
					amountPayableByUser = ht.costPerDay * days;
				}
				if (a.get(0).equals(amountPayableByUser)) {
					bookedHotelName = ht.name;
				}
			}

		}
		result = foundAHotel(amountPayableByUser, userMoney);
		if (result == true)
			out.println("Hotel booked for " + days + " days in a " + userRating + " Hotel named "
					+ bookedHotelName + " for the cost of " + a.get(0));
		else
			out.println("Sorry! you dont have sufficient amount to book any hotel");

	} 
		else

		out.println("No hotel of such a star is available");

}

	   // out.println("The user wants to book a "+rating+" star hotels for "+days+" and he can only afford for "+userMoney);
	}

