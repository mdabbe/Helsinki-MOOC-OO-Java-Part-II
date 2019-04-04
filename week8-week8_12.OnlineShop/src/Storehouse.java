import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Storehouse {
    private Map<String, Integer> prices = new HashMap<String, Integer>();
    private Map<String, Integer> stocks = new HashMap<String, Integer>();

    public void addProduct(String product, int price, int stock) {
        prices.put(product,price);
        stocks.put(product,stock);
    }

    public int price(String product) {
        if (prices.get(product) != null) return prices.get(product);
        return -99;
    }
    public int stock(String product) {
        if (stocks.get(product) != null) {
            return stocks.get(product);
        } else return 0;
    }
    public boolean take(String product) {
        if (stocks.get(product) != null) {
            if (stocks.get(product) > 0) {
                int newStock = stocks.get(product) - 1;
                stocks.put(product, newStock);
                return true;
            }
        }
        return false;
    }

    public Set<String> products() {
        Set<String> products = new HashSet<String>();
        products.addAll(stocks.keySet());
        products.addAll(prices.keySet());
        return products;
    }
}
