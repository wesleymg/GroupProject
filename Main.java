import java.util.*;

public class Main {
  public static void main(String[] args) {
    //TODO: merge in Ariels random code
    BST<Integer> searchTree = new BST<Integer>(input);

    ArrayList<Integer> leaves = getLeaves(searchTree);

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
    BST.TreeNode<Integer> root = tree.getRoot();
    return crawler(root);
  }

  //Crawls through tree and returns an ArrayList of the leaves beneath any given
  //node
  private static ArrayList<Integer> crawler(BST.TreeNode<Integer> root) {
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
}
