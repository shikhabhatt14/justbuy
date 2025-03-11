package com.app.justbuy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProductDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Product#Product()}
     *   <li>{@link Product#setBrand(String)}
     *   <li>{@link Product#setCategory(Category)}
     *   <li>{@link Product#setDescription(String)}
     *   <li>{@link Product#setName(String)}
     *   <li>{@link Product#setPrice(int)}
     *   <li>{@link Product#setSize(String)}
     *   <li>{@link Product#getBrand()}
     *   <li>{@link Product#getCategory()}
     *   <li>{@link Product#getDescription()}
     *   <li>{@link Product#getId()}
     *   <li>{@link Product#getName()}
     *   <li>{@link Product#getPrice()}
     *   <li>{@link Product#getSize()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    @Tag("MaintainedByDiffblue")
    void testGettersAndSetters() {
        // Arrange and Act
        Product actualProduct = new Product();
        actualProduct.setId(0L);
        actualProduct.setBrand("Brand");
        actualProduct.setCategory(Category.FOOD);
        actualProduct.setDescription("The characteristics of someone or something");
        actualProduct.setName("Name");
        actualProduct.setPrice(1);
        actualProduct.setSize("Size");
        String actualBrand = actualProduct.getBrand();
        Category actualCategory = actualProduct.getCategory();
        String actualDescription = actualProduct.getDescription();
        long actualId = actualProduct.getId();
        String actualName = actualProduct.getName();
        int actualPrice = actualProduct.getPrice();

        // Assert
        assertEquals("Brand", actualBrand);
        assertEquals("Name", actualName);
        assertEquals("Size", actualProduct.getSize());
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(0L, actualId);
        assertEquals(1, actualPrice);
        assertEquals(Category.FOOD, actualCategory);
    }

    /**
     * Test getters and setters.
     * <ul>
     *   <li>When {@code Name}.</li>
     * </ul>
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link Product#Product(String, int, Category)}
     *   <li>{@link Product#setBrand(String)}
     *   <li>{@link Product#setCategory(Category)}
     *   <li>{@link Product#setDescription(String)}
     *   <li>{@link Product#setName(String)}
     *   <li>{@link Product#setPrice(int)}
     *   <li>{@link Product#setSize(String)}
     *   <li>{@link Product#getBrand()}
     *   <li>{@link Product#getCategory()}
     *   <li>{@link Product#getDescription()}
     *   <li>{@link Product#getId()}
     *   <li>{@link Product#getName()}
     *   <li>{@link Product#getPrice()}
     *   <li>{@link Product#getSize()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters; when 'Name'")
    @Tag("MaintainedByDiffblue")
    void testGettersAndSetters_whenName() {
        // Arrange and Act
        Product actualProduct = new Product("Name", 1, Category.FOOD);
        actualProduct.setId(0L);
        actualProduct.setBrand("Brand");
        actualProduct.setCategory(Category.FOOD);
        actualProduct.setDescription("The characteristics of someone or something");
        actualProduct.setName("Name");
        actualProduct.setPrice(1);
        actualProduct.setSize("Size");
        String actualBrand = actualProduct.getBrand();
        Category actualCategory = actualProduct.getCategory();
        String actualDescription = actualProduct.getDescription();
        long actualId = actualProduct.getId();
        String actualName = actualProduct.getName();
        int actualPrice = actualProduct.getPrice();

        // Assert
        assertEquals("Brand", actualBrand);
        assertEquals("Name", actualName);
        assertEquals("Size", actualProduct.getSize());
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(0L, actualId);
        assertEquals(1, actualPrice);
        assertEquals(Category.FOOD, actualCategory);
    }
}
