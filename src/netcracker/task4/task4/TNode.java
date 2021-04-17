package netcracker.task4.task4;

/**
 * Class that implements the node of the binary tree
 *
 * @author Bezruk Vladislav
 */
public class TNode {
    //Node value
    int data;
    //Left and right descendants
    TNode left, right;

    /**
     * Class constructor
     *
     * @param item - node value
     */
    TNode(int item) {
        data = item;
        left = right = null;
    }
}
