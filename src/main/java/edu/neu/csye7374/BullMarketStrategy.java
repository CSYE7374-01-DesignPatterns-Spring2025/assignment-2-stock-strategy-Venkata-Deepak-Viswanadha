package src.main.java.edu.neu.csye7374;

class BullMarketStrategy implements MarketStrategy {
    @Override
    public double calculatePrice(double currentPrice, double factor) {
        return currentPrice * (1 + factor);
    }

    @Override
    public String toString() {
        return "BullMarketStrategy";
    }
}