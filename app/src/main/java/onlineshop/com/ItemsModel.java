package onlineshop.com;

public class ItemsModel {
    private String itemName;
    private String itemDescription;
    private int itemImageName;
    private String itemPrice;

    public ItemsModel(String itemName, String itemDescription, int itemImageName, String itemPrice) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemImageName = itemImageName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemImageName() {
        return itemImageName;
    }

    public void setItemImageName(int itemImageName) {
        this.itemImageName = itemImageName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
