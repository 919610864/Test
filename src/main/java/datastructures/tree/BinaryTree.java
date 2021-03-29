package datastructures.tree;

public class BinaryTree<T extends Comparable<? super T>>{

    public BinaryNode root;

    private static class BinaryNode<T>{


        public BinaryNode current;

        public BinaryNode left;

        public BinaryNode right;
    }

    void insert(BinaryNode binaryNode){
        if(root == null){
            root = new BinaryNode();
        }

    }
}
