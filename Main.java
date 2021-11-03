import java.util.*;

public class Main {
  public static void main(String[] args) {
    //TODO: merge in Ariels random code
    BST<Integer> searchTree = new BST<Integer>(input);

    ArrayList<Integer> leaves = getLeaves(searchTree);

    System.out.println("The height of the tree is: " + getHeight(searchTree));

    System.out.println("The # of nodes: " + (searchTree.size()-leaves.size()));
    System.out.println("The # of leaves: " + leaves.size());

    //Ordered prints
    System.out.print("Print the tree in inorder");
    searchTree.inorder();
    System.out.println();
    System.out.print("Print the tree in preorder");
    searchTree.preorder();
    System.out.println();
    System.out.print("Print the tree in postorder");
    searchTree.postorder();
    System.out.println();

    //Print paths
    System.out.print("Print the paths: [ ");
    for (int leaf: leaves) {
      searchTree.path(leaf);
      System.out.print(" ");
    }
    System.out.println("]");
  }

  private static ArrayList<Integer> getLeaves(BST<Integer> tree) {
    return leafCrawler(tree.getRoot());
  }

  //Crawls through tree and returns an ArrayList of the leaves beneath any given
  //node
  private static ArrayList<Integer> leafCrawler(BST.TreeNode<Integer> root) {
    ArrayList<Integer> results = new ArrayList<Integer>();
    if (root.left == null && root.right == null) {
      results.add(root.element);
      return results;
    }
    if (root.left != null) {
      results.addAll(crawler(root.left));
    }
    if (root.right != null) {
      results.addAll(crawler(root.right));
    }
    return results;
  }

  private static int getHeight(BST tree) {
    return heightCrawler(tree.getRoot());
  }

  private static int heightCrawler(BST.TreeNode<Integer> root) {
    if (root == null) return 1;
    return Math.max(preorder(root.left), preorder(root.right)) + 1;
  }
}
