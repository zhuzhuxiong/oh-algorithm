package com.labula.backtrack;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 括号生成
 * @author zz
 */
public class No11Code22 {

    List<String> res = new ArrayList<>();
    StringBuilder track = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        if (0 == n) {
            return res;
        }
        backtrack(n, n);
        return res;
    }

    private void backtrack(int left, int right) {
        if (right < left) {
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }

        track.append("(");
        backtrack(left - 1, right);
        track.deleteCharAt(track.length() - 1);

        track.append(")");
        backtrack(left, right - 1);
        track.deleteCharAt(track.length() - 1);
    }

    public static void main(String[] args) {
        No11Code22 code22 = new No11Code22();
        System.out.println(code22.generateParenthesis(3));
        System.out.println(code22.practice(3));
    }

    List<String> result = new LinkedList<>();
    StringBuilder tk = new StringBuilder();
    public List<String> practice(int n) {
        bk(n, n);
        return result;
    }

    private void bk(int left, int right) {
        if (right < left) {
            return;
        }

        if (left < 0 || right < 0) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(tk.toString());
            return;
        }

        tk.append("(");
        bk(left - 1, right);
        tk.deleteCharAt(tk.length() - 1);

        tk.append(")");
        bk(left, right - 1);
        tk.deleteCharAt(tk.length() - 1);
    }
}
