public class main {
    public static void main(String[] args) {

        System.out.println("***************PART1****************");
        mainTestForDHM map=new mainTestForDHM();
        map.TestMap();
        System.out.println();

        System.out.println("***************PART2****************");
        mainTestForRSH set=new mainTestForRSH();
        set.rshTest();


        System.out.println("****************PART3***************");

        mainTestForMergeSort merge=new mainTestForMergeSort();
        merge.mergeTest();

        System.out.println();
        System.out.println("****************PART4 AND PART5***************");

        mainTestForSorts sorts= new mainTestForSorts();
        sorts.testSorts();


    }
}
