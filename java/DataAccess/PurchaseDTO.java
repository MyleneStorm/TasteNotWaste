package DataAccess;

import java.time.LocalDate;
import DataAccess.*;


public class PurchaseDTO {
    private int purchaseId;
    private int consumerId;
    private LocalDate purchaseDate;

    public PurchaseDTO(int purchaseId, int consumerId, LocalDate purchaseDate) {
        this.purchaseId = purchaseId;
        this.consumerId = consumerId;
        this.purchaseDate = purchaseDate;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public int getConsumerId() {
        return consumerId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setConsumerId(int consumerId) {
        this.consumerId = consumerId;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
