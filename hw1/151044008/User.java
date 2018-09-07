import java.io.*;
import java.util.*;

/**
 * Keeps the information of user
 * @author onur
 */

public class User implements Library{
    private String name, password;
    private int id;
    private ArrayList<Book> borrowedBooks = new ArrayList<Book>();

    /**
     * Adds borrowedBooks list a book
     * @param book book
     */
    public void addBorrowedBook(Book book){
        borrowedBooks.add(book);
    }
    /**
     * Lets user borrow books.
     * @param booklist List of the registered books
     * @param staff Staff of the library
     */
    public void borrowBook(ArrayList<Book> booklist, Staff staff){
        Scanner scan = new Scanner(System.in);
        int availableBooks = 0;
        System.out.println("The available books are:");
        for(int i = 0; i < booklist.size(); ++i){
            if(booklist.get(i).getAvailability() == true){
                System.out.println(booklist.get(i).toString());
                ++availableBooks;
            }
        }
        if(availableBooks > 0){
            System.out.println("Please enter id of the book: ");
            int bId = scan.nextInt();
            int flag = 0;
            for(int i = 0; i < booklist.size(); ++i){
                if(booklist.get(i).getAvailability() == true){
                    if(booklist.get(i).getId() == bId){
                        borrowedBooks.add(booklist.get(i));
                        booklist.get(i).setAvailability(false);
                        String record = "" + id + "," + booklist.get(i).getId();
                        staff.addRecord(record);
                        i = booklist.size();
                        flag = 1;
                    }
                }
            }
            if(flag == 0){
                System.out.println("Wrong id");
            }
            else if(flag == 1){
                System.out.println("The book has borrowed");
            }
        }
        else{
            System.out.println("All books are unavailable");
        }
    }

    /**
     * Lets user return borrowed books
     * @param booklist List of the registered books
     * @param staff Staff of the library
     */
    public void returnBook(ArrayList<Book> booklist, Staff staff){
        Scanner scan = new Scanner(System.in);
        if(borrowedBooks.size() > 0){
            System.out.println("The books you have:");
            for(int i = 0; i < borrowedBooks.size(); ++i){
                System.out.println(borrowedBooks.get(i).toString());
            }
            System.out.println("Please enter id of the book: ");
            int bId = scan.nextInt();
            int flag = 0;
            for(int i = 0; i < borrowedBooks.size(); ++i){
                if(borrowedBooks.get(i).getId() == bId){
                    borrowedBooks.remove(i);
                    for(int j = 0; j < booklist.size(); ++j){
                        if(booklist.get(j).getId() == bId){
                            booklist.get(j).setAvailability(true);
                            staff.removeRecord(bId);
                            j = booklist.size();
                        }
                    }
                    flag = 1;
                    i = borrowedBooks.size();
                }
            }
            if(flag == 0){
                System.out.println("Wrong ID");
            }
            else if(flag == 1){
                System.out.println("The book has returned");
            }
        }
        else{
            System.out.println("You havent any book");
        }
    }

    /**
     * Checks if user removable or not.
     * @return If user has no borrowed book returns true. Else returns false.
     */
    public boolean isRemovable(){
        return (borrowedBooks.size() == 0);
    }

    /**
     * Getter of user id
     * @return user id
     */
    public int getId(){
        return id;
    }

    /**
     * Getter of user name
     * @return user name
     */
    public String getName(){
        return name;
    }

    /**
     * Getter of user password
     * @return user password
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
            String line = "" + id + "," + name + "," + password;
            fileWriter.append(line.toString());
            fileWriter.append("\n");
        }catch(IOException e){
            System.out.println("Csv io error");
            e.printStackTrace();
        }
    }

    /**
     * Converts to string
     * @return information of user
     */
    @Override
    public String toString(){
        return "Id:" + id + ", Name:" + name + ", Password:" + password;
    }

    /**
     * Constructor
     * @param uId Id of user
     * @param uName Name of user
     * @param uPassword Password of user
     */
    User(int uId, String uName, String uPassword){
        name = uName;
        password = uPassword;
        id = uId;
    }
}