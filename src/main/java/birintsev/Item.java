package birintsev;

import lombok.Data;

/**
 * item info
 */
@Data
class Item { // TODO: add @Data (lombok); encapsulate the fields
    private String title;
    private double price;
    private int quantity;
    private ItemType type;
}
