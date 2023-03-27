import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Room {

    //Scanner for reading file
    private Scanner infile;

    //variable used for room class
    private String id;
    private String visited;
    private String roomName;
    private String description;
    private String connections;

    //constructor
    public Room() {

    }

    //constructor
    public Room(String id, String visited, String roomName, String description, String connections) {
        this.id = id;
        this.visited = visited;
        this.roomName = roomName;
        this.description = description;
        this.connections = connections;
    }

    //looks through map file and stores room properties into an array list
    public void setRoom(ArrayList<Room> roomList) {

        try{
            infile = new Scanner(new File("map.txt"));
            String roomLine;
            String[] roomToken;
            Room temp;

            while(infile.hasNext()) {
                roomLine = infile.nextLine();
                roomToken = roomLine.split("~");
                id = roomToken[0];
                visited = roomToken[1];
                roomName = roomToken[2];
                description = roomToken[3];
                connections = roomToken[4];
                temp = new Room(id, visited, roomName, description, connections);
                roomList.add(temp);
            }

            infile.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

    //retrieve room id
    public String getRoomID() {
        return id;

    }

    //retrieve true/false value for room visited
    public String getVisited() {
        return visited;
    }

    //retrieve room name
    public String getRoomName() {
        return roomName;
    }

    //retrieve room description
    public String getDescription() {
        return description;
    }

    //retrieve room connections
    public String getConnections() {
        return connections;
    }

    //set true/false value for room visited
    public void setVisited(String visited) {
        this.visited = visited;
    }

}
