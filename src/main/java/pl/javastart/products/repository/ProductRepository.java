package pl.javastart.products.repository;

import org.springframework.stereotype.Repository;
import pl.javastart.products.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    List<Product> products ;

    public ProductRepository() {
        products = new ArrayList<>();
        products.add(new Product("mleko", 2));

    }

    public List<Product> showAll() {
        return products;
    }
}
