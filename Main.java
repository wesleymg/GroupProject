import java.util.*;

public class Main {
  public static void main(String[] args) {
    //For now, N == 10
    Integer[] input = new Integer[10];
    for (int i = 0; i < input.length; i++) {
      input[i] = (int)(Math.random() * 100);
    }
    BST<Integer> searchTree = new BST<Integer>(input);
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
