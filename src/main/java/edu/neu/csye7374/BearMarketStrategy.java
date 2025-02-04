package src.main.java.edu.neu.csye7374;

class BearMarketStrategy implements MarketStrategy {
    @Override
    public double calculatePrice(double currentPrice, double factor) {
        return currentPrice * (1 - factor);
    }
}