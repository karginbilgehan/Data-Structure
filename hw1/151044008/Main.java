import java.io.*;
import java.util.*;

/**
 * Test class
 * @author onur
 */
public class Main {
    /**
     * Main
     * @param args command line parameter
     */
    public static void main(String[] args){


        Scanner scan = new Scanner(System.in);
        Staff staff = new Staff();
        ArrayList<Book> booklist = new ArrayList<Book>();
        ArrayList<User> userlist = new ArrayList<User>();
        FileWriter fileWriter = null;
        BufferedReader fileReader = null;

        try{
            fileWriter = new FileWriter("Users.csv", true);
            fileWriter.close();
            fileWriter = new FileWriter("Books.csv", true);
            fileWriter.close();
            fileWriter = new FileWriter("Records.csv", true);
            fileWriter.close();
        }catch(Exception e){
            System.out.println("CSV file error");
            e.printStackTrace();
        }

        try{
            String line = "";
            fileReader = new BufferedReader(new FileReader("Users.csv"));
            fileReader.readLine();
            while((line = fileReader.readLine()) != null){
                String[] temp = line.split(",");
                User user = new User(Integer.parseInt(temp[0]), temp[1], temp[2]);
                userlist.add(user);
            }
            fileReader.close();

            fileReader = new BufferedReader(new FileReader("Books.csv"));
            fileReader.readLine();
            while((line = fileReader.readLine()) != null){
                String[] temp = line.split(",");
                Book book = new Book(Integer.parseInt(temp[0]), temp[1], temp[2]);
                booklist.add(book);
            }
            fileReader.close();

            fileReader = new BufferedReader(new FileReader("Records.csv"));
            fileReader.readLine();
            while((line = fileReader.readLine()) != null){
                staff.addRecord(line);
            }
            fileReader.close();
        }catch(Exception e) {
            System.out.println("Csv file Error");
            e.printStackTrace();
        }

        for(int i = 0; i < staff.recordSize(); ++i){
            String[] line = staff.getRecord(i).split(",");
            for(int j = 0; j < booklist.size(); ++j){
                if(booklist.get(j).getId() == Integer.parseInt(line[1])){
                    booklist.get(j).setAvailability(false);
                    for(int k = 0; k < userlist.size(); ++k){
                        if(userlist.get(k).getId() == Integer.parseInt(line[0])){
                            userlist.get(k).addBorrowedBook(booklist.get(j));
                            k = userlist.size();
                        }
                    }
                    j = booklist.size();
                }
            }
        }

        int menu = 0;
        while(menu != 3){
            System.out.println("For staff menu enter 1, for user menu enter 2, to exit enter 3");
            menu = scan.nextInt();
            if(menu == 1){
                System.out.println("Please enter the staff password");
                String password = scan.next();
                if(password.compareTo(staff.getPassword()) == 0){
                    int staffMenu = 0;
                    while(staffMenu != 5){
                        System.out.println("Enter 1 for add user, 2 for remove user, 3 for add book, 4 for remove book, 5 for back to menu");
                        staffMenu = scan.nextInt();
                        if(staffMenu == 1){
                            staff.addUser(userlist);
                        }
                        else if(staffMenu == 2){
                            staff.removeUser(userlist);
                        }
                        else if(staffMenu == 3){
                            staff.addBook(booklist);
                        }
                        else if(staffMenu == 4){
                            staff.removeBook(booklist);
                        }
                        else if(staffMenu == 5){

                        }
                        else{
                            System.out.println("Wrong option. Try again");
                        }
                    }
                }
                else{
                    System.out.println("Wrong password");
                }
            }
            else if(menu == 2){
                if(userlist.size() == 0){
                    System.out.println("There is no user");
                }
                else{
                    System.out.println("Please enter your user id");
                    int uId = scan.nextInt();
                    int flag = -1;
                    for(int i = 0;i < userlist.size(); ++i){
                        if(userlist.get(i).getId() == uId){
                            flag = i;
                            i = userlist.size();
                        }
                    }
                    if(flag == -1){
                        System.out.println("Wrong id");
                    }
                    else{
                        System.out.println("Please enter the password");
                        String password = scan.next();
                        if(password.compareTo(userlist.get(flag).getPassword()) == 0){
                            int userMenu = 0;
                            while(userMenu != 3){
                                System.out.println("Enter 1 for borrow book, 2 for return book or 3 for return menu");
                                userMenu = scan.nextInt();
                                if(userMenu == 1){
                                    userlist.get(flag).borrowBook(booklist, staff);
                                }
                                else if(userMenu == 2){
                                    userlist.get(flag).returnBook(booklist, staff);
                                }
                                else if(userMenu == 3){

                                }
                                else{
                                    System.out.println("Wrong option. Try again");
                                }
                            }
                        }
                        else{
                            System.out.println("Wrong password");
                        }
                    }
                }
            }
            else if(menu == 3){

            }
            else{
                System.out.println("Wrong option. Try again");
            }
        }

        try{
            fileWriter = new FileWriter("Users.csv");
            fileWriter.append("ID,Name,Password\n");
            for(int i = 0; i < userlist.size(); ++i){
                userlist.get(i).csvWriter(fileWriter);
            }
        }catch(Exception e){
            System.out.println("CSV file error");
            e.printStackTrace();
        }finally{
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch(IOException e){
                System.out.println("CSV flushing/closing error");
                e.printStackTrace();
            }
        }

        try{
            fileWriter = new FileWriter("Books.csv");
            fileWriter.append("ID,Name,Writer\n");
            for(int i = 0; i < booklist.size(); ++i){
                booklist.get(i).csvWriter(fileWriter);
            }
        }catch(Exception e){
            System.out.println("CSV file error");
            e.printStackTrace();
        }finally{
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch(IOException e){
                System.out.println("CSV flushing/closing error");
                e.printStackTrace();
            }
        }

        try{
            fileWriter = new FileWriter("Records.csv");
            fileWriter.append("UserID,BookID\n");
            staff.csvWriter(fileWriter);
        }catch(Exception e){
            System.out.println("CSV file error");
            e.printStackTrace();
        }finally{
            try{
                fileWriter.flush();
                fileWriter.close();
            }catch(IOException e){
                System.out.println("CSV flushing/closing error");
                e.printStackTrace();
            }
        }
    }
}
