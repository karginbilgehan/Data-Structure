import java.util.LinkedList;

/**
 * keeps information about Course
 * @author Bilgehan
 */
public class Course {
    private int semester;
    private String courseCode;
    private String courseTitle;
    private int ECTSCredit;
    private int GTUCredit;
    private String HTL;


    public Course(){
        semester=0;
        courseCode="";
        courseTitle="";
        ECTSCredit=0;
        GTUCredit=0;
        HTL="";

    }

    /**
     *
     * @param newSmester
     * @param newCourseCode
     * @param newCourseTitle
     * @param newECTSCredit
     * @param newGTUCredit
     * @param newHTL
     */
    public Course(int newSmester,String newCourseCode,String newCourseTitle,int newECTSCredit,int newGTUCredit,String newHTL){
        semester=newSmester;
        courseCode=newCourseCode;
        courseTitle=newCourseTitle;
        ECTSCredit=newECTSCredit;
        GTUCredit=newGTUCredit;
        HTL=newHTL;

    }

    public int getSemester() {
        return semester;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public int getECTSCredit() {
        return ECTSCredit;
    }

    public int getGTUCredit() {
        return GTUCredit;
    }

    public String getHTL() {
        return HTL;
    }

    /**
     *
     * Compare the given code to the code in the list
     * @param Code
     * @param list
     * @return LinkedList type Course
     */
    public Course getByCode(String Code, LinkedList<Course> list){

        for(int i=0;i<list.size();++i){

            if(list.get(i).getCourseCode().equals(Code)){

                return list.get(i);
            }

        }
        return null;
    }

}
