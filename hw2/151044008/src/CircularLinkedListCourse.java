/**
 * implements Circular Linked List
 * @author Bilgehan
 */
public class CircularLinkedListCourse {

    private Node head;
    private int size;

    public CircularLinkedListCourse(){
        head=null;
        size=0;

    }

    /**
     * helper method for get method
     * @param index
     * @return a node
     */
    private Node getNode(int index){
        Node temp=head;
        for(int i=0;i<index;++i){
            temp=temp.next;
        }
        return temp;
    }

    /**
     * finds the course to the given index
     * @param index
     * @return a Course
     */
    public Course get(int index){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        Node temp=getNode(index);
        return temp.data;

    }

    /**
     * finds the next course in the given index
     * @param index
     * @return a Course
     */
    public Course next(int index){

        return getNode(index).next.data;
    }

    /**
     * @return size
     */
    public int size(){
        return size;
    }


    /**
     * adds the desired index to the given course
     * @param index
     * @param item
     */
    public void add(int index,Course item){

        if(index<0 || index>size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }

        if(size == 0){
            head=new Node(item,head);
            size++;

        }

        else{
            Node temp = head;
            Node temp1=head;
            Node temp2=head;
            Node itemNode = new Node(item);

            for(int i = 0; i < size; ++i){
                if(temp1.data.getSemester()==item.getSemester() && temp1.nextIntSemester == null){
                    temp1.nextIntSemester=itemNode;
                    break;
                }
                temp1 = temp1.next;
            }


            for(int i = 1; i < index; ++i){
                temp = temp.next;
            }

            itemNode.next = temp.next;
            temp.next = itemNode;
            size++;
        }
        //sonuncu elemani basa baglamak icin
        Node temp = head;
        for(int i = 0; i < size-1; ++i){
            temp = temp.next;
        }
        temp.next = head;

    }

    /**
     * adds the given element to the end of the list
     * @param item
     */
    public void add(Course item){//sona eklemek icin
        add(size,item);
    }

    /**
     * deletes the element to the given index
     * @param index
     * @return a Course
     */
    public Course remove(int index){
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index==0){
            Node temp=head;
            head=head.next;
            size--;
            return temp.data;
        }
        else if(index>0 && index<size){
            Course value;
            Node temp=head;
            for(int i=0;i<index-1;++i){
                temp=temp.next;
            }
            value = temp.next.data;
            temp.next=temp.next.next;
            size--;
            return value;

        }
        else
            return null;
    }

    /**
     * finds the next course with the same semester on the given index
     * @param index
     * @return a Course
     */
    public Course nextInSemester(int index){

        if(getNode(index).nextIntSemester == null){
            Node temp = head;
            for(int i = 0; i < size; ++i){
                if(temp.data.getSemester() == getNode(index).data.getSemester()){
                    return temp.data;
                }
                temp = temp.next;
            }
        }

        return getNode(index).nextIntSemester.data;
    }

    /**
     * keep information about a node
     * @author Bilgehan
     */
    private static class Node{
        private Course data;
        private Node next;
        private Node nextIntSemester;
        private Node(){
            data=null;
            next=null;
            nextIntSemester=null;
        }

        /**
         * @param item
         */
        private Node(Course item){
            data=item;
            next=null;
            nextIntSemester=null;
        }

        /**
         * @param item
         * @param ref
         */
        private Node(Course item,Node ref){
            data=item;
            next=ref;
            nextIntSemester=null;
        }


    }
}
