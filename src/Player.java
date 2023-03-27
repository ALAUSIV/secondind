import java.util.ArrayList;
public class Player {
    //variables used for player class
    private String location;
    private ArrayList<String> inventory = new ArrayList<String>();

    //constructor
    public Player() {

    }

    //constructor
    public Player(String location, ArrayList<String> inventory) {
        this.location = location;
        this.inventory = inventory;
    }

    //retrieve player location
    public String getLocation() {
        return location;
    }

    //set player location
    public void setLocation(String location) {
        this.location = location;
    }

    //add to player inventory
    public void setInventory(String item) {
        this.inventory.add(item);
    }

    //display player inventory
    public ArrayList<String> getInventory() {
        return inventory;
    }
}
