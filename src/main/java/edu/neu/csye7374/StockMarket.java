package src.main.java.edu.neu.csye7374;

import java.util.*;

public class StockMarket {
    private static StockMarket instance;
    private List<Stock> stocks;

    private StockMarket() {
        stocks = new ArrayList<>();
    }

    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public void showAllStocks() {
        if (stocks.isEmpty()) {
            System.out.println("No stocks in the market");
            return;
        }

        for (Stock stock : stocks) {
            System.out.println(stock);
            System.out.println("Performance Metric: " + stock.getMetric());
            System.out.println("-------------------");
        }
    }

    public void placeBids() {
        System.out.println("\nPlacing Bids:");

        String[] ibmBids = {"120.50", "135.75", "128.90", "140.25", "133.80", "145.00"};
        String[] googleBids = {"210.50", "220.75", "215.90", "225.25", "230.80", "240.00"};
        String[] microsoftBids = {"355.50", "360.75", "358.90", "365.25", "370.80", "375.00"};

        for (Stock stock : stocks) {
            System.out.println("\n========== Bidding for " + stock.getName() + " ==========");

            String[] bids;
            if (stock.getName().contains("IBM")) {
                bids = ibmBids;
            } else if (stock.getName().contains("Google")) {
                bids = googleBids;
            } else {
                bids = microsoftBids;
            }

            for (String bid : bids) {
                stock.setBid(bid);
                System.out.println("Placed bid: " + bid);
                System.out.println(stock);
                System.out.println("Performance Metric: " + stock.getMetric());
                System.out.println("--------------------------------");
            }
        }
    }

    public static void demo() {
        System.out.println("============ Stock Market Demo ============");

        StockMarket market = StockMarket.getInstance();

        // Create factories
        StockFactory regularIBMFactory = new IBMStockFactory();
        StockFactory regularGoogleFactory = new GoogleStockFactory();
        StockFactory regularMicrosoftFactory = new MicrosoftStockFactory();

        // Get singleton factories
        StockFactory singletonIBMFactory = IBMStockLazySingletonFactory.getInstance();
        StockFactory singletonGoogleFactory = GoogleStockEagerSingletonFactory.getInstance();
        StockFactory singletonMicrosoftFactory = MicrosoftStockLazySingletonFactory.getInstance();

        // Create different types of stocks using singleton factories with market factors
        Stock ibmStock = singletonIBMFactory.createStock("IBM", 131.15, "IBM Common Stock", 0.10);
        Stock googleStock = singletonGoogleFactory.createStock("Google", 200, "Google Cloud Stock", 0.12);
        Stock microsoftStock = singletonMicrosoftFactory.createStock("Microsoft", 350.00, "Microsoft Corporation Stock", 0.15);

        // Create additional stocks using regular factories for demonstration
        Stock ibmStock2 = regularIBMFactory.createStock("IBM2", 132.15, "IBM Second Stock", 0.10);
        Stock googleStock2 = regularGoogleFactory.createStock("Google2", 201, "Google Second Stock", 0.12);
        Stock microsoftStock2 = regularMicrosoftFactory.createStock("Microsoft2", 351.00, "Microsoft Second Stock", 0.15);

        // Add stocks to market
        market.addStock(ibmStock);
        market.addStock(googleStock);
        market.addStock(microsoftStock);
        market.addStock(ibmStock2);
        market.addStock(googleStock2);
        market.addStock(microsoftStock2);

        // Display initial state
        System.out.println("\nInitial Stock Market State:");
        market.showAllStocks();

        // Apply Bids
        market.placeBids();

        // Apply Bull Market Strategy to all stocks
        System.out.println("\nApplying Bull Market Strategy:");
        MarketStrategy bullStrategy = new BullMarketStrategy();
        for (Stock stock : market.stocks) {
            stock.setMarketStrategy(bullStrategy);
            stock.applyStrategy();
        }
        market.showAllStocks();

        // Apply Bear Market Strategy to all stocks
        System.out.println("\nApplying Bear Market Strategy:");
        MarketStrategy bearStrategy = new BearMarketStrategy();
        for (Stock stock : market.stocks) {
            stock.setMarketStrategy(bearStrategy);
            stock.applyStrategy();
        }
        market.showAllStocks();

        System.out.println("\n========== Demo Complete ==========\n");
    }
}