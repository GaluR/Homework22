package pl.javastart.products.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.products.model.Product;
import pl.javastart.products.repository.ProductRepository;

import java.util.List;

@Controller
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/lista")
    public String showProducts(Model model) {
        double sum = 0;
        List<Product> products = productRepository.showAll();
        for (int i = 0; i < products.size(); i++) {
            sum += products.get(i).getPrice();
        }
        model.addAttribute("products", products);
        model.addAttribute("sum", sum);
        return "productlist";
    }
    @GetMapping("/tabela")
    public String showProductsTable(Model model) {
        double sum = 0;
        List<Product> products = productRepository.showAll();
        for (int i = 0; i < products.size(); i++) {
            sum += products.get(i).getPrice();
        }
        model.addAttribute("products", products);
        model.addAttribute("sum", sum);
        return "table";
    }


    @RequestMapping("/add")  //metoda dodająca produkt do listy
    public String add(@RequestParam String nazwa, @RequestParam String cena) {
        if (nazwa.isEmpty() || cena.isEmpty()) {
            return "redirect:/";
        } else {
            Product product = new Product(nazwa, Double.parseDouble(cena));
            productRepository.showAll().add(product);
            return "redirect:success.html";
        }

    }
}
