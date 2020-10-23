package ru.products.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.products.domain.Book;
import ru.products.domain.Product;
import ru.products.domain.Smartphone;
import ru.products.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager;

    Product product1 = new Book(1, "Капитанская дочка", 10, "Пушкин");
    Product product2 = new Product(2, "Конфеты", 20);
    Product product3 = new Smartphone(3, "X", 5, "Apple");

    @BeforeEach
    public void setUp() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
        manager = new ProductManager(repository);
    }

    @Test
    public void tesFindById() {
        Product product = new Product(4, "4", 4);
        manager.saveProduct(product);
        assertEquals(manager.searchBy("4").length, 1);
        Product product4 = manager.searchBy("4")[0];
        assertEquals(product4.getId(), 4);
        assertEquals(product4.getName(), "4");
        assertEquals(product4.getPrice(), 4);
    }

    @Test
    public void tesFindByManufacturer() {
        Smartphone smartphone = new Smartphone(4, "IX", 4, "Apple");
        manager.saveProduct(smartphone);
        assertEquals(manager.searchBy("Apple").length, 2);
        Smartphone smartphone1 = (Smartphone) manager.searchBy("Apple")[0];
        assertEquals(smartphone1.getId(), 3);
        assertEquals(smartphone1.getName(), "X");
        assertEquals(smartphone1.getPrice(), 5);
        assertEquals(smartphone1.getManufacturer(), "Apple");
    }

    @Test
    public void tesFindBook() {
        assertEquals(manager.searchBy("Пушкин").length, 1);
        Book book = (Book) manager.searchBy("Пушкин")[0];
        assertEquals(book.getId(), 1);
        assertEquals(book.getName(), "Капитанская дочка");
        assertEquals(book.getPrice(), 10);
        assertEquals(book.getAuthor(), "Пушкин");
    }

    @Test
    public void tesFindBookByName() {
        assertEquals(manager.searchBy("Капитанская дочка").length, 1);
    }

    @Test
    public void tesFindSmartPhoneByName() {
        assertEquals(manager.searchBy("X").length, 1);
    }
}