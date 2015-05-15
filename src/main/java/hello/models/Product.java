package hello.models;

import com.fasterxml.jackson.annotation.JsonView;
import hello.web.view.View;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "product")
public class Product extends BaseModel<Product>{

    public final static BaseModel.Repo<Product> REPO = new BaseModel.Repo<Product>(Product.class);

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @JsonView(View.ProductListing.class)
    private String productName;

    @JsonView(View.ProductListing.class)
    private int productPrice;

    public int getProductId() {
        return productId;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public String getProductName() {
        return productName;
    }

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
