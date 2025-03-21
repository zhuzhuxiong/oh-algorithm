package com.labula.bit;

/**
 * add binary
 * @author zz
 */
public class No5Code67 {

    public String addBinary(String a, String b) {

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int m = a.length(), n = b.length();
        int carry = 0;
        int i = 0;

        StringBuilder res = new StringBuilder();
        while (i < Math.max(m, n) || carry > 0) {
            int val = carry;
            val = val + (i < m ? (a.charAt(i) - '0') : 0);
            val = val + (i < n ? (b.charAt(i) - '0') : 0);
            res.append(val % 2);
            carry = val / 2;
            i++;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(new No5Code67().addBinary(a, b));
        System.out.println(new No5Code67().practice(a, b));
    }

    public String practice(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int m = a.length(), n = b.length();
        int carry = 0;
        int i = 0;

        StringBuilder res = new StringBuilder();
        while (i < Math.max(m, n) || carry > 0) {
            int val = carry;
            val = val + (i < m ? (a.charAt(i) - '0') : 0);
            val = val + (i < n ? (b.charAt(i) - '0') : 0);

            res.append(val % 2);
            carry = val / 2;

            i++;
        }
        return res.reverse().toString();
    }
}
