import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {
    private Map<String, Purchase> purchases = new HashMap<String, Purchase>();

    public void add(String product, int price) {
        Purchase purchase = new Purchase(product,1,price);
        if (purchases.containsKey(product)) {
            purchases.get(product).increaseAmount();
        } else {
            purchases.put(product, purchase);
        }

    }

    public int price() {
        int price = 0;
        for (Purchase purchase : purchases.values()) {
            price += purchase.price();
        }
        return price;
    }
    public void print() {
        for (Purchase purchase : purchases.values()) {
            System.out.println(purchase);
        }
    }
}
