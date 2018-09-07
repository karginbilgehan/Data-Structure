import java.util.*;

/**
 * Bu sinif verilen listeyi Merge Sort algoritmasini kullanarak siralamayi saglar.
 */
public class MergeSort {
    /**
     * Siralanmis olan kucuk listeleri birlestirir.
     * @param output
     * @param left
     * @param right
     * @param <T>
     */
    public static<T extends Comparable<T>> void merge(LinkedList<T> output,  LinkedList<T> left, LinkedList<T> right){
        int i=0;
        int j=0;
        int k=0;
        while(i<left.size() && j<right.size()){
            if(left.get(i).compareTo(right.get(j))<0){
                output.set(k++,left.get(i++));

            }
            else{
                output.set(k++,right.get(j++));

            }

        }
        while(i<left.size()){
            output.set(k++,left.get(i++));
        }
        while(j<right.size()){
            output.set(k++,right.get(j++));
        }


    }

    /**
     * Verilen listeyi kucuk parcalara bolerek siralar
     * @param list
     * @param <T>
     */
    public static <T extends  Comparable<T>> void sort(LinkedList<T> list){
        if(list.size()>1){
            int halfSize=list.size()/2;
            LinkedList<T> leftTable=new LinkedList<T>();
            LinkedList<T> rightTable= new LinkedList<T>();

            for(int i=0;i<halfSize;++i){
                leftTable.add(list.get(i));

            }

            for(int i=halfSize;i<list.size();++i){
                rightTable.add(list.get(i));
            }

            Comparator<? super T> comparator =null ;
            leftTable.sort(comparator);
            rightTable.sort(comparator);
            merge(list,leftTable,rightTable);
        }
    }


}
