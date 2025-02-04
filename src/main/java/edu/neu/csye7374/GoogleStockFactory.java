package src.main.java.edu.neu.csye7374;

public class GoogleStockFactory implements StockFactory {
    @Override
    public Stock createStock(String name, double price, String description, double factor) {
        return new GoogleStock(name, price, description, factor);
    }
} 