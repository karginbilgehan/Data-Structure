import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Bilgehan
 */
public class fileReader {
    private String line="";
    private static final String Comma=";";

    /**
     * reads the information in CSV and add a list
     * @param fileName
     * @return a Linked List type of Course
     */
    public LinkedList<Course> cvsFileReader(String fileName){
        int i=1;
        LinkedList<Course> obj=new LinkedList<>();
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            while((line = fileReader.readLine()) != null){
                String[] data = line.split(Comma);
                Course temp=new Course(Integer.parseInt(data[0]),data[1],data[2],Integer.parseInt(data[3]),Integer.parseInt(data[4]),data[5]);
                obj.add(temp);
                i++;
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println("Error to Read!!!");
        }
        return obj;
    }
}
