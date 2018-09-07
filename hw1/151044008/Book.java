import java.io.*;
import java.util.*;
/**
 * Keeps the information of books
 * @author onur
 */

public class Book implements Library{
    private String name, writer;
    private int id;
    private boolean isAvailable;

    /**
     * Setter of availability of book
     * @param availability availability of book
     */
    public void setAvailability(boolean availability){
        isAvailable = availability;
    }

    /**
     * Getter of availability of book
     * @return availability of book
     */
    public boolean getAvailability(){
        return isAvailable;
    }

    /**
     * Getter of book id
     * @return book id
     */
    public int getId(){
        return id;
    }

    /**
     * Getter of book name
     * @return book name
     */
    public String getName(){
        return name;
    }

    /**
     * Getter of book writer
     * @return book writer
     */
    public String getWriter(){
        return writer;
    }

    /**
     * Writes the user to the csv file
     * @param fileWriter csv file
     */
    public void csvWriter(FileWriter fileWriter){
        try{
            String line = "" + id + "," + name + "," + writer;
            fileWriter.append(line.toString());
            fileWriter.append("\n");
        }catch(IOException e){
            System.out.println("Csv io error");
            e.printStackTrace();
        }
    }

    /**
     * Converts to string
     * @return information of book
     */
    @Override
    public String toString(){
        return "Id:" + id + ", Name:" + name + ", Writer:" + writer;
    }

    /**
     * Constructor
     * @param bId id of the book
     * @param bName name of the book
     * @param bWriter writer of the book
     */
    Book(int bId, String bName, String bWriter){
        name = bName;
        writer = bWriter;
        id = bId;
        isAvailable = true;
    }
}