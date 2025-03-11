public class InventoryNode {
    private Inventory inventory;
    private InventoryNode next;

    public InventoryNode(Inventory inventory){
        this.inventory = inventory;
        this.next = null;
    }

    public Inventory getInventory(){
        return inventory;
    }
    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public InventoryNode getNext(){
        return next;
    }
    public void setNext(InventoryNode next){
        this.next = next;
    }
}
