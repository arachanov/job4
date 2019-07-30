package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];
    private static final Random RN = new Random();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        //Реализовать метод генерации.
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    public Item findById(String id) {
        Item result = null;
        for (Item item: items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (Item replaceTo : items) {
            if (replaceTo != null && replaceTo.getId().equals(id)) {
                replaceTo.setName(item.getName());
                replaceTo.setDecs(item.getDecs());
                replaceTo.setTime(item.getTime());
                result = true;
                break;
            }

        }
        return result;
    }
    public  boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.items.length - (i + 1));
                position--;
                result = true;
                break;
            }
        }
        return result;
    }
    public Item[] findAll() {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] == null) {
                break;
            }
        }
        return Arrays.copyOf(this.items, this.position);
    }
    public Item[] findByName(String key) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                break;
            }
        }
        return Arrays.copyOf(this.items, this.position);
    }

}