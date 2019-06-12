package datastructures.tree;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    private static class BinaryNode<AnyType> {

        public BinaryNode() {

        }

        public BinaryNode(AnyType element, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;
    }

    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, this.root);
    }

    public boolean contains(AnyType x, BinaryNode<AnyType> root) {
        if (root == null) {
            return false;
        }
        int compareResult = x.compareTo(root.element);
        if (compareResult < 0) {
            return contains(x, root.left);
        } else if (compareResult > 0) {
            return contains(x, root.right);
        } else {
            return true;
        }
    }

    public AnyType findMin() {

        return findMin(this.root).element;
    }

    public BinaryNode<AnyType> findMin(BinaryNode<AnyType> root) {
        if (root == null) {
            return null;
        }else if(root.left == null){
            return root;
        }
        return findMin(root.left);
    }

    public AnyType findMax(){
        return findMax(this.root).element;
    }

    public BinaryNode<AnyType> findMax(BinaryNode<AnyType> root){
        if(root!=null){
            while (root.right!=null){
                root = root.right;
            }
        }

        return root;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    /**
     * Internal method to insert into a subtree
     * @param x the item to insert
     * @param root the node that roots the subtree
     * @return the new root of the subtree
     */
    public BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> root) {
        if(root == null){
            return new BinaryNode<>(x,null,null);
        }
        int compareResult = x.compareTo(root.element);
        if(compareResult<0){
            root.left = insert(x,root.left);
        }else if(compareResult>0){
            root.right = insert(x,root.right);
        }else {
            //do nothing
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(5%9);
    }
}
