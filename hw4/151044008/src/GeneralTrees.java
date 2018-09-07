/**
 * this class extends BinaryTree class
 * the general tree structure is implemented on the binary tree structure
 * adds elements by finding the right place in the general tree structure
 * @param <E>
 */
public class GeneralTrees<E> extends BinaryTree{
        public GeneralTrees(){
            super();
        }
        protected GeneralTrees(Node<E> root) {
            super(root);
        }
        public GeneralTrees(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
            super(data,leftTree,rightTree);
        }

    /**
     * adds the child element to the given parent element
     * @param parentItem
     * @param childItem
     * @return false if add operaiton is unseccesfull, other return true
     */
        public boolean add(E parentItem,E childItem){
            Node node=new Node(childItem);
            Node nodetemp=null;

            if(root==null){
                root=new Node(parentItem);
            }

            if(root.left==null){
                root.left=node;

            }
            else if(root.left.right==null){
                root.left.right=node;
            }
            else{
                nodetemp=levelOrderTraverse(root,parentItem,1);
                System.out.println("levelorder: "+nodetemp);
                if(nodetemp==null){
                    System.out.println("Such a parent could not be found.");
                    return false;
                }
                if(nodetemp != null){
                    Node<E> tmp = nodetemp.left;
                    if(nodetemp.left != null) {
                        while (tmp.right != null) {
                            tmp = tmp.right;
                        }
                        tmp.right=node;
                    }else
                        nodetemp.left = node;
                }

            }
            return true;
        }

    /**
     * Traverses the tree in pre order, first the root node, then the left node, finally the right node and so on
     * @param node
     * @param depth
     * @param sb
     */
        private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb){
            for(int i=1; i<depth;++i){
                sb.append("---");
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
    /**
     * Traverses the tree in post order, first the left node, then the right node, finally the root node and so on
     * @param node
     * @param depth
     */
        private Node<E> postOrderTraverse(Node<E> head,E node, int depth){
            Node temp=null;

            if(head==null){
               return null;
           }
           else{

               temp=postOrderTraverse(head.left,node,depth+1);

               if(temp!=null && temp.data==node){
                   return temp;
               }
               temp=postOrderTraverse(head.right,node,depth+1);
               if(temp!=null &&  temp.data==node){
                   return temp;
               }
               if(head.data==node){

                   return head;
               }

           }
           return null;
        }

    /**
     * Traverses the tree in level order; First the root node, then the children of the root node, then the children of the nodes in the second level an so on.
     * @param head
     * @param node
     * @param depth
     * @return node
     */
        private Node<E> levelOrderTraverse(Node<E> head, E node, int depth){
            Node temp=null;

            if(head==null){
                return null;
            }
            else{

                if(head.data==node){
                    return head;
                }
                else if(head.left!=null){
                    if(head.left.data==node){
                        return head.left;
                    }
                    temp=levelOrderTraverse(head.left.right,node,depth+1);
                    if(temp!=null && temp.data==node){
                        return temp;
                    }
                    temp = levelOrderTraverse(head.left,node,depth+1);
                    if(temp!=null && temp.data==node){
                        return temp;
                    }
                }

            }

            return null;
        }

    /**
     *print the tree according to pre order traverse
     * @return string
     */
    public String toString(){
            StringBuilder sb= new StringBuilder();
            preOrderTraverse(root,1,sb);
            return sb.toString();
        }
}
