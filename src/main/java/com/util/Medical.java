package com.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author
 */
public class Medical {

    public static void main(String[] args) {
        double a = 10;
        double b = 278;
        double c = 10602;
        double d = 11726243;

        //保留两位小数，四舍五入
        System.out.println("公式1：ROR:" + new BigDecimal(calROR(a, b, c, d)).setScale(2, RoundingMode.HALF_UP));

        String ci = calCI(a, b, c, d);
        System.out.println("公式2：95%CI:" + ci);

        double prr = calPRR(a, b, c, d);
        System.out.println("公式3：PRR:" + new BigDecimal(prr).setScale(2, RoundingMode.HALF_UP));

        double x2 = calX2(a, b, c, d);
        System.out.println("公式4：X^2:" + new BigDecimal(x2).setScale(2, RoundingMode.HALF_UP));

        double ic = calIC(a, b, c, d);
        System.out.println("公式5：IC:" + new BigDecimal(ic).setScale(2, RoundingMode.HALF_UP));

        double ic025 = calIC025(a, b, c, d);
        System.out.println("公式6：IC025:" + new BigDecimal(ic025).setScale(2, RoundingMode.HALF_UP));

        double ebgm = calEBGM(a, b, c, d);
        System.out.println("公式7：EBGM:" + new BigDecimal(ebgm).setScale(2, RoundingMode.HALF_UP));

        double ebgm05 = calEBGM05(a, b, c, d);
        System.out.println("公式8：EBGM05：" + new BigDecimal(ebgm05).setScale(2, RoundingMode.HALF_UP));
    }

    /**
     * 公式1：ROR = ad/bc
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public static double calROR(double a, double b, double c, double d) {
        return a * d / (b * c);
    }

    /**
     * 公式2：95%CI
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public static String calCI(double a, double b, double c, double d) {
        // 计算：ln(ROR)
        double part1 = Math.log(calROR(a, b, c, d));
        // 计算：(1/a+1/b+1/c+1/d)
        double part2 = (1 / a + 1 / b + 1 / c + 1 / d);
        // 计算：(1/a+1/b+1/c+1/d)^0.5
        double part3 = Math.pow(part2, 0.5);
        // 计算：ln(IC) - 1.96(1/a+1/b+1/c+1/d)^0.5
        double part4 = part1 - 1.96 * part3;
        // 计算：e^[ln(IC) - 1.96(1/a+1/b+1/c+1/d)^0.5]
        double floor = Math.pow(Math.E, part4);

        // 计算：ln(IC) + 1.96(1/a+1/b+1/c+1/d)^0.5
        double part5 = part1 + 1.96 * part3;
        // 计算：e^[ln(IC) + 1.96(1/a+1/b+1/c+1/d)^0.5]
        double ceil = Math.pow(Math.E, part5);

        return new BigDecimal(floor).setScale(2,RoundingMode.HALF_UP) + "--" + new BigDecimal(ceil).setScale(2,RoundingMode.HALF_UP);
    }

    /**
     * 公式3：PRR = a(c+d)/(a+b)/c
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return 11736845  288
     */
    public static double calPRR(double a, double b, double c, double d) {
        return a * (c + d) / (a + b) / c;
    }

    /**
     * 公式4：X^2 = ...
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public static double calX2(double a, double b, double c, double d) {
        double part1 = a * d - (b * c);

        double part2 = a + d + b + c;

        double part3 = (a + b) * (c + d) * (a + c) * (b + d);

        return part1 * part1 * part2 / part3;
    }

    /**
     * 公式5：IC
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public static double calIC(double a, double b, double c, double d) {
        double part1 = a + d + b + c;
        double part2 = a * part1 / (a + b) / (a + c);
        //换底公式,java只有以e为底的函数
        return Math.log(part2) / Math.log(2);
    }

    /**
     * 公式6：IC025
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public static double calIC025(double a, double b, double c, double d) {
        // 计算：ln(IC)
        double part1 = Math.log(calIC(a, b, c, d));
        // 计算：(1/a+1/b+1/c+1/d)
        double part2 = (1 / a + 1 / b + 1 / c + 1 / d);
        // 计算：(1/a+1/b+1/c+1/d)^0.5
        double part3 = Math.pow(part2, 0.5);
        // 计算：ln(IC) - 1.96(1/a+1/b+1/c+1/d)^0.5
        double part4 = part1 - 1.96 * part3;
        // 计算：e^[ln(IC) - 1.96(1/a+1/b+1/c+1/d)^0.5]
        return Math.pow(Math.E, part4);
    }

    /**
     * 公式7：EBGM
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public static double calEBGM(double a, double b, double c, double d) {
        double part1 = a + d + b + c;

        return a * part1 / (a + b) / (a + c);
    }

    /***
     * 公式八：EBGM05
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public static double calEBGM05(double a, double b, double c, double d) {
        // 计算：ln(EBGM)
        double part1 = Math.log(calEBGM(a, b, c, d));
        // 计算：(1/a+1/b+1/c+1/d)
        double part2 = (1 / a + 1 / b + 1 / c + 1 / d);
        // 计算：(1/a+1/b+1/c+1/d)^0.5
        double part3 = Math.pow(part2, 0.5);
        // 计算：ln(EBGM) - 1.64(1/a+1/b+1/c+1/d)^0.5
        double part4 = part1 - 1.64 * part3;
        // 计算：e^[ln(EBGM) - 1.64(1/a+1/b+1/c+1/d)^0.5]
        return Math.pow(Math.E, part4);
    }


}
