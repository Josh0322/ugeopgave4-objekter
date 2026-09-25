import java.util.ArrayList;

class Item {
    private String name;
    private int value;
    private String type;
    private static int totalItemsCreated = 0;
    private static int totalItemValue = 0;

    public Item(String name, int value, String type) {
        this.name = name;
        this.value = value;
        this.type = type;

        totalItemsCreated = totalItemsCreated + 1;
        totalItemValue = totalItemValue + value;
    }

    String getName() {
        return name;
    }

    int getValue() {
        return value;
    }

    String getType() {
        return type;
    }

    static int getTotalItemsCreated() {
        return totalItemsCreated;
    }

    static double getAverageItemValue() {
        return (double) totalItemValue / totalItemsCreated;
    }

    public String toString() {
        return name + " (" + type + ") - " + value + " gold";
    }
}


class Inventory {
    private String playerName;
    private ArrayList<Item> items;
    private int maxCapacity;

    Inventory(String playerName, int maxCapacity) {
        this.playerName = playerName;
        this.maxCapacity = maxCapacity;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (items.size() < maxCapacity) {
            items.add(item);
            System.out.println(playerName + " picked up - " + item.getName());
        } else {
            System.out.println("Inventory full! Can't add more " + item.getName());
        }
    }

    public int getTotalValue() {
        int total = 0;

        for (Item item : items) {
            total = total + item.getValue();
        }

        return total;
    }

    public ArrayList<Item> findItemsByType(String type) {
        ArrayList<Item> found = new ArrayList<>();

        for (Item item : items) {
            if (item.getType().equalsIgnoreCase(type)) {
                found.add(item);
            }
        }

        return found;
    }

    public void printInventory() {
        System.out.println(" ");
        System.out.println("=== " + playerName + "'s Inventory ===");
        System.out.println("Capacity: " + items.size() + "/" + maxCapacity);

        for (Item item : items) {
            System.out.println("- " + item);
        }

        System.out.println("Total value: " + getTotalValue() + " gold");
    }
}

void emptyLine() {
    System.out.println(" ");
}

void title(String title) {
    System.out.println("=== " + title + " ===");
}


void main() {
    // Lav inventory
    Inventory player1 = new Inventory("Josh", 15);
    Inventory player2 = new Inventory("Goblin", 10);

    // Tilføj items til spiller 1 og 2
    player1.addItem(new Item("Sword", 100, "weapon"));
    player1.addItem(new Item("Health potion", 50, "potion"));
    player1.addItem(new Item("Shield", 80, "armor"));

    player2.addItem(new Item("Wooden Club", 50, "weapon"));
    player2.addItem(new Item("Health Potion", 40, "potion"));
    player2.addItem(new Item("Leather Armor", 100, "armor"));

    // Print inventories
    player1.printInventory();
    player2.printInventory();

    // Print total items og værdier
    emptyLine();
    title("Game Statistics");
    System.out.println("Total items created: " + Item.getTotalItemsCreated());
    System.out.println("Average item value: " + Item.getAverageItemValue() + " gold");

    // Find items by type
    emptyLine();
    title(player1.playerName + "'s potions");
    ArrayList<Item> potions = player1.findItemsByType("potion");

    for (Item potion : potions) {
        System.out.println("- " + potion);
    }

    emptyLine();
    title(player2.playerName + "'s potions");
    ArrayList<Item> potions2 = player2.findItemsByType("potion");

    for (Item potion : potions2) {
        System.out.println("- " + potion);
    }
}
