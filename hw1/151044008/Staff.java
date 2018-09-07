import java.io.*;
import java.util.*;
/**
 * Keeps the information of staff
 * @author onur
 */

public class Staff implements Library{
    private String password;
    private ArrayList<String> records = new ArrayList<String>();

    /**
     * Adds record to library
     * @param record record of library
     */
    public void addRecord(String record){
        records.add(record);
    }

    /**
     * Removes record from library
     * @param bId book id
     */
    public void removeRecord(int bId){
        for(int i = 0; i < records.size(); ++i){
            String[] line = records.get(i).split(",");
            if(Integer.parseInt(line[1]) == bId){
                records.remove(i);
                i = records.size();
            }
        }
    }

    /**
     * Getter of record size
     * @return size of records
     */
    public int recordSize(){
        return records.size();
    }

    /**
     * Getter of records
     * @param index index of record
     * @return record
     */
    public String getRecord(int index){
        return records.get(index);
    }

    /**
     * Adds user to library system
     * @param userlist list of registered users
     */
    public void addUser(ArrayList<User> userlist){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter ID of the user");
        int uId = scan.nextInt();
        int flag = 0;
        for(int i = 0; i < userlist.size(); ++i){
            if(userlist.get(i).getId() == uId){
                System.out.println("This ID already exist. Please enter another one!");
                uId = scan.nextInt();
                i = -1;
            }
        }
        System.out.println("Please enter name of the user");
        String uName = scan.next();
        System.out.println("Please enter password of the user");
        String uPassword = scan.next();

        User newUser = new User(uId, uName, uPassword);
        userlist.add(newUser);
    }

    /**
     * Adds books to library system
     * @param booklist list of registered books
     */
    public void addBook(ArrayList<Book> booklist){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter ID of the book");
        int bId = scan.nextInt();
        int flag = 0;
        for(int i = 0; i < booklist.size(); ++i){
            if(booklist.get(i).getId() == bId){
                System.out.println("This ID already exist. Please enter another one!");
                bId = scan.nextInt();
                i = -1;
            }
        }
        System.out.println("Please enter name of the book");
        String bName = scan.next();
        System.out.println("Please enter writer of the book");
        String bWriter = scan.next();

        Book newBook = new Book(bId, bName, bWriter);
        booklist.add(newBook);
    }

    /**
     * Removes user from library system
     * @param userlist list of registered users
     */
    public void removeUser(ArrayList<User> userlist){
        Scanner scan = new Scanner(System.in);
        if(userlist.size() > 0){
            int removableUsers = 0;
            System.out.println("The removable users are:");
            for(int i = 0; i < userlist.size(); ++i){
                if(userlist.get(i).isRemovable()){
                    System.out.println(userlist.get(i).toString());
                    ++removableUsers;
                }
            }
            if(removableUsers == 0){
                System.out.println("There is no removable user");
            }
            else{
                int flag = 0;
                System.out.println("Please enter id of the user");
                int uId = scan.nextInt();
                for(int i = 0; i < userlist.size(); ++i){
                    if(userlist.get(i).getId() == uId && userlist.get(i).isRemovable()){
                        userlist.remove(i);
                        flag = 1;
                        i = userlist.size();
                    }
                }
                if(flag == 0){
                    System.out.println("Wrong ID");
                }
                else{
                    System.out.println("User has been removed");
                }
            }
        }
        else{
            System.out.println("There is no user to remove");
        }
    }

    /**
     * Removes book from library system
     * @param booklist list of the registered books
     */
    public void removeBook(ArrayList<Book> booklist){
        Scanner scan = new Scanner(System.in);
        if(booklist.size() > 0){
            int removableBooks = 0;
            System.out.println("The removable books are:");
            for(int i = 0; i < booklist.size(); ++i){
                if(booklist.get(i).getAvailability()){
                    System.out.println(booklist.get(i).toString());
                    ++removableBooks;
                }
            }
            if(removableBooks== 0){
                System.out.println("There is no removable book");
            }
            else{
                int flag = 0;
                System.out.println("Please enter id of the book");
                int bId = scan.nextInt();
                for(int i = 0; i < booklist.size(); ++i){
                    if(booklist.get(i).getId() == bId && booklist.get(i).getAvailability()){
                        booklist.remove(i);
                        flag = 1;
                        i = booklist.size();
                    }
                }
                if(flag == 0){
                    System.out.println("Wrong ID");
                }
                else{
                    System.out.println("Book has been removed");
                }
            }
        }
        else{
            System.out.println("There is no book to remove");
        }
    }

    /**
     * Getter of staff password
     * @return staff password
     */
    public String getPassword(){
        return password;
    }

    /**
     * Writes the user to the csv file
     * @param fileWriter csv file
     */
    public void csvWriter(FileWriter fileWriter){
        try{
            for(int i = 0; i < records.size(); ++i){
                fileWriter.append(records.get(i).toString());
                fileWriter.append("\n");
            }
        }catch(IOException e){
            System.out.println("Csv io error");
            e.printStackTrace();
        }
    }

    /**
     * Converts to string
     * @return information of staff
     */
    @Override
    public String toString(){
        return "Password:" + password;
    }

    /**
     * Constructor
     */
    Staff(){
        password = "123";
    }
}
