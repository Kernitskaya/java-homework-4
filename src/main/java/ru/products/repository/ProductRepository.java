package ru.products.repository;

import ru.products.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public void removeById(int id) {
        int index = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Product[] tmp = new Product[items.length - 1];
            items[index] = null;
            int currentIndex = 0;
            for (int i = 0; i < items.length; i++) {
                if (items[i] != null) {
                    tmp[currentIndex] = items[i];
                    currentIndex++;
                }
            }
            items = tmp;
        }
    }
}
