package hotelBooking.com;

import java.io.IOException;
public class Hotel implements Comparable<Hotel>{
	String name;
	int ratings;
	double costPerDay;
	int discountPercentage;
	int discountDays;
	public Hotel(String hotelName, int rating, double cost, int offer, int validOffer) throws IOException {
		this.name = hotelName;
		this.ratings = rating;
		this.costPerDay = cost;
		this.discountPercentage = offer;
		this.discountDays = validOffer;
	}

	public int compareTo(Hotel h) {
		// TODO Auto-generated method stub
		if(costPerDay==h.costPerDay)
			return 0;
		else if(costPerDay>h.costPerDay)
			return 1;
		else
			return -1;
}
}