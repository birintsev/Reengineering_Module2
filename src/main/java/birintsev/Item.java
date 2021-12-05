package birintsev;

import lombok.Data;

/**
 * item info
 */
@Data
abstract class Item {

    protected static final int NO_DISCOUNT = 0;

    protected static final int ITEMS_BUY_TO_GET_ADDITIONAL_DISCOUNT = 10;

    protected static final int MAX_DISCOUNT = 80;

    private String title;

    private double price;

    private int quantity;

    /**
     * @param title item title 1 to 32 symbols
     * @param price item ptice in USD, > 0
     * @param quantity item quantity, from 1
     *
     * @throws IllegalArgumentException if some value is wrong
     */
    public Item(String title, double price, int quantity) {
        validateInitialParameters(title, price, quantity);

        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract int calculateDiscount();

    private void validateInitialParameters(
        String title,
        double price,
        int quantity
    ) {
        if (title == null || title.length() == 0 || title.length() > 32)
            throw new IllegalArgumentException("Illegal title");
        if (price < 0.01)
            throw new IllegalArgumentException("Illegal price");
        if (quantity <= 0)
            throw new IllegalArgumentException("Illegal quantity");
    }
}
