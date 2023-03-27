import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Puzzle {

    //scanner for looking through puzzle file
    private Scanner infile;

    //variables used for puzzle class
    private String location;
    private String puzzleQuestion;
    private String puzzleAnswer;
    private String correctMessage;
    private String wrongMessage;
    private String attempts;
    private String solved;

    //constructor
    public Puzzle() {

    }

    //constructor
    public Puzzle(String location, String puzzleQuestion, String puzzleAnswer, String correctMessage,
                  String wrongMessage, String attempts, String solved) {
        this.location = location;
        this.puzzleQuestion = puzzleQuestion;
        this.puzzleAnswer = puzzleAnswer;
        this.correctMessage = correctMessage;
        this.wrongMessage = wrongMessage;
        this.attempts = attempts;
        this.solved = solved;
    }

    //looks through the puzzle file and stores item properties into an array list
    public void setPuzzle(ArrayList<Puzzle> puzzleList) {

        try{
            infile = new Scanner(new File("puzzle.txt"));
            Puzzle temp;
            String puzzleLine;
            String[] puzzleToken;

            while(infile.hasNext()) {
                puzzleLine = infile.nextLine();
                puzzleToken = puzzleLine.split("~");
                location = puzzleToken[0];
                puzzleQuestion = puzzleToken[1];
                puzzleAnswer = puzzleToken[2];
                correctMessage = puzzleToken[3];
                wrongMessage = puzzleToken[4];
                attempts = puzzleToken[5];
                solved = puzzleToken[6];
                temp = new Puzzle(location, puzzleQuestion, puzzleAnswer, correctMessage,
                        wrongMessage, attempts, solved);
                puzzleList.add(temp);
            }
            infile.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("File not Found");
        }
    }

    //retrieve puzzle location
    public String getLocation() {
        return location;
    }

    //retrieve puzzle question
    public String getPuzzleQuestion() {
        return puzzleQuestion;
    }

    //retrieve puzzle answer
    public String getPuzzleAnswer() {
        return puzzleAnswer;
    }

    //retrieve correct answer message
    public String getCorrectMessage() {
        return correctMessage;
    }

    //retrieve wrong answer message
    public String getWrongMessage() {
        return wrongMessage;
    }

    //retrieve answer attempts
    public String getAttempts() {
        return attempts;
    }

    //retrieve true/false value for puzzle solved
    public String getSolved() {
        return solved;
    }

    //set true/false value for puzzle solved
    public void setSolved(String solved) {
        this.solved = solved;
    }
}
