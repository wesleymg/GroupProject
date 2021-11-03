import java.util.*;

public class Main {
    public static void main(String[] args) {
        //TODO: merge in Ariels random code
        BST<Integer> searchTree = new BST<Integer>(input);

        //arraylist to store the random numbers to find min and max
        ArrayList<Integer> storeRandomNumbers = new ArrayList<Integer>();

        Random rand = new Random();

        //use populateBST function to populate BST and arraylist with the random numbers
        populateBST(searchTree, rand, storeRandomNumbers);

        System.out.println();
        System.out.println("The min node is: " + findMin(storeRandomNumbers));
        System.out.println("The max node is: " + findMax(storeRandomNumbers));

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

    //function to populate BST and arraylist with the random numbers
    public static void populateBST(BST randomBST, Random rand, ArrayList<Integer> storeRandomNumbers) {
        System.out.print("Generate a random BST with 10 nodes:");
        for (int i = 0; i < 10; i++) {
            int random = rand.nextInt(50) + 1;
            randomBST.insert(random);
            storeRandomNumbers.add(random);
            System.out.print("\t" + random);
        }
    }

    //function to find min number in arraylist
    public static int findMin(ArrayList<Integer> storeRandomNumbers){
        int min = Collections.min(storeRandomNumbers);
        return min;
    }

    //function to find max number in arraylist
    public static int findMax(ArrayList<Integer> storeRandomNumbers){
        int max = Collections.max(storeRandomNumbers);
        return max;
    }
}