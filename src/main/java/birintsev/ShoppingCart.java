package birintsev;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Containing items and calculating price.
 */
public class ShoppingCart {

    private static final NumberFormat MONEY;

    static {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        MONEY = new DecimalFormat("$#.00", symbols);
    }

    /** Container for added items */
    private List<Item> items = new ArrayList<>();

    /**
     * Appends to sb formatted value.
     * Trims string if its length > width.
     * @param align -1 for align left, 0 for center and +1 for align right.
     */
    public static void appendFormatted(
        StringBuilder sb,
        String value,
        int align,
        int width
    ) {
        if (value.length() > width)
            value = value.substring(0,width);
        int before = (align == 0)
            ? (width - value.length()) / 2
            : (align == -1) ? 0 : width - value.length();
        int after = width - value.length() - before;
        while (before-- > 0)
            sb.append(" ");
        sb.append(value);
        while (after-- > 0)
            sb.append(" ");
        sb.append(" ");
    }

    /**
     * Tests all class methods.
     */
    public static void main(String[] args) {
        // TODO: add tests here
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new NewItem("Apple", 0.99, 5));
        cart.addItem(new SecondFreeItem("Banana", 20.00, 4));
        cart.addItem(new SaleItem("A long piece of toilet paper", 17.20, 1));
        System.out.println(cart.formatTicket());
    }

    /**
     * Adds new item.
     */
    private void addItem(Item item) {
        items.add(item);
    }

    /**
     * Formats shopping price.
     *
     * @return string as lines, separated with \n,
     * first line: # Item Price Quan. Discount Total
     * second line: ---------------------------------------------------------
     * next lines: NN Title $PP.PP Q DD% $TT.TT
     * 1 Some title $.30 2 - $.60
     * 2 Some very long $100.00 1 50% $50.00
     * ...
     * 31 Item 42 $999.00 1000 - $999000.00
     * end line: ---------------------------------------------------------
     * last line: 31 $999050.60
     *
     * if no items in cart returns "No items." string.
     */
    public String formatTicket() {
        if (items.size() == 0)
            return "No items.";
        List<String[]> lines = new ArrayList<>();
        String[] header = {
            "#", "Item", "Price", "Quan.", "Discount", "Total"
        };
        int[] align = new int[] { 1, -1, 1, 1, 1, 1 };
        // formatting each line
        double total = 0.00;
        int index = 0;
        for (Item item : items) {
            int discount = item.calculateDiscount();
            double itemTotal = item.getPrice()
                * item.getQuantity()
                * (100.00 - discount)
                / 100.00;
            lines.add(new String[] {
                String.valueOf(++index),
                item.getTitle(),
                MONEY.format(item.getPrice()),
                String.valueOf(item.getQuantity()),
                (discount == 0) ? "-" : (discount + "%"),
                MONEY.format(itemTotal)
            });
            total += itemTotal;
        }
        String[] footer = {
            String.valueOf(index), "", "", "", "", MONEY.format(total)
        };
        // formatting table
        // column max length
        int[] width = new int[] { 0, 0, 0, 0, 0, 0 };
        for (String[] line : lines)
            for (int i = 0; i < line.length; i++)
                width[i] = Math.max(width[i], line[i].length());
        for (int i = 0; i < header.length; i++)
            width[i] = Math.max(width[i], header[i].length());
        for (int i = 0; i < footer.length; i++)
            width[i] = Math.max(width[i], footer[i].length());
        // line length
        int lineLength = width.length - 1;
        for (int w : width)
            lineLength += w;
        StringBuilder sb = new StringBuilder();
        // header
        for (int i = 0; i < header.length; i++)
            appendFormatted(sb, header[i], align[i], width[i]);
        sb.append("\n");
        // separator
        for (int i = 0; i < lineLength; i++)
            sb.append("-");
        sb.append("\n");
        // lines
        for (String[] line : lines) {
            for (int i = 0; i < line.length; i++)
                appendFormatted(sb, line[i], align[i], width[i]);
            sb.append("\n");
        }
        if (lines.size() > 0) {
            // separator
            for (int i = 0; i < lineLength; i++)
                sb.append("-");
            sb.append("\n");
        }
        // footer
        for (int i = 0; i < footer.length; i++)
            appendFormatted(sb, footer[i], align[i], width[i]);
        return sb.toString();
    }
}
