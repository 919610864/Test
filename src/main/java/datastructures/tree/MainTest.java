package datastructures.tree;

public class MainTest {

    public static void main(String[] args) {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.makeEmpty();
        binarySearchTree.insert("A");
        binarySearchTree.insert("B");
        binarySearchTree.insert("C");
        binarySearchTree.insert("E");
        binarySearchTree.insert("F");
        String max = binarySearchTree.findMax();
        String min = binarySearchTree.findMin();
        System.out.println(max+":"+min);
    }
}
