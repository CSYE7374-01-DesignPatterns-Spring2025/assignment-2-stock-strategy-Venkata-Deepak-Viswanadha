package src.main.java.edu.neu.csye7374;

interface MarketStrategy {
    double calculatePrice(double currentPrice, double factor);
}