package netcracker.task4.task4;

/**
 * Main program's class
 *
 * @author Bezruk Vladislav
 */
public class Main {
    //Main function
    public static void main(String[] args) {
                /* Constructed binary tree is
               1
             /   \
            2      3
          /   \
         4     5
        */
        BinaryTree tree = new BinaryTree();
        tree.root = new TNode(1);
        tree.root.left = new TNode(2);
        tree.root.right = new TNode(3);
        tree.root.left.left = new TNode(4);
        tree.root.left.right = new TNode(5);

        System.out.print("Pre order traversal:");
        tree.iterativePreorder();
        System.out.println("\n");
        System.out.print("In order traversal:");
        tree.inOrderTraversal(tree.root);
        System.out.println("\n");
        System.out.print("Post order traversal:");
        BinaryTree.postOrderIterative(tree.root);
        System.out.println("\n");
        System.out.print("Tree's height:");
        System.out.println(tree.height(tree.root));
    }
}
