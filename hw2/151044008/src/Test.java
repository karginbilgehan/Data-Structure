import java.util.LinkedList;

/**
 * to test the program
 * @author Bilgehan
 */
public class Test {
    /**
     * for the flow of the program
     */
    public void test(){
        fileReader reader = new fileReader();
        LinkedList<Course> obj = new LinkedList<>();
        LinkedList<Course> forSemester = new LinkedList<>();
        LinkedList<Course> forGetByRange = new LinkedList<>();
        linkedListCourse<Course> forLinkedListCourse = new linkedListCourse<>();
        Course ders = new Course();
        CircularLinkedListCourse forDoubleLinkedListCourse = new CircularLinkedListCourse();
        obj = reader.cvsFileReader("Courses.csv");
        for (int i = 0; i < obj.size(); ++i) {
            ders = obj.get(i).getByCode("CSE 222", obj);

        }
        System.out.println();
        System.out.println("----------Course Code'u CSE 222 Olan Ders------------");
        System.out.printf("dersin adi: %s \n", ders.getCourseTitle());
        System.out.println("---------------------------------------------------------------");
        System.out.println();

        forSemester = listSemesterCourse(4, obj);
        System.out.println("**************4.Semeterdaki Dersler*****************************");
        for (int i = 0; i < forSemester.size(); ++i) {
            System.out.printf("dersin adi: %s \n", forSemester.get(i).getCourseTitle());
        }
        System.out.println("****************************************************************");
        System.out.println();

        forGetByRange = getByRange(7, 18, obj);
        System.out.println("--------------7. ve 18.Indexler Arasindaki Dersler--------------");
        for (int i = 0; i < forGetByRange.size(); ++i) {
            System.out.printf("dersin adi: %s \n", forGetByRange.get(i).getCourseTitle());
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println();
        for (Course course : forSemester)
            forLinkedListCourse.add(course);

        System.out.println("**************Part2 yi Kullanmak İcin 4.Semesterdaki Dersleri Dikkate Alalim********************");
        for (int i = 0; i < forLinkedListCourse.size(); ++i) {
            System.out.printf("Ders adi: %s \n", forLinkedListCourse.get(i).getCourseTitle());

        }
        System.out.println("*************************************************************************************************");
        System.out.println();
        forLinkedListCourse.disable(2);
        forLinkedListCourse.disable(4);
        forLinkedListCourse.showDisable();
        System.out.println();

        for (Course course : forGetByRange)
            forDoubleLinkedListCourse.add(course);
        System.out.println("----------------Part 3'u Kontrol Etmek Icin Verilen Indexler Arasindaki Dersleri Ele Alalim----------------- ");
        for (int i = 0; i < forDoubleLinkedListCourse.size(); ++i) {
            System.out.printf("Ders Adi: %s \n", forDoubleLinkedListCourse.get(i).getCourseTitle());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("***********************Bu Listenin Size'i*****************************************");
        System.out.printf("size: %d \n", forDoubleLinkedListCourse.size());
        System.out.println("**********************************************************************************");
        System.out.println();
        System.out.println("-----------------5.Indexteki Elemanin Next'i-------------------");
        System.out.printf("Ders Adi: %s \n", forDoubleLinkedListCourse.next(5).getCourseTitle());
        System.out.println("---------------------------------------------------------------");
        System.out.println();
        System.out.println("****************Son Indexteki Elemanin Next'i*******************************");
        System.out.printf("Ders Adi: %s \n", forDoubleLinkedListCourse.next(11).getCourseTitle());
        System.out.println("****************************************************************************");
        System.out.println();
        Course newCourse = new Course(4, "MATH 217", "Linearr Algebra and Differantial Equations", 8, 5, "4+2+0");
        System.out.println("--------------------------------MATH 217 Dersini Bu Listede Araya Ekleyelim------------------------");
        forDoubleLinkedListCourse.add(5, newCourse);
        for (int i = 0; i < forDoubleLinkedListCourse.size(); ++i) {
            System.out.printf("Semester: %d Ders Adi: %s \n", forDoubleLinkedListCourse.get(i).getSemester(), forDoubleLinkedListCourse.get(i).getCourseTitle());
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("*************6.Indexteki Physic 2 Dersinin NextInSemesterina Bakalim*******************************");
        System.out.printf("Ders Adi: %s \n", forDoubleLinkedListCourse.nextInSemester(6).getCourseTitle());
        System.out.println("***************************************************************************************************");

        System.out.println("---------------Son Indexteki Dersin NextInSemesterina Bakalim------------------------------");
        System.out.printf("Ders Adi: %s \n", forDoubleLinkedListCourse.nextInSemester(12).getCourseTitle());
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println();

        System.out.println("***************2.Indexteki Elamani Listeden Silelim*****************************");
        forDoubleLinkedListCourse.remove(2);
        for (int i = 0; i < forDoubleLinkedListCourse.size(); ++i) {
            System.out.printf("Ders Adi: %s \n", forDoubleLinkedListCourse.get(i).getCourseTitle());

        }
        System.out.println("********************************************************************************");
        System.out.println();
    }

    /**
     * add the lessons in the given semester into the list
     * @param semester
     * @param list
     * @return
     */
    public static LinkedList<Course> listSemesterCourse(int semester, LinkedList<Course> list) {
        int j = 0;
        LinkedList<Course> temp = new LinkedList<>();
        for (int i = 0; i < list.size(); ++i) {

            if (list.get(i).getSemester() == (semester)) {
                temp.add(j, list.get(i));
                j++;
            }

        }
        return temp;
    }

    /**
     *
     * @param start_index
     * @param last_index
     * @param list
     * @return
     */
    public static LinkedList<Course> getByRange(int start_index, int last_index, LinkedList<Course> list) {
        int j = 0;
        LinkedList<Course> temp = new LinkedList<>();

        for (int i = start_index; i <= last_index; ++i) {
            temp.add(j, list.get(i));
            j++;

        }
        return temp;

    }



}
