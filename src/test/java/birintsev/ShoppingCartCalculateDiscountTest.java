package birintsev;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ShoppingCartCalculateDiscountTest {

    private static final int VALID_PRICE = 1;

    @Test
    public void calculateDiscount_secondFree_oneItem() {
        testSecondFreeTypeDiscount(0, 1);
    }

    @Test
    public void calculateDiscount_secondFree_almostTenItems() {
        testSecondFreeTypeDiscount(50, 9);
    }

    @Test
    public void calculateDiscount_secondFree_moreThanTenItems() {
        testSecondFreeTypeDiscount(51, 11);
    }

    @Test
    public void calculateDiscount_secondFree_moreThanTwoTensItems() {
        testSecondFreeTypeDiscount(60, 101);
    }

    @Test
    public void calculateDiscount_secondFree_discountOverflow() {
        testSecondFreeTypeDiscount(80, 300);
    }

    @Test
    public void calculateDiscount_sale_oneItem() {
        testSaleTypeDiscount(70, 1);
    }

    @Test
    public void calculateDiscount_sale_almostTenItems() {
        testSaleTypeDiscount(70, 9);
    }

    @Test
    public void calculateDiscount_sale_tenItems() {
        testSaleTypeDiscount(71, 10);
    }

    @Test
    public void calculateDiscount_sale_discountOverflow() {
        testSaleTypeDiscount(80, 200);
    }

    @Test
    public void calculateDiscount_new_oneItem() {
        testNewTypeDiscount(0, 1);
    }

    @Test
    public void calculateDiscount_new_almostTenItems() {
        testNewTypeDiscount(0, 9);
    }

    @Test
    public void calculateDiscount_new_tenItems() {
        testNewTypeDiscount(0, 10);
    }

    @Test
    public void calculateDiscount_new_moreThanTenItems() {
        testNewTypeDiscount(0, 11);
    }

    @Test
    public void calculateDiscount_new_discountOverflow() {
        testNewTypeDiscount(0, 300);
    }

    private void testCalculateDiscount(
        int expected,
        Item item
    ) {
        assertEquals(
            expected,
            item.calculateDiscount()
        );
    }

    private void testSecondFreeTypeDiscount(int expected, int quantity) {
        testCalculateDiscount(
            expected,
            new SecondFreeItem("SecondFreeItem", VALID_PRICE, quantity)
        );
    }

    private void testSaleTypeDiscount(int expected, int quantity) {
        testCalculateDiscount(
            expected,
            new SaleItem("SaleItem", VALID_PRICE, quantity)
        );
    }

    private void testNewTypeDiscount(int expected, int quantity) {
        testCalculateDiscount(
            expected,
            new NewItem("NewItem", VALID_PRICE, quantity)
        );
    }
}
