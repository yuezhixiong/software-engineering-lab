public class ChildrensPrice extends Price {
	public int getPriceCode() {
		return Movie.CHILDRENS;
	}

	@Override
	protected double getCharge(int daysRented) {
		double result = 0;

		result += 1.5;
		if (daysRented > 3) {
			result += (daysRented - 3) * 1.5;
		}

		return result;
	}
}