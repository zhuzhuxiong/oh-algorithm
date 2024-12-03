package com.labula.graph.BFS;

import com.structure.tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * minimum depth of binary-tree
 *
 * @author zz
 */
public class No1Code111 {

    /**
     * BFS
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //bfs 核心
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //root本身就占一层
        int depth = 1;

        //类似层序遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
//        输出：2
//        输入：root = [3,9,20,null,null,15,7]
    }

    public int practice(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.right == null && cur.left == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
