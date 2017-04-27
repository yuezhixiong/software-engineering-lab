import java.util.Date;

class Rental {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
   
    private String _title;
    private int _priceCode;
    private int _daysRented;
    public Rental(String title, int priceCode, Date start, Date end) {
        _title = title;
        _priceCode = priceCode;
        _daysRented = (int)((end.getTime() - start.getTime()) / (1000 * 60 * 60 * 24));
    }
    public int getDaysRented() {
        return _daysRented;
    }

    public String getTitle() {
        return _title;
    }
    
    public int getPriceCode() {
        return _priceCode;
    }
}
