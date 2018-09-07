import java.util.LinkedList;

public class mainTestForMergeSort {
    public  void mergeTest(){
        LinkedList<Integer> arr=new LinkedList<Integer>();
        arr.add(20);
        arr.add(30);
        arr.add(15);
        arr.add(10);
        arr.add(50);
        arr.add(45);
        arr.add(25);
        arr.add(0);
        arr.add(40);
        arr.add(35);
        System.out.println("Arrayin ilk hali: 20-30-15-10-50-45-25-0-40-35");
        System.out.println();
        MergeSort temp=new MergeSort();
        temp.sort(arr);
        System.out.println("Array'in siralanmis hali: ");
        for(int i=0;i<arr.size();++i){
            System.out.println(arr.get(i));
        }
    }

}
