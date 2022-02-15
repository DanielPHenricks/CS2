//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

public class HistoTree {
	private HistoNode tree;

	public HistoTree() {
		tree = null;
	}

	public void addData(Comparable data) {
		tree = add(data, tree);
	}

	private HistoNode add(Comparable data, HistoNode tree) {
		if (tree == null) { //you are at the 1st node or leaf of the tree
			tree = new HistoNode(data, 1, null, null);
			return tree;
		}
		Comparable treeValue = tree.getData();
		int dirTest = data.compareTo(treeValue);
		if (dirTest == 0) tree.setDataCount(tree.getDataCount() + 1); //the node is the same
		else if (dirTest < 0) { //it is in the left subtree
			tree.setLeft(add(data, tree.getLeft()));
		} else tree.setRight(add(data, tree.getRight())); //else it must be in the right subtree
		return tree;
	}

	private HistoNode search(Comparable data) {
		return search(data, tree);
	}

	private HistoNode search(Comparable data, HistoNode tree) {
		if (tree != null) {
			if (data.compareTo(tree.getData()) == 0) {
				return tree;
			}
			if (data.compareTo(tree.getData()) < 0) {
				return search(data, tree.getLeft());
			} else return search(data, tree.getRight());
		}
		return null;
	}

	public String toString() {
		return toString(tree);
	}

	private String toString(HistoNode tree) {
		if (tree != null) {
			return tree.getData() + "-" + tree.getDataCount() + " " + toString(tree.getLeft()) + toString(tree.getRight());
		}
		return "";
	}
}