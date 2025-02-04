package src.main.java.edu.neu.csye7374;

public class IBMStockFactory implements StockFactory {
    @Override
    public Stock createStock(String name, double price, String description, double factor) {
        return new IBMStock(name, price, description, factor);
    }
} 