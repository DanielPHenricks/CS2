//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;

public class BSTreeRunner {
    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(90);
        bst.add(80);
        bst.add(100);
        bst.add(85);
        bst.add(98);
        bst.add(70);
        bst.add(120);
        System.out.print("IN ORDER: ");
        bst.inOrder();
        System.out.print("PRE ORDER: ");
        bst.preOrder();
        System.out.print("POST ORDER: ");
        bst.postOrder();
        System.out.print("REVERSE ORDER: ");
        bst.reverseOrder();
        out.println("Number of leaves: " + bst.numLeaves());
        out.println("Height of " + (bst.getNumLevels() - 1));
        out.println("Width of " + bst.getWidth());
        out.println("Tree levels: " + (bst.getNumLevels() - 1));
        out.println("Tree nodes: " + (bst.numNodes()));
        out.println(bst);
        out.println("Tree is full: " + bst.isFull());
        out.println("Value of 100 is in the tree: " + bst.binarySearch(100));
        out.println("Max of " + bst.max() + " and min of " + bst.min());
        bst.levelOrder();
        bst.printTree();
        bst.deleteNode(bst.root, 80);
        out.println();
        out.println(bst);
    }
}