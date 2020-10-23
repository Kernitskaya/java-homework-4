package ru.products.manager;

import ru.products.domain.Book;
import ru.products.domain.Product;
import ru.products.domain.Smartphone;
import ru.products.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public Product[] searcyBy(String text) {
        Product[] result = new Product[0];
        for (Product product: repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    private boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            return book.getName().equalsIgnoreCase(search) || book.getAuthor().equalsIgnoreCase(search);
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            return smartphone.getName().equalsIgnoreCase(search) || smartphone.getManufacturer().equalsIgnoreCase(search);
        }
        else {
            return String.valueOf(product.getId()).equalsIgnoreCase(search);
        }
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }

}
