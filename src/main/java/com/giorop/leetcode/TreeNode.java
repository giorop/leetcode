package com.giorop.leetcode;

/**
 * @Description TODO
 * @ClassName TreeNode
 * @Author 夏雨人
 * @DateTime 2023/3/2 8:46
 * @Version 1.0
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
