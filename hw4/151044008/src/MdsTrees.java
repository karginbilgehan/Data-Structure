import java.io.Serializable;
/**
 * represent a tree that every element is multi-dimensional
 * @param <E>
 */
public class MdsTrees<E extends Comparable<E> > extends BinaryTree  implements SearchTree {
    protected Node root;
    public boolean addReturn;
    public boolean deleteReturn;
    public MdsTrees(){
        root=null;
    }
    protected MdsTrees(Node root){
        this.root=root;
    }
    public MdsTrees(E[] data, MdsTrees leftTree, MdsTrees rightTree){
        root=new Node(data);
        if(leftTree!=null){
            root.left=leftTree.root;
        }
        else{
            root.left=null;
        }
        if(rightTree!=null){
            root.right=rightTree.root;
        }
        else{
            root.right=null;
        }
    }

    /**
     *  * inserts the element to be added with the necessary comparisons
     * @param item
     * @return
     */
    @Override
    public boolean add(Object[] item) {
        root=add(root, (E[]) item,0);
        return addReturn;
    }

    /**
     * helper method for add
     * @param localRoot
     * @param item
     * @param mode
     * @return
     */
    private Node<E> add(Node<E> localRoot, E[] item,int mode){
        Node node=new Node(item);

        if(localRoot==null){

            localRoot=node;
            addReturn=true;
            return localRoot;
        }

        else if((localRoot.data[mode].compareTo(item[mode])>0)){
            if(localRoot.left==null){
                localRoot.left=node;
                addReturn=true;
                return localRoot;
            }
            else
                add(localRoot.left,item,(mode+1)%3);
                return localRoot;
        }
        else if((localRoot.data[mode].compareTo(item[mode])<0)){
            if(localRoot.right==null){
                localRoot.right=node;
                addReturn=true;
                return localRoot;
            }
            else
                add(localRoot.right,item,(mode+1)%3);
                return localRoot;
        }
        else if((localRoot.data[mode].compareTo(item[mode])==0)){
            System.out.println("The element you want to add already exists");
            addReturn=false;
            return null;

        }
        addReturn=false;
        return null;
    }

    @Override
    public boolean contains(Object[] target) {
        if(find(target)==null)
            return false;
        else
            return true;
    }

    @Override
    public Object[] find(Object[] target) {

        return postOrderTraverse(root, target, 1).data;
    }

    @Override
    public Object delete(Object target) {
        return deleteReturn;
    }

    @Override
    public boolean remove(Object target) {
        if(delete(target)==null){
            return false;
        }
        else
            return true;
    }

    /**
     * Traverse required to search for elements in the tree
     * @param head
     * @param node
     * @param depth
     * @return
     */
    private Node<E> postOrderTraverse(Node<E> head,Object[] node, int depth){
        Node<E> temp=null;

        if(head==null){
            return null;
        }
        else{

            temp=postOrderTraverse(head.left,node,depth+1);

            if(temp!=null && temp.data[0].compareTo((E)node[0])==0 && temp.data[1].compareTo((E)node[1])==0 && temp.data[2].compareTo((E)node[2])==0){
                return temp;
            }
            temp=postOrderTraverse(head.right,node,depth+1);
            if(temp!=null &&  temp.data[0].compareTo((E)node[0])==0 && temp.data[1].compareTo((E)node[1])==0 && temp.data[2].compareTo((E)node[2])==0){
                return temp;
            }
            if(head.data==node){

                return head;
            }

        }
        return null;
    }

    /**
     * A traverse To print the elements of the tree
     * @param node
     * @param depth
     * @param sb
     */
    private void preOrderTraverse(Node node, int depth, StringBuilder sb){
        for(int i=1; i<depth;++i){
            sb.append("***");
        }
        if(node==null){
            sb.append("null \n");
        }
        else{
            sb.append(node.toString());
            sb.append("\n");
            preOrderTraverse(node.left,depth+1,sb);
            preOrderTraverse(node.right,depth+1,sb);
        }


    }
    public String toString(){
        StringBuilder sb= new StringBuilder();
        preOrderTraverse(root,1,sb);
        return sb.toString();
    }

    protected static class Node<E extends Comparable<E>> implements Serializable {
        protected E[]data;
        protected MdsTrees.Node left;
        protected MdsTrees.Node right;


        public Node(E[] data){
            this.data=data;
            left=null;
            right=null;
        }
        public String toString(){
            return String.format("(%s,%s,%s) ",data[0],data[1],data[2]);
        }
    }
}
