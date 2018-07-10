package com.hanke.ave.ihotel.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hankeOne
 * @description 数字工具类
 * @date 2018/2/12 15:41
 */
public class NumberUtil {

    /**
     * @param
     * @return
     * @author hankeOne
     * @description 从字符串中提取数字
     * @date 2018/2/12 15:41
     */
    public static double getNumberByString(String str) {
        double number = 0.0D;

        if (StringUtil.isNotEmpty(str)) {
            //去掉非数字相关的字符串
            String regEx = "[^0-9|.]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            String num = m.replaceAll("").trim();

            // 判断是否为数字开头，并且以数字结尾
            boolean isPurityNumber = StringUtil.isNotEmpty(num)
                    && (num.charAt(0) >= 48 && num.charAt(0) <= 57)
                    && (num.charAt(num.length() - 1) >= 48 && num.charAt(num.length() - 1) <= 57);

            // 如果是纯净的数字，则转换成 double 类型
            if (isPurityNumber) {
                try {
                    number = Double.valueOf(num);
                } catch (Exception e) {
                    return 0.0D;
                }
            }
        }

        return number;
    }
}
