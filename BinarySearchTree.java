import static java.lang.System.*;

import java.util.*;

public class BinarySearchTree {
    public TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(Comparable val) {
        root = add(val, root);
    }

    private TreeNode add(Comparable val, TreeNode tree) {
        if (tree == null) {
            tree = new TreeNode(val);
            return tree;
        }
        Comparable treeValue = tree.getValue();
        int dirTest = val.compareTo(treeValue);
        if (dirTest <= 0) tree.setLeft(add(val, tree.getLeft()));
        else tree.setRight(add(val, tree.getRight()));
        return tree;
    }

    public void inOrder() {
        inOrder(root);
        out.println();
    }

    public void preOrder() {
        preOrder(root);
        out.println();
    }

    public void postOrder() {
        postOrder(root);
        out.println();
    }

    public void reverseOrder() {
        reverseOrder(root);
        out.println();
    }

    private void inOrder(TreeNode tree) {
        if (tree != null) {
            inOrder(tree.getLeft());
            System.out.print(tree.getValue() + " ");
            inOrder(tree.getRight());
        }
    }

    private void preOrder(TreeNode tree) {
        if (tree != null) {
            System.out.print(tree.getValue() + " ");
            preOrder(tree.getLeft());
            preOrder(tree.getRight());
        }
    }

    private void postOrder(TreeNode tree) {
        if (tree != null) {
            postOrder(tree.getLeft());
            postOrder(tree.getRight());
            System.out.print(tree.getValue() + " ");
        }
    }

    private void reverseOrder(TreeNode tree) {
        if (tree != null) {
            reverseOrder(tree.getRight());
            System.out.print(tree.getValue() + " ");
            reverseOrder(tree.getLeft());
        }
    }

    public int getWidth() {
        return findLeft(0, root) + findRight(0, root) - 1; // -1 so that root is
        // not included
    }

    public int getNumLevels() {
        return getNumLevels(root);
    }

    private int getNumLevels(TreeNode tree) {
        if (tree == null) return 0;
        else if (getNumLevels(tree.getLeft()) > getNumLevels(tree.getRight())) return 1 + getNumLevels(tree.getLeft());
        else return 1 + getNumLevels(tree.getRight());
    }

    public int numLeaves() {
        return numLeaves(root);
    }

    private int numLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.getLeft() == null && root.getRight() == null) return 1;
        return numLeaves(root.getLeft()) + numLeaves(root.getRight());
    }

    public int findLeft(int count, TreeNode node) {
        if (node == null) return count;
        return findLeft(count + 1, node.getLeft());
    }

    public int findRight(int count, TreeNode node) {
        if (node == null) return count;
        return findRight(count + 1, node.getRight());
    }

    public int numNodes() {
        return numNodes(root);
    }

    public int numNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + numNodes(root.getLeft()) + numNodes(root.getRight());
    }
    //add extra credit options here - 10 points each

    //search

    //maxNode

    //minNode

    //level order

    //display like a tree

    //remove


    public String toString() {
        return toString(root);
    }

    private String toString(TreeNode tree) {
        if (tree != null) {
            return tree.getValue() + " " + toString(tree.getLeft()) + toString(tree.getRight());
        }
        return "";
    }

    public boolean isFull() {
        return isFull(root);
    }

    public boolean isFull(TreeNode root) {
        if (root == null) return true;
        if (root.getLeft() == null & root.getRight() != null |
                root.getLeft() != null & root.getRight() == null) return false;
        return isFull(root.getLeft()) & isFull(root.getRight());
    }

    public boolean binarySearch(int val) {
        return binarySearch(root, val);
    }


    public boolean binarySearch(TreeNode root, int val) {
        //returns the number of operations to find the value, or -1 if it does not exist
        if (root == null) return false;
        if (root.getValue().equals(val)) return true;
        return binarySearch(root.getLeft(), val) | binarySearch(root.getRight(), val);
    }

    public int max() {
        return max(root);
    }

    private int max(TreeNode root) {
        if (root == null) return -1;
        if (root.getRight() == null) return (int) root.getValue();
        return max(root.getRight());
    }

    public int min() {
        return min(root);
    }

    private int min(TreeNode root) {
        if (root == null) return -1;
        if (root.getLeft() == null) return (int) root.getValue();
        return min(root.getLeft());
    }

    public void levelOrder() {
        levelOrder(root);
    }

    public void levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>(); //using BFS with queue
        q.add(root); //starting level is always just the parent node
        while (!q.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < q.size(); i++) {
                TreeNode curr = q.poll(); //this will get all of the children that were added last iteration(or the root)
                currentLevel.add((int) curr.getValue());
                if (curr.getLeft() != null) {
                    q.offer(curr.getLeft());
                }
                if (curr.getRight() != null) {
                    q.offer(curr.getRight());
                }
                //for example, in the first case, it will find that the parent has 2 children
                //nodes and add them to the queue for the next iteration.
            }
            //if no more nodes are in the queue, that means that all nodes were leaves. End.
            System.out.println(currentLevel);
        }
    }

    public void printTree() {
        printTree(root);
    }

    public void printTree(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                currentLevel.add((int) curr.getValue());

                if (curr.getLeft() != null) {
                    q.offer(curr.getLeft());
                }
                if (curr.getRight() != null) {
                    q.offer(curr.getRight());
                }
            }
            //same level-order BFS solution.
            //to find out the padding, you can use getNumLevels to find the height of the tree
            //print them space separated(or add more padding in the repeat call)
            System.out.print(" ".repeat(2 * (getNumLevels() - 1 - count)));
            for (int i = 0; i < currentLevel.size(); i++) {
                System.out.print(currentLevel.get(i) + " ".repeat(1));
            }
            out.println();
            count++; //less padding is now needed to adjust for the new nodes
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        //make sure to use the root as a parameter in the runner
        //do this by setting the instance variable to public
        if (root == null) return null; //there is nothing left
        if ((int) root.getValue() > key) { //the node is on the left side of the BST
            root.setLeft(deleteNode(root.getLeft(), key));
        } else if ((int) root.getValue() < key) { //the node is on the right side
            root.setRight(deleteNode(root.getRight(), key));
        } else { //if reaching this point, the node must be equal to key
            if (root.getLeft() == null) return root.getRight(); //this will be added to the setLeft/setRight call
            if (root.getRight() == null) return root.getLeft();
            TreeNode rightSmallest = root.getRight(); //next largest node
            while (rightSmallest.getLeft() != null) rightSmallest = rightSmallest.getLeft();
            rightSmallest.setLeft(root.getLeft());
            return root.getRight();
        }
        return root;

    }
}