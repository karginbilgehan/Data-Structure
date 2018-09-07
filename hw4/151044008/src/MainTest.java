/**
 * makes the overall scenario test for the given problem
 */
public class MainTest {
    public void test(){
        String temp="Ali";
        String temp1="Ahmet";
        String temp2="Mehmet";
        String temp3="Mahmut";
        String temp4="Ayse";
        String temp5="Burak";
        String temp6="Fatma";
        String temp7="Simay";
        String temp8="Vedat";
        String temp9="Abdullah";
        String temp10="Alican";
        String temp11="Deniz";
        GeneralTrees left=new GeneralTrees();
        GeneralTrees right= new GeneralTrees();
        GeneralTrees tree=new GeneralTrees();
        tree.add(temp,temp1);
        tree.add(temp,temp2);
        tree.add(temp,temp4);
        tree.add(temp1,temp5);
        tree.add(temp5,temp6);
        tree.add(temp6,temp7);
        tree.add(temp6,temp3);
        tree.add(temp8,temp9);
        tree.add(temp2,temp9);
        tree.add(temp2,temp10);
        tree.add(temp11,temp9);
        tree.add(temp4,temp11);
        tree.add(temp9,temp8);
        System.out.println("For General Tree: \n"+ tree.toString());

        System.out.println("----------------------------------------------");
        System.out.println();
        System.out.println("*********FOR MDS TREE*********");
        System.out.println();
        MdsTrees Trees= new MdsTrees();
        MdsTrees Tree=new MdsTrees();
        Integer[] arr={40,50,60};
        Integer[] arr1={30,40,50};
        Integer[] arr2={20,30,40};
        Integer[] arr3={45,55,65};
        Integer[] arr4={35,45,55};

        Tree.add(arr);
        Tree.add(arr1);
        Tree.add(arr2);
        Tree.add(arr3);
        Tree.add(arr4);
        System.out.println("----->Mds Tree for Integer: \n"+Tree.toString());
        System.out.println();

        String[] arrS={"bilgehan","onur","burak"};
        String[] arrS1={"talisca","fabri","babel"};
        String[] arrS2={"pepe","quaresma","tosic"};
        String[] arrS3={"tolgay","oguzhan","atiba"};
        String[] arrS4={"adriano","caner","gokhan"};

        Trees.add(arrS);
        Trees.add(arrS1);
        Trees.add(arrS2);
        Trees.add(arrS3);
        Trees.add(arrS4);


        System.out.println();
        System.out.println("----->Mds Tree for String:  \n"+Trees.toString());

        System.out.println();
        System.out.println("Search for arrS4 in the tree: ");
        String[] deneme=(String[]) Trees.find(arrS4);
        for(int i = 0; i < 3; ++i){
            System.out.println(deneme[i]);
        }
    }
}
