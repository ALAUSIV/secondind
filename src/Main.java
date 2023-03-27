import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //Scanner and String to accept user input and store it
        Scanner input = new Scanner(System.in);
        String command = "";

        //boolean to start game loop
        boolean end = false;

        //String and String Array to store room connections
        String connection = "";
        String[] conList = new String[4];

        //Initializes Array List that stores rooms and splits up the room connection string
        ArrayList<Room> roomList = new ArrayList<>();
        Room room = new Room();
        room.setRoom(roomList);
        connection = roomList.get(0).getConnections();
        conList = connection.split(",");


        //initializes player and sets it to start in the first room
        Player pawn = new Player();
        pawn.setLocation(roomList.get(0).getRoomID());

        //initializes array list that stores game items
        ArrayList<Item> itemList = new ArrayList<>();
        Item item = new Item();
        item.setItem(itemList);


        //initializes array list that stores game puzzles
        ArrayList<Puzzle> puzzleList = new ArrayList<>();
        Puzzle puzzle = new Puzzle();
        puzzle.setPuzzle(puzzleList);

        //game loop starts
        while(end == false){

            //check for puzzle in room
            puzzleCheck(roomList, puzzleList, pawn, input);

            //prints room info
            printRoomInfo(roomList, pawn);

            //asks for command
            commands(roomList, command, input, conList, pawn, connection, itemList);

            System.out.println("--------d------------------------");

            //updates room connections
            connection = roomList.get(Integer.parseInt(pawn.getLocation()) - 1).getConnections();
            conList = connection.split(",");
        }




    }

    //Method for printing out room name, description, and if the room has been visited
    public static void printRoomInfo(ArrayList<Room> roomList, Player pawn) {
        //checks to see if room has been visited
        if(roomList.get(Integer.parseInt(pawn.getLocation()) - 1).getVisited() == "true") {
            System.out.println("This room looks familiar...");
        }

        //prints room name and description
        System.out.println("Location: " + roomList.get(Integer.parseInt(pawn.getLocation()) - 1).getRoomName());
        System.out.println("Description: " + roomList.get(Integer.parseInt(pawn.getLocation()) - 1).getDescription());
        System.out.println("--------------------------------");
    }

    //Method for reading user game commands
    public static void commands(ArrayList<Room> roomList,String command,
                                Scanner input, String[] conList, Player pawn,
                                String connection, ArrayList<Item> itemList) {

        //A little menu showing the commands that the player can input
        System.out.println("What do you want to do?");
        System.out.println();
        System.out.println("Commands:");
        System.out.println("Move ([N]orth,[E]ast,[S]outh,[W]est)");
        System.out.println("Examine room (Explore)");
        System.out.println("--------------------------------");
        System.out.println("Pickup/Inspect/Drop [Item Name]");
        System.out.println("Inventory");
        System.out.println("--------------------------------");
        System.out.println("Exit Game (Exit)");
        System.out.println("--------------------------------");

        //sets current room visited as true
        roomList.get(Integer.parseInt(pawn.getLocation()) - 1).setVisited("true");

        //takes and stores user input
        command = input.nextLine().toLowerCase();

        //splits command into two strings and stores them in an array
        String strArr[] = command.split(" ");
        System.out.println();

        //switch for all commands
        switch (strArr[0]) {

            //If user input is navigational
            case "n":
            case "north":

                //If connection number is 0
                if(conList[0].equals("0")) {
                    System.out.println("Oops, can't go that way.");
                }
                else {
                    System.out.println("You're going north!");
                    pawn.setLocation(conList[0]);
                }
                break;

            case "e":
            case "east":

                if(conList[1].equals("0")) {
                    System.out.println("Oops, can't go that way.");
                }
                else {
                    System.out.println("You're going east!");
                    pawn.setLocation(conList[1]);
                }
                break;

            case "s":
            case "south":

                if(conList[2].equals("0")) {
                    System.out.println("Oops, can't go that way.");
                }
                else {
                    System.out.println("You're going south!");
                    pawn.setLocation(conList[2]);
                }
                break;

            case "w":
            case "west":

                if(conList[3].equals("0")) {
                    System.out.println("Oops, can't go that way.");
                }
                else {
                    System.out.println("You're going west!");
                    pawn.setLocation(conList[3]);
                }
                break;

            //If user inputs explore
            case "explore":

                System.out.println("Items: ");

                //goes through the itemList arraylist and compares the item location to the players location
                for (int i = 0; i < itemList.size(); i++) {
                    if (itemList.get(i).getItemLocation().equals(pawn.getLocation())) {
                        System.out.println("There is a " +
                                itemList.get(i).getItemName() + " here!");
                    }
                }
                break;

            //if user inputs pickup
            case "pickup":

                //goes through item list
                for (int i = 0; i < itemList.size(); i++) {

                    //if item location equals player location and item name equals the second string in user input
                    if (itemList.get(i).getItemLocation().equals(pawn.getLocation()) &&
                    itemList.get(i).getItemName().equals(strArr[1])) {

                        //places the item into the players inventory and sets item location to 0 (not in any room)
                        pawn.setInventory(itemList.get(i).getItemName());
                        itemList.get(i).setItemLocation("0");

                        System.out.println(itemList.get(i).getItemName() + " has been picked" +
                                " up from the room and successfully added to the player" +
                                " inventory");
                    }
                }
                break;

            //if user inputs inspect
            case "inspect":

                //checks if inventory is empty
                if(pawn.getInventory().isEmpty() == true){
                    System.out.println("There are no items to inspect in your inventory");
                }
                else {
                    //goes through player inventory for item name that was input by player
                    for(int i = 0; i < pawn.getInventory().size(); i++) {
                        if(strArr[1].equals(pawn.getInventory().get(i))) {

                            //goes through itemList array for the item description using the item name input by player
                            for(int k = 0; k < itemList.size(); k++) {
                                if(strArr[1].equals(itemList.get(k).getItemName())) {
                                    System.out.println(itemList.get(k).getItemDescription());
                                }
                            }
                        }
                    }
                }
                break;

            //if user input drop
            case "drop":

                //checks if inventory is empty
                if(pawn.getInventory().isEmpty() == true){
                    System.out.println("There are no items in your inventory to drop");
                }
                else{

                    //looks through inventory and compares input item name to name of item in inventory
                    //then removes item from inventory
                    for(int i =0; i < pawn.getInventory().size(); i++) {
                        if(strArr[1].equals(pawn.getInventory().get(i))) {
                            pawn.getInventory().remove(i);
                        }
                    }

                    //goes through itemList array for item input by user and sets the item location to current room
                    for(int i = 0; i < itemList.size(); i++) {
                        if(strArr[1].equals(itemList.get(i).getItemName())) {
                            itemList.get(i).setItemLocation(pawn.getLocation());
                        }
                    }
                    System.out.println(strArr[1] + " has been dropped successfully from the player inventory" +
                            " and placed in " + roomList.get(Integer.parseInt(pawn.getLocation()) - 1).getRoomName());
                }

                break;

            //If user inputs inventory
            case "inventory":

                //checks to see if inventory is empty
                if(pawn.getInventory().isEmpty() == true){
                    System.out.println("You didn't pick up any items yet");
                }
                //displays player inventory
                else {
                    System.out.println("Inventory: ");
                    System.out.println(pawn.getInventory());
                }
                break;

            //if user inputs exit
            case "exit":

                //exits program
                System.out.println("The white walls consume your mind, driving you mad...");
                System.exit(0);
                break;

            //If user does not input a valid command
            default:
                System.out.println("That is not a valid option");
                System.out.println();
        }
    }

    //Method that checks if a puzzle is associated with a room
    public static void puzzleCheck(ArrayList<Room> roomList, ArrayList<Puzzle> puzzleList, Player pawn,
                                   Scanner input) {
        //String stores user input
        String answer = "";

        //looks through puzzleList array
        for(int i =0; i < puzzleList.size(); i++) {

            //if player location is equal to puzzle location and puzzle is not solved
            if(pawn.getLocation().equals(puzzleList.get(i).getLocation())
                    && puzzleList.get(i).getSolved().equals("false")) {

                //loop using the number of attempts for puzzle
                for (int k = 0; k < Integer.valueOf(puzzleList.get(i).getAttempts()); k++) {

                    //prints puzzle question
                    System.out.println("Puzzle: " + puzzleList.get(i).getPuzzleQuestion());
                    System.out.println("--------------------------------");
                    //stores user input
                    answer = input.nextLine().toLowerCase();

                    //if answer is wrong
                    if (!answer.equals(puzzleList.get(i).getPuzzleAnswer())) {
                        //prints wrong answer message
                        System.out.println(puzzleList.get(i).getWrongMessage());
                        //prints the amount of attempts left
                        System.out.println("You have " + (Integer.valueOf(puzzleList.get(i).getAttempts()) - (k + 1) +
                                " attempts left. Try again!"));
                        System.out.println("--------------------------------");
                    }

                    //if answer is correct
                    else if (answer.equals(puzzleList.get(i).getPuzzleAnswer())) {
                        //displays correct answer message
                        System.out.println(puzzleList.get(i).getCorrectMessage());
                        System.out.println("--------------------------------");
                        //sets puzzle to solved
                        puzzleList.get(i).setSolved("true");
                        return;
                    }

                    //if the number of attempts equals number of loops plus 1, print puzzle failed
                    if(Integer.valueOf(puzzleList.get(i).getAttempts()).equals(k + 1)) {
                        System.out.println("PUZZLE FAILED");
                        System.out.println("--------------------------------");
                    }



                }
            }
        }

    }

}