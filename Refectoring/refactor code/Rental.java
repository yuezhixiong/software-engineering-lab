class Rental {
    private Movie _movie;
	private int _daysRented;
    public Rental(Movie movie, DataRange range) {
    	_movie = movie;
        _daysRented = (int)((range.getEnd().getTime() - range.getStart().getTime()) / (1000 * 60 * 60 * 24));
    }
    public int getDaysRented() {
        return _daysRented;
    }

    public String getTitle() {
        return _movie.getTitle();
    }
    
    public int getPriceCode() {
        return _movie.getPriceCode();
    }
	double getCharge() {
		return _movie.getCharge(_daysRented);
	}
}
