package birintsev;

public class SecondFreeItem extends Item {

    private static final int BULK_DISCOUNT = 50;

    private static final int ITEMS_TO_BUT_TO_GET_DISCOUNT = 2;

    public SecondFreeItem(String title, double price, int quantity) {
        super(title, price, quantity);
    }

    @Override
    public int calculateDiscount() {
        int discount = NO_DISCOUNT;
        if (getQuantity() >= ITEMS_TO_BUT_TO_GET_DISCOUNT)
            discount = BULK_DISCOUNT;
        discount += getQuantity() / ITEMS_BUY_TO_GET_ADDITIONAL_DISCOUNT;
        if (discount > MAX_DISCOUNT)
            discount = MAX_DISCOUNT;
        return discount;
    }
}
