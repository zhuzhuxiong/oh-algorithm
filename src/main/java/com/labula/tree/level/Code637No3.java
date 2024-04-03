package com.labula.tree.level;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zz
 */
public class Code637No3 {

    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int val = node.val;
                sum = sum + val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add( (sum / size));
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.listToTree(Arrays.asList(3,9,20,null,null,15,7));
        PrintUtil.printTree(root);
        System.out.println(new Code637No3().averageOfLevels(root));
    }
}
