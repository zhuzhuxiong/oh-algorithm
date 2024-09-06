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
public class No1Code297 {

    private final String SEP = ",";
    private final String NULL = "#";

    /**
     * 前序方式
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        for (String s : data.split(SEP)) {
            list.add(s);
        }
        return deserialize(list);
    }

    public TreeNode deserialize(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }

        String first = list.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;
    }

    public static void main(String[] args) {
//        输出：[1,2,3,null,null,4,5]
        TreeNode root = TreeNode.listToTree(Arrays.asList(1, 2, 3, null, null, 4, 5));
        String serialize = new No1Code297().serialize(root);
        System.out.println(serialize);
        TreeNode node = new No1Code297().deserialize(serialize);
        PrintUtil.printTree(node);

    }
}
