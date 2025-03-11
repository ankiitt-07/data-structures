public class InventoryLinkedList {
    private InventoryNode head;

    public InventoryLinkedList() {
        head = null;
    }

    // Add an item at the end of the list
    public void addItem(String itemName, int itemID, int quantity, double price) {
        Inventory newInventory = new Inventory(itemName, itemID, quantity, price);
        InventoryNode newNode = new InventoryNode(newInventory);
        if (head == null) {
            head = newNode;
        } else {
            InventoryNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    // Display all inventory items
    public void displayInventory() {
        InventoryNode temp = head;
        while (temp != null) {
            Inventory inv = temp.getInventory();
            System.out.println("Item Name: " + inv.getItemName() +
                    " | Item ID: " + inv.getItemId() +
                    " | Quantity: " + inv.getQuantity() +
                    " | Price: " + inv.getPrice());
            temp = temp.getNext();
        }
        System.out.println();
    }

    // Add an item at the beginning of the list
    public void addItemAtBeginning(String itemName, int itemID, int quantity, double price) {
        Inventory newInventory = new Inventory(itemName, itemID, quantity, price);
        InventoryNode newNode = new InventoryNode(newInventory);
        newNode.setNext(head);
        head = newNode;
    }

    // Add an item at the end of the list (alias for addItem)
    public void addItemAtEnd(String itemName, int itemID, int quantity, double price) {
        addItem(itemName, itemID, quantity, price);
    }

    // Remove an item by its item ID
    public void removeItem(int itemID) {
        // Special case for head node
        if (head != null && head.getInventory().getItemId() == itemID) {
            head = head.getNext();
            return;
        }

        InventoryNode temp = head;
        while (temp != null && temp.getNext() != null &&
                temp.getNext().getInventory().getItemId() != itemID) {
            temp = temp.getNext();
        }

        // If found, remove the node
        if (temp != null && temp.getNext() != null) {
            temp.setNext(temp.getNext().getNext());
        }
    }

    // Update the quantity of an item by item ID
    public void updateQuantity(int itemID, int newQuantity) {
        InventoryNode temp = head;
        while (temp != null && temp.getInventory().getItemId() != itemID) {
            temp = temp.getNext();
        }
        if (temp != null && temp.getInventory().getItemId() == itemID) {
            temp.getInventory().setQuantity(newQuantity);
        }
    }

    // Calculate and display the total inventory value (quantity * price)
    public void calculateTotalValue() {
        InventoryNode temp = head;
        double totalPrice = 0.0;
        while (temp != null) {
            Inventory inv = temp.getInventory();
            totalPrice += inv.getQuantity() * inv.getPrice();
            temp = temp.getNext();
        }
        System.out.println("Total Price: " + totalPrice);
    }

    // Search for an item by item ID or item name (case-insensitive)
    public void search(int itemID, String itemName) {
        InventoryNode temp = head;
        while (temp != null) {
            Inventory inv = temp.getInventory();
            if (inv.getItemId() == itemID || inv.getItemName().equalsIgnoreCase(itemName)) {
                System.out.println("Item Name: " + inv.getItemName() +
                        " | Item ID: " + inv.getItemId() +
                        " | Quantity: " + inv.getQuantity() +
                        " | Price: " + inv.getPrice());
                return;
            }
            temp = temp.getNext();
        }
        System.out.println("Item not found");
    }

    // Sort the inventory by item name in ascending order
    public void sortNameByAscending() {
        InventoryNode temp = head;
        while (temp != null) {
            InventoryNode temp2 = temp.getNext();
            while (temp2 != null) {
                if (temp.getInventory().getItemName().compareTo(temp2.getInventory().getItemName()) > 0) {
                    // Swap the Inventory objects in the two nodes
                    Inventory swap = temp.getInventory();
                    temp.setInventory(temp2.getInventory());
                    temp2.setInventory(swap);
                }
                temp2 = temp2.getNext();
            }
            temp = temp.getNext();
        }
    }

    // Sort the inventory by price in ascending ("asc") or descending ("desc") order
    public void sortPriceBy(String order) {
        InventoryNode temp = head;
        while (temp != null) {
            InventoryNode temp2 = temp.getNext();
            while (temp2 != null) {
                if (order.equalsIgnoreCase("asc")) {
                    if (temp.getInventory().getPrice() > temp2.getInventory().getPrice()) {
                        Inventory swap = temp.getInventory();
                        temp.setInventory(temp2.getInventory());
                        temp2.setInventory(swap);
                    }
                } else { // descending
                    if (temp.getInventory().getPrice() < temp2.getInventory().getPrice()) {
                        Inventory swap = temp.getInventory();
                        temp.setInventory(temp2.getInventory());
                        temp2.setInventory(swap);
                    }
                }
                temp2 = temp2.getNext();
            }
            temp = temp.getNext();
        }
    }
}
