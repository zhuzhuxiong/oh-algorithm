package com.labula.tree.serialize;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 序列化与反序列化
 *
 * @author zz
 */
public class No1Code297_3 {

    private final String SEP = ",";
    private final String NULL = "#";

    /**
     * 后序方式
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        /**
         * queue.add(root) -- linkLast(e)
         * queue.addLast() -- linkLast(e);
         * queue.addFirst() -- linkFirst(e);
         *
         * queue.offer() -- add(e) -- linkLast(e);
         * queue.offerFirst() -- addFirst(e) -- linkFirst(e);
         * queue.offerLast() -- addLast(e) -- linkLast(e);
         */
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] nodes = data.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < nodes.length; ) {
            TreeNode node = queue.poll();

            String left = nodes[i++];
            if (!left.equals(NULL)) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.offer(node.left);
            }else {
                node.left = null;
            }

            String right = nodes[i++];
            if (!right.equals(NULL)) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.offer(node.right);
            }else {
                node.right = null;
            }
        }
        return root;
    }



    public static void main(String[] args) {
//        输出：[1,2,3,null,null,4,5]
        TreeNode root = TreeNode.listToTree(Arrays.asList(1, 2, 3, null, null, 4, 5));
        String serialize = new No1Code297_3().serialize(root);
        System.out.println(serialize);

        TreeNode node = new No1Code297_3().deserialize(serialize);
        PrintUtil.printTree(node);
    }
}
