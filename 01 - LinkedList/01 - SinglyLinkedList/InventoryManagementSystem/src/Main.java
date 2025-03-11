public class Main {
    public static void main(String[] args) {
        InventoryLinkedList list = new InventoryLinkedList();

        // Add items to the inventory
        list.addItem("Apple", 101, 50, 0.50);
        list.addItem("Banana", 102, 30, 0.30);
        list.addItem("Orange", 103, 20, 0.40);
        list.addItemAtBeginning("Grapes", 104, 15, 1.20);

        System.out.println("Inventory:");
        list.displayInventory();

        // Update quantity of an item
        list.updateQuantity(102, 40);
        System.out.println("After updating quantity for item Banana :");
        list.displayInventory();

        // Search for an item by ID and by name
        System.out.println("Searching for item with ID 103:");
        list.search(103, ""); // using ID only

        System.out.println("Searching for item with name 'Grapes':");
        list.search(0, "Grapes"); // using name only

        // Remove an item (e.g., remove Apple with ID 101)
        list.removeItem(101);
        System.out.println("After removing item with ID 101:");
        list.displayInventory();

        // Sort inventory by item name in ascending order
        list.sortNameByAscending();
        System.out.println("Inventory sorted by name ascending:");
        list.displayInventory();

        // Sort inventory by price in descending order
        list.sortPriceBy("desc");
        System.out.println("Inventory sorted by price descending :");
        list.displayInventory();

        // Calculate and display the total inventory value
        list.calculateTotalValue();

    }
}