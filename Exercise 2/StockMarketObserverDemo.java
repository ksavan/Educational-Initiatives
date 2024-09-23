import java.util.ArrayList;
import java.util.List;

// Subject (Stock)
class Stock {
    private List<Investor> investors = new ArrayList<>();
    private String stockName;
    private float price;

    public Stock(String stockName, float price) {
        this.stockName = stockName;
        this.price = price;
    }

    public void addInvestor(Investor investor) {
        investors.add(investor);
    }

    public void removeInvestor(Investor investor) {
        investors.remove(investor);
    }

    public void setPrice(float price) {
        this.price = price;
        notifyInvestors();
    }

    public void notifyInvestors() {
        for (Investor investor : investors) {
            investor.update(stockName, price);
        }
    }
}

// Observer Interface
interface Investor {
    void update(String stockName, float price);
}

// Concrete Observer (Individual Investor)
class IndividualInvestor implements Investor {
    private String name;

    public IndividualInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, float price) {
        System.out.println("Investor " + name + " notified. Stock: " + stockName + " is now $" + price);
    }
}

// Main class to test Observer pattern
public class StockMarketObserverDemo {
    public static void main(String[] args) {
        Stock appleStock = new Stock("Apple", 145.0f);
        Stock googleStock = new Stock("Google", 2720.0f);

        IndividualInvestor john = new IndividualInvestor("John");
        IndividualInvestor jane = new IndividualInvestor("Jane");

        appleStock.addInvestor(john);
        googleStock.addInvestor(jane);

        appleStock.setPrice(150.0f);  // Notify John's change
        googleStock.setPrice(2750.0f); // Notify Jane's change
    }
}
