public class NewReleasePrice extends Price {
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	@Override
	protected double getCharge(int daysRented) {
		double result = 0;

		result += daysRented * 3;

		return result;
	}
	
	@Override
	public int getFrequentRenterPoints(int daysRented){
		int frequentRenterPoints=0;
		// add frequent renter points
				frequentRenterPoints ++;
				// add bonus for a two day new release rental
				if ((getPriceCode() == Movie.NEW_RELEASE)&& daysRented > 1) 
					frequentRenterPoints++;
				return frequentRenterPoints;
	}
}