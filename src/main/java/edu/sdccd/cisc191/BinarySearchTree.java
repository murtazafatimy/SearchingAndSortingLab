package edu.sdccd.cisc191;

public class BinarySearchTree {
    /**
     * Recursively finds the needle in the Binary Search Tree (BST) haystack
     *
     * @param root   which node to start searching from
     * @param needle the data to search for
     * @return the first BSTNode containing the needle, null if doesn't exist
     */
    public BSTNode contains(BSTNode root, String needle) {
        // TODO: fill this out, you can choose any order of traversal

        if (root == null) {
            return null;
        } else if (needle.equals(root.getData())) {
            return root;
        } else if (needle.compareTo(root.getData()) < 0) {
            return contains(root.getLeft(), needle);
        } else {
            return contains(root.getRight(), needle);
        }
    }

    /**
     * Recursively converts a String array to Binary Search Tree (BST)
     *
     * @param array the array of Strings to import into the BST
     * @param start index in the array to begin importing
     * @param end   index in the array to stop importing
     * @return the root node of the generated BST
     */
    public BSTNode fromArray(String[] array, int start, int end) {
        // TODO: fill this out, you can choose any order of traversal
        if (start > end) {
            return null;

        } else {
            int mid = (start + end) / 2;

            BSTNode node = new BSTNode(array[mid]);
            node.setRight((fromArray(array, mid + 1, end)));
            node.setLeft((fromArray(array, start, mid - 1)));

            return node;
        }
    }
}
