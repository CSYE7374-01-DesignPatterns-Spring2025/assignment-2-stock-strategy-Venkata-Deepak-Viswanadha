package src.main.java.edu.neu.csye7374;

public interface StockFactory {
    Stock createStock(String name, double price, String description, double factor);
} 