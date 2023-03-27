import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Item {

    //Scanner for reading the item file
    private Scanner infile;

    //variable used for item class
    private String name;
    private String description;
    private String location;

    //constructor
    public Item() {

    }

    //constructor
    public Item(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }

    //looks through the item file and stores item properties into an array list
    public void setItem(ArrayList<Item> itemList) {

        try{
            infile = new Scanner(new File("item.txt"));
            Item temp;
            String itemLine;
            String[] itemToken;

            while(infile.hasNext()) {
                itemLine = infile.nextLine();
                itemToken = itemLine.split("~");
                name = itemToken[0];
                description = itemToken[1];
                location = itemToken[2];
                temp = new Item(name, description, location);
                itemList.add(temp);
            }

            infile.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("File not found");
        }

    }

    //retrieve item name
    public String getItemName() {
        return name;
    }

    //retrieve item description
    public String getItemDescription() {
        return description;
    }

    //retrieve item location
    public String getItemLocation() {
        return location;
    }

    //set item location
    public void setItemLocation(String location) {
        this.location = location;
    }
}
