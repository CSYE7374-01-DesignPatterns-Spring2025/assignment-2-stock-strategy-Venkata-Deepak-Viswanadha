package src.main.java.edu.neu.csye7374;

public class MicrosoftStockFactory implements StockFactory {
    @Override
    public Stock createStock(String name, double price, String description, double factor) {
        return new MicrosoftStock(name, price, description, factor);
    }
} 