package src.main.java.edu.neu.csye7374;

public class MicrosoftStockLazySingletonFactory implements StockFactory {
    private static MicrosoftStockLazySingletonFactory instance;
    
    private MicrosoftStockLazySingletonFactory() {}
    
    public static synchronized MicrosoftStockLazySingletonFactory getInstance() {
        if (instance == null) {
            instance = new MicrosoftStockLazySingletonFactory();
        }
        return instance;
    }
    
    @Override
    public Stock createStock(String name, double price, String description, double factor) {
        return new MicrosoftStock(name, price, description, factor);
    }
} 