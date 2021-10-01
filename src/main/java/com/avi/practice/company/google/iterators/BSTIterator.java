package com.avi.practice.company.google.iterators;

import java.util.Stack;

/**
 * mplement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 * <p>
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
 * <p>
 * You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * Output
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 * <p>
 * Explanation
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // return 3
 * bSTIterator.next();    // return 7
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 9
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 15
 * bSTIterator.hasNext(); // return True
 * bSTIterator.next();    // return 20
 * bSTIterator.hasNext(); // return False
 */
public class BSTIterator {

    private final Stack<Pair> st = new Stack<>();
    private TreeNode inOrder = null;

    public BSTIterator(TreeNode root) {
        st.push(new Pair(root));
        assignNext();
    }

    public int next() {
        if (!hasNext()) {
            return -1;
        }
        final int val = inOrder.val;
        assignNext();
        return val;
    }

    public boolean hasNext() {
        return inOrder != null;
    }

    private void assignNext() {
        inOrder = null;
        while (!st.isEmpty() && inOrder == null) {
            final Pair top = st.peek();
            if (top.state == 0) {
                if (top.node.left != null) {
                    st.push(new Pair(top.node.left));
                }
                top.state++;
            } else if (top.state == 1) {
                if (top.node.right != null) {
                    st.push(new Pair(top.node.right));
                }
                inOrder = top.node;
                top.state++;
            } else {
                st.pop();
            }
        }
    }

    private static final class Pair {
        private final TreeNode node;
        private int state = 0;

        private Pair(final TreeNode node) {
            this.node = node;
        }

        public String toString() {
            return "(" + node + ", state: " + state + ")";
        }
    }

    static final class TreeNode {
        private final int val;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
