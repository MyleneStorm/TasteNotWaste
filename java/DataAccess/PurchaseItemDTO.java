package DataAccess;

public class PurchaseItemDTO {
    private int purchaseItemId;
    private int purchaseId;
    private int itemId;
    private int quantity;

    public PurchaseItemDTO(int purchaseItemId, int purchaseId, int itemId, int quantity) {
        this.purchaseItemId = purchaseItemId;
        this.purchaseId = purchaseId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public int getPurchaseItemId() {
        return purchaseItemId;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPurchaseItemId(int purchaseItemId) {
        this.purchaseItemId = purchaseItemId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
