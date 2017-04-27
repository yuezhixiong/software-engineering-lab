
public abstract class Price {

	public Price() {
		super();
	}

	public abstract int getPriceCode();

	protected abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints() {
		
		return 1;
	}

	public int getFrequentRenterPoints(int daysRented) {
		
		return 1;
	}

}