import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Random;
public class main {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree= new AVLTree<Integer>();
        avlTree.add(15);
        avlTree.add(10);
        avlTree.add(20);
        avlTree.add(35);
        avlTree.add(5);
        avlTree.add(0);
        avlTree.add(25);
        avlTree.add(30);
        avlTree.add(2);
        avlTree.add(27);
        avlTree.add(24);
        avlTree.delete(30);
        avlTree.delete(20);
        avlTree.delete(24);
        avlTree.delete(25);
        System.out.println("*******Bu kısım AVL Tree'nin Delete Metodunu Göstermek İçin**********");
        System.out.println(avlTree.toString());
        System.out.println("*********************************************************************");
        System.out.println();
        System.out.println("**************Bu kısım AVL Tree Constructor'ını Göstermek için");
        BinarySearchTree<Integer> test=new BinarySearchTree<>();
        BinarySearchTree<Integer> test1=new BinarySearchTree<>();
        test.add(10);
        test.add(5);
        test.add(15);
        test.add(7);
        test.add(6);
        test.add(3);
        test.add(2);
        test.add(12);
        test.add(17);
        System.out.println("*********Birinci Test Case************");
        System.out.println(test.toString());
        AVLTree<Integer> avl= new AVLTree<Integer>((BinaryTree<Integer>) test);
        System.out.println();
        System.out.println("*********İkinci Test Case************");

        test1.add(20);
        test1.add(10);
        test1.add(15);
        test1.add(5);
        test1.add(30);
        test1.add(25);
        test1.add(40);
        test1.add(60);
        test1.add(70);
        test1.add(80);
        test1.add(35);
        System.out.println(test1.toString());
        AVLTree<Integer> avl1= new AVLTree<Integer>((BinaryTree<Integer>) test1);
        System.out.println("************************************************");
        System.out.println();

        System.out.println("**************Bu kısım Red Black Tree Build Etmek İçin*****************");
        RedBlackTree<Integer> temp=new RedBlackTree<Integer>();
        Integer data[]=new Integer[14];
        Random r=new Random();
        int entry;
        for(int i=0;i<data.length;++i){
            entry=r.nextInt(1000);
            data[i]=entry;
        }
        System.out.println("Eklenecek Elemanlar: ");
        for(int i=0;i<data.length;++i){

        }
        System.out.println();
        System.out.println();
        temp.buildTree(data);
        System.out.println("************************************************************************");
        System.out.println();

        System.out.println("***************Bu kısım BTree BinarySearch Metodu İçin******************");
        BTree<Integer> bt = new BTree<>(4);
        bt.add(5);
        bt.add(3);
        bt.add(2);
        bt.add(4);
        bt.add(1);
        bt.add(6);
        bt.add(7);
        bt.add(8);
        bt.add(0);
        bt.add(9);

        System.out.println(bt.toString());
        System.out.println("-------------------------------");
        System.out.println();
        BTree<Integer> bt1 = new BTree<>(5);
        bt1.add(10);
        bt1.add(15);
        bt1.add(5);
        bt1.add(0);
        bt1.add(20);
        bt1.add(25);
        bt1.add(1);
        bt1.add(30);
        bt1.add(2);

        System.out.println(bt1.toString());

        System.out.println("************************************************************************");
    }
}
