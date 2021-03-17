package com.avi.practice.company.microsoft.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * 3
 * /   \
 * 1       4
 * /       /  |
 * 3        1  5
 * <p>
 * <p>
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 * Explanation: Nodes in blue are good.
 * Root Node (3) is always a good node.
 * Node 4 -> (3,4) is the maximum value in the path starting from the root.
 * Node 5 -> (3,4,5) is the maximum value in the path
 * Node 3 -> (3,1,3) is the maximum value in the path.
 * <p>
 * <p>
 * Example 2:
 * 3
 * 3
 * 4      2
 * <p>
 * <p>
 * Input: root = [3,3,null,4,2]
 * Output: 3
 * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
 * Example 3:
 * <p>
 * Input: root = [1]
 * Output: 1
 * Explanation: Root is considered as good.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the binary tree is in the range [1, 10^5].
 * Each node's value is between [-10^4, 10^4].
 */
public class CountGoodNodesInBinaryTree {
    private final Map<TreeNode, Integer> max = new HashMap<>();
    private int numGoodNodes = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max.put(root, root.val);
        updateMax(root, root.left);
        updateMax(root, root.right);

        return numGoodNodes;
    }

    private void updateMax(TreeNode parent, TreeNode child) {
        if (parent == null || child == null) {
            return;
        }
        final int currMax = max.get(parent);
        final int newMax;
        if (child.val >= currMax) {
            numGoodNodes++;
            newMax = child.val;
        } else {
            newMax = currMax;
        }
        max.put(child, newMax);
        updateMax(child, child.left);
        updateMax(child, child.right);
    }


    public static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
