package birintsev;

public class NewItem extends Item {

    public NewItem(String title, double price, int quantity) {
        super(title, price, quantity);
    }

    @Override
    public int calculateDiscount() {
        return NO_DISCOUNT;
    }
}
