package com.labula.tree.level;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 层序-龙摆尾
 *
 * @author zz
 */
public class Code103No4 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (flag) {
                    list.addLast(node.val);
                }else {
                    list.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.listToTree(Arrays.asList(1,2,3,4,null,null,5));
        PrintUtil.printTree(root);
        System.out.println(new Code103No4().zigzagLevelOrder(root));


        TreeNode root1 = TreeNode.listToTree(Arrays.asList(1,2,3,4,5));
        PrintUtil.printTree(root1);
        System.out.println(new Code103No4().zigzagLevelOrder(root1));
    }
}
