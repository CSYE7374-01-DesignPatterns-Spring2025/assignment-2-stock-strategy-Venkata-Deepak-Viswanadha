package src.main.java.edu.neu.csye7374;

public abstract class Stock implements Tradeable {
    private String name;
    private double price;
    private String description;
    private MarketStrategy strategy;
    private double marketFactor; // Stock-specific rise/fall factor

    public Stock(String name, double price, String description, double marketFactor) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.marketFactor = marketFactor;
    }

    public void setMarketStrategy(MarketStrategy strategy) {
        this.strategy = strategy;
    }

    public void applyStrategy() {
        if (strategy != null) {
            setPrice(strategy.calculatePrice(this.price, this.marketFactor));
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public abstract void setBid(String bid);

    @Override
    public abstract String getMetric();

    @Override
    public String toString() {
        return String.format("Stock[name=%s, price=%.2f, description=%s]",
                name, price, description);
    }
}