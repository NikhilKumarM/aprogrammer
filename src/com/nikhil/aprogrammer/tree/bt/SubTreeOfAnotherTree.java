package com.nikhil.aprogrammer.tree.bt;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implementing a program to check if the a tree is the subtree of another tree.
 */
public class SubTreeOfAnotherTree {

    /**
     * This method is to check if the tree t is the subtree of the tree s.
     *
     * @param s Root Node of the tree s.
     * @param t Root Node of the tree t.
     * @return Return {@code true} if t is the sub tree of s, else returns {@code false}.
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(s);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            if (treeNode.val == t.val) {
                if (isSame(treeNode, t)) {
                    return true;
                }
            }

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }

            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }

        return false;
    }

    /**
     * This method checks if the given two trees are indentical.
     *
     * @param p Root Node of the Tree
     * @param q Root Node of the Tree
     * @return Returns {@code true} if the trees are identical, else returns {@code false}.
     */
    public boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null && p.val == q.val) {
            return isSame(p.left, q.left) && isSame(p.right, q.right);
        }

        return false;
    }
}
