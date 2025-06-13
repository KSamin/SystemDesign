import java.util.ArrayList;
import java.util.List;

class Product{
    public String name;
    public double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }
}
class ShoppingCart{
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }
    public List<Product> geProducts(){
        return products;
    }

    public double calculateTotal(){
        double total = 0;
        for(Product p:products){
            total += p.price;
        }
        return total;
    }
}

class ShoppingCartPrinter {
    private ShoppingCart cart;

    public ShoppingCartPrinter(ShoppingCart cart){
        this.cart = cart;
    }

    public void printInvoice() {
        System.out.println("Shoppint cart invoice: ");
        for(Product p:cart.geProducts()){
            System.out.println(p.name+" - Rs "+p.price);
        }
        System.out.println("Total: Rs "+ cart.calculateTotal());
    }
}
class ShoppingCartStorage {
    private ShoppingCart cart;
    public ShoppingCartStorage(ShoppingCart cart){
        this.cart = cart;
    }

    public void saveToDatabase(){
        System.out.println("saving shopping to database...");
    }
}
public class SingleResponsibiltyFollowed {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("laptop",50000));
        cart.addProduct(new Product("mobile",12000));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        ShoppingCartStorage db = new ShoppingCartStorage(cart);
        db.saveToDatabase();
    }
}
