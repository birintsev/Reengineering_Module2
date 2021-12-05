package birintsev;

public class SaleItem extends Item {

    public static final int BASE_DISCOUNT = 70;

    public SaleItem(String title, double price, int quantity) {
        super(title, price, quantity);
    }

    @Override
    public int calculateDiscount() {
        int discount = BASE_DISCOUNT;
        discount += getQuantity() / ITEMS_BUY_TO_GET_ADDITIONAL_DISCOUNT;
        if (discount > MAX_DISCOUNT)
            discount = MAX_DISCOUNT;
        return discount;
    }
}
