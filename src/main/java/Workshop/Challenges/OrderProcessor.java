package Workshop.Challenges;

// Round 1: Extract Methods
// Round 2: Introduce Objects
// Round 3: Apply Tell Don't Ask.

// Anyone know why I'm doing this in IntelliJ and not VS Code/Cursor/Native Windsurf?

public class OrderProcessor {

    private int stock;

    public String processOrder(String customerId, String[] items,
                               String shippingAddress, String paymentMethod) {

        if (customerId == null) return "customer id is null";

        // Validate customer
        if (customerId == null || customerId.equals("")) {
            return "ERROR: Invalid customer";
        }

        // Check inventory
        for (int i = 0; i < items.length; i++) {
            // Database call in loop
            String query = "SELECT stock FROM inventory WHERE item_id = '" + items[i] + "'";
            // ... database logic
            if (stock < 1) {
                return "ERROR: Item " + items[i] + " out of stock";
            }
        }

        // Calculate total
        double total = 0.0;
        for (int i = 0; i < items.length; i++) {
            String priceQuery = "SELECT price FROM products WHERE id = '" + items[i] + "'";
            // ... more database logic
            int price = 1;
            total += price;
        }

        // Apply discounts
        if (customerId.startsWith("VIP")) {
            total = total * 0.9;
        } else if (customerId.startsWith("REGULAR")) {
            total = total * 0.95;
        }

        // Process payment
        if (paymentMethod.equals("CREDIT")) {
            // Credit card logic (50 lines)
        } else if (paymentMethod.equals("PAYPAL")) {
            // PayPal logic (40 lines)
        }

        // Update inventory
        for (int i = 0; i < items.length; i++) {
            String updateQuery = "UPDATE inventory SET stock = stock - 1 WHERE item_id = '" + items[i] + "'";
            // ... update logic
        }

        // Send confirmation email
        String emailBody = "Dear customer " + customerId + ", your order for ";
        for (int i = 0; i < items.length; i++) {
            emailBody += items[i];
            if (i < items.length - 1) emailBody += ", ";
        }
        emailBody += " has been processed. Total: $" + total;
        // ... email sending logic

        return "SUCCESS";
    }

    // Extractions
    // Order, Customer, InventoryChecker, PriceCalculator, PaymentProcessor
}
