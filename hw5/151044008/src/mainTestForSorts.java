import java.util.LinkedList;
import java.util.Random;

public class mainTestForSorts {
    public void testSorts(){
        //for part4
        int[] array1=new int[]{1};
        int[] array50=new int[50];
        int[] array100=new int[100];
        int[] array150=new int[150];
        int[] array200=new int[200];
        int[] array250=new int[250];
        int[] array300=new int[300];
        int[] array350=new int[350];
        int[] array400=new int[400];
        int[] array450=new int[450];
        MergeSort temp1=new MergeSort();
        Sorts temp=new Sorts();
        for(int i=0;i<array50.length;++i){
            Random r=new Random(); //random sınıfı
            int a=r.nextInt(1000);
            array50[i]=a;
        }
        for(int i=0;i<array100.length;++i){
            Random r=new Random(); //random sınıfı
            int a=r.nextInt(1000);
            array100[i]=a;
        }
        for(int i=0;i<array150.length;++i){
            Random r=new Random(); //random sınıfı
            int a=r.nextInt(1000);
            array150[i]=a;
        }
        for(int i=0;i<array200.length;++i){
            Random r=new Random(); //random sınıfı
            int a=r.nextInt(1000);
            array200[i]=a;
        }
        for(int i=0;i<array250.length;++i){
            Random r=new Random(); //random sınıfı
            int a=r.nextInt(1000);
            array250[i]=a;
        }
        for(int i=0;i<array300.length;++i){
            Random r=new Random(); //random sınıfı
            int a=r.nextInt(10000);
            array300[i]=a;
        }
        for(int i=0;i<array350.length;++i){
            Random r=new Random(); //random sınıfı
            int a=r.nextInt(10000);
            array350[i]=a;
        }
        for(int i=0;i<array400.length;++i){
            Random r=new Random(); //random sınıfı
            int a=r.nextInt(10000);
            array400[i]=a;
        }
        for(int i=0;i<array450.length;++i){
            Random r=new Random(); //random sınıfı
            int a=r.nextInt(10000);
            array450[i]=a;
        }

        LinkedList<Integer> arr=new LinkedList<Integer>();
        for(int i=0;i<450;++i){
            Random r=new Random(); //random sınıfı
            int a=r.nextInt(1000);
            arr.add(i,a);
        }
        System.out.println("450 boyutundaki Array icin Quick Sort'u calistiralim:");
        long startTime1=System.nanoTime();
        temp.quickSort(array450,0,array450.length-1);
        //temp.InsertionSort(array450);
        //temp.heapSort(array450);
        //temp.mergeSort(array400,0,array400.length-1);
        //temp1.sort(arr);
        long endTime1=System.nanoTime();
        long time1=endTime1-startTime1;
        System.out.print("time in nanoseconds for Quick Sort = ");
        System.out.println(time1);
        System.out.println();

        System.out.println("300 boyutundaki Array icin Heap Sort'u calistiralim:");
        long startTime2=System.nanoTime();
        temp.heapSort(array300);
        long endTime2=System.nanoTime();
        long time2=endTime2-startTime2;
        System.out.print("time in nanoseconds for Heap Sort= ");
        System.out.println(time2);
        System.out.println();



        //for part5 worst case
        int[] arr100=new int[100];
        int[] arr1000=new int[1000];
        int[] arr5000=new int[5000];
        int[] arr10000=new int[10000];

        int sayi1=101;
        int sayi2=1001;
        int sayi3=5001;
        int sayi4=10001;
        for(int i=0;i<arr100.length;++i){
            arr100[i]=sayi1;
            sayi1--;
        }
        for(int i=0;i<arr1000.length;++i){
            arr1000[i]=sayi2;
            sayi2--;
        }
        for(int i=0;i<arr5000.length;++i){
            arr5000[i]=sayi3;
            sayi3--;
        }
        for(int i=0;i<arr10000.length;++i){
            arr10000[i]=sayi4;
            sayi4--;
        }
        LinkedList<Integer> temparr1=new LinkedList<Integer>();
        LinkedList<Integer> temparr2=new LinkedList<Integer>();
        LinkedList<Integer> temparr3=new LinkedList<Integer>();
        LinkedList<Integer> temparr4=new LinkedList<Integer>();
        int count1=101;
        int count2=1001;
        int count3=5001;
        int count4=10001;
        for(int i=0;i<100;++i){
            temparr1.add(i,count1);
            count1--;
        }
        for(int i=0;i<1000;++i){
            temparr2.add(i,count2);
            count2--;
        }
        for(int i=0;i<5000;++i){
            temparr3.add(i,count3);
            count3--;
        }
        for(int i=0;i<10000;++i){
            temparr4.add(i,count4);
            count4--;
        }
        System.out.println("10000 boyutundaki array icin Insertion Sort'u calistirip Worst Case'e bakalim:");
        long startTime=System.nanoTime();
        //temp.heapSort(arr5000);
        temp.InsertionSort(arr10000);
        //temp.mergeSort(arr5000,0, arr5000.length-1);
        //temp.quickSort(arr10000,0, arr10000.length-1);
        //temp1.sort(temparr4);
        long endTime=System.nanoTime();
        long time=endTime-startTime;
        System.out.print("time in nanoseconds for worst case for Insertion Sort = ");
        System.out.println(time);
        System.out.println();

        System.out.println("5000 boyutundaki array icin Merge Sort'u calistirip Worst Case'e bakalim:");
        long startTime3=System.nanoTime();
        temp.mergeSort(arr5000,0, arr5000.length-1);
        long endTime3=System.nanoTime();
        long time3=endTime3-startTime3;
        System.out.print("time in nanoseconds for worst case for Merge Sort = ");
        System.out.println(time3);




    }
}
