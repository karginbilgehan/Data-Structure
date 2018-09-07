import java.util.LinkedList;

public class linkedListCourse<T>  extends LinkedList<T> {
    private LinkedList<Course> forDisable=new LinkedList<>();
    private int indexForDisable;

    /**
     * remove course the given index
     * @param index
     */
    public void disable(int index){

        if(index<=this.size()){
            forDisable.add((Course) this.get(index));
            indexForDisable=index;
            this.remove(index);

        }

    }

    /**
     * print out disabled courses
     */
    public void showDisable(){
        System.out.println("----------------Disable olan dersler---------------");
        for(int i=0;i<forDisable.size();++i){

            System.out.printf("%s \n",forDisable.get(i).getCourseTitle());

        }
        System.out.println("---------------------------------------------------");
    }


}
