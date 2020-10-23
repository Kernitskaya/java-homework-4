package ru.products.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.products.domain.Book;
import ru.products.domain.Product;
import ru.products.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product product1 = new Book(1, "Капитанская дочка", 10, "Пушкин");
    Product product2 = new Product(2, "Конфеты", 20);
    Product product3 = new Smartphone(3, "Redmi", 30, "Xiaomi");

    @BeforeEach
    void setUp() {
        repository.save(product1);
        repository.save(product2);
        repository.save(product3);
    }

    @Test
    public void testSaveAndFindAll() {
        assertEquals(repository.findAll().length, 3);
    }

    @Test
    public void testRemoveById() {
        repository.removeById(3);
        assertEquals(repository.findAll().length, 2);
    }

    @Test
    public void testRemoveNotExist() {
        repository.removeById(10);
        assertEquals(repository.findAll().length, 3);
    }
}