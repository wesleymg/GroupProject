public class Main {
  public static void main(String[] args) {
    Integer[] temp = {1,2,3,4,5,6,7,8,9,0};
    BST<Integer> test = new BST<Integer>(temp);
    test.postorder();
    System.out.println();
    test.preorder();
  }
}
