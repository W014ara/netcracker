package netcracker.task4.task4;

import java.util.Stack;

/**
 * A class that implements a simple binary tree
 *
 * @author Bezruk Vladislav
 */
public class BinaryTree {
    TNode root;

    // Two stacks as used in explanation
    static Stack<TNode> s1, s2;

    /**
     * Function to traverse a binary tree without recursion and without stack
     *
     * @param root - root node
     */
    public void inOrderTraversal(TNode root) {
        TNode current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                /* Find the inorder
                    predecessor of current
                 */
                pre = current.left;
                while (pre.right != null
                        && pre.right != current)
                    pre = pre.right;

                /* Make current as right
                   child of its
                 * inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                /* Revert the changes made
                   in the 'if' part
                   to restore the original
                   tree i.e., fix
                   the right child of predecessor*/
                else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                } /* End of if condition pre->right == NULL
                 */

            } /* End of if condition current->left == NULL*/

        } /* End of while */
    }

    /**
     * Compute the "height" of a tree -- the number of
     * nodes along the longest path from the root node
     * down to the farthest leaf node.
     *
     * @param node - tree node
     * @return - returns the height of the tree
     */
    public int height(TNode node) {
        if (node == null)
            return 0;
        else {
            /* compute the height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);

            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    /**
     * A method that implements reverse tree traversal
     *
     * @param root - tree root node
     */
    static void postOrderIterative(TNode root) {
        // Create two stacks
        s1 = new Stack<>();
        s2 = new Stack<>();

        if (root == null)
            return;

        // push root to first stack
        s1.push(root);

        // Run while first stack is not empty
        while (!s1.isEmpty()) {
            // Pop an item from s1 and push it to s2
            TNode temp = s1.pop();
            s2.push(temp);

            // Push left and right children of
            // removed item to s1
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }

        // Print all elements of second stack
        while (!s2.isEmpty()) {
            TNode temp = s2.pop();
            System.out.print(temp.data + " ");
        }
    }

    /**
     * An iterative process to print preorder traversal of Binary tree
     */
    public void iterativePreorder() {
        iterativePreorder(root);
    }

    /**
     * An iterative process to print preorder traversal of Binary tree
     *
     * @param node - tree root node
     */
    public void iterativePreorder(TNode node) {

        // Base Case
        if (node == null) {
            return;
        }

        // Create an empty stack and push root to it
        Stack<TNode> nodeStack = new Stack<TNode>();
        nodeStack.push(root);

        /* Pop all items one by one. Do following for every popped item
         a) print it
         b) push its right child
         c) push its left child
         Note that right child is pushed first so that left is processed first */
        while (!nodeStack.empty()) {

            // Pop the top item from stack and print it
            TNode mynode = nodeStack.peek();
            System.out.print(mynode.data + " ");
            nodeStack.pop();

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
    }
}
