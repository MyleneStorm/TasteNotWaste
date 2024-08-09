package DataAccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAOImpl implements PurchaseDAO {
    private Connection connection;

    private static final String INSERT_PURCHASE_SQL = "INSERT INTO purchases (consumer_id, purchase_date) VALUES (?, ?)";
    private static final String SELECT_PURCHASES_BY_CONSUMER_ID_SQL = "SELECT * FROM purchases WHERE consumer_id = ?";
    private static final String SELECT_PURCHASE_ITEMS_BY_CONSUMER_ID_SQL = "SELECT * FROM purchase_items WHERE purchase_id IN (SELECT purchase_id FROM purchases WHERE consumer_id = ?)";
    private static final String SELECT_PURCHASE_BY_ID_SQL = "SELECT * FROM purchases WHERE purchase_id = ?";

        public PurchaseDAOImpl() throws SQLException, ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
        
    @Override
    public void createPurchase(PurchaseDTO purchase) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PURCHASE_SQL)) {
            preparedStatement.setInt(1, purchase.getConsumerId());
            preparedStatement.setDate(2, Date.valueOf(purchase.getPurchaseDate()));
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<PurchaseDTO> getPurchasesByConsumerId(int consumerId) throws SQLException {
        List<PurchaseDTO> purchases = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PURCHASES_BY_CONSUMER_ID_SQL)) {
            preparedStatement.setInt(1, consumerId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int purchaseId = rs.getInt("purchase_id");
                Date purchaseDate = rs.getDate("purchase_date");
                purchases.add(new PurchaseDTO(purchaseId, consumerId, purchaseDate.toLocalDate()));
            }
        }
        return purchases;
    }

    @Override
    public List<PurchaseItemDTO> getPurchaseItemsByConsumerId(int consumerId) throws SQLException {
        List<PurchaseItemDTO> purchaseItems = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PURCHASE_ITEMS_BY_CONSUMER_ID_SQL)) {
            preparedStatement.setInt(1, consumerId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int purchaseItemId = rs.getInt("purchase_item_id");
                int purchaseId = rs.getInt("purchase_id");
                int itemId = rs.getInt("item_id");
                int quantity = rs.getInt("quantity");
                purchaseItems.add(new PurchaseItemDTO(purchaseItemId, purchaseId, itemId, quantity));
            }
        }
        return purchaseItems;
    }

    @Override
    public PurchaseDTO getPurchaseById(int purchaseId) throws SQLException {
        PurchaseDTO purchase = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PURCHASE_BY_ID_SQL)) {
            preparedStatement.setInt(1, purchaseId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int consumerId = rs.getInt("consumer_id");
                Date purchaseDate = rs.getDate("purchase_date");
                purchase = new PurchaseDTO(purchaseId, consumerId, purchaseDate.toLocalDate());
            }
        }
        return purchase;
    }
}
