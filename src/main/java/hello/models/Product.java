package hello.models;

/**
 * Created by chanduk on 12/05/15.
 */
public class Product {
    private int productId;
    private String productName;

    public int getProductPrice() {
        return productPrice;
    }

    private int productPrice;

    public Product(int productId, String productName, int productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        return !(productName != null ? !productName.equals(product.productName) : product.productName != null);

    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        return result;
    }
}
