package com.hanke.ave.ihotel.common.util;

import net.sf.json.JSONArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author hankeOne
 * @description 字符串工具类
 * @date 2018/2/12 15:42
 */
public class StringUtil {

    /**
     * @param
     * @return
     * @author hankeOne
     * @description 去掉字符串中的所有空格、换行符、制表符等
     * @date 2018/2/12 15:42
     */
    public static String trimAll(String str) {
        str = str.trim();
        Pattern pattern = Pattern.compile("\t|\r|\n");
        Matcher matcher = pattern.matcher(str);
        str = matcher.replaceAll("");

        return str;
    }

    /**
     * @param str 源字符串
     * @param tag 拆分源字符串的分隔符
     * @return
     * @author hankeOne
     * @description 按照指定分隔符拆分字符串
     * @date 2018/2/12 15:43
     */
    public static String[] split(String str, String tag) {
        if (isEmpty(str)) {
            return null;
        }

        str = str.trim();

        // 如果字符串的值等于拆分标记
        if (str.equals(tag)) {
            String[] arr = new String[1];
            arr[0] = str;

            return arr;
        }

        // 如果字符串第一个字符的值等于拆分标记，那么将其去掉
        String firstStr = str.substring(0, 1);
        if (firstStr.equals(tag)) {
            str = str.substring(1, str.length());
        }

        // 如果字符串最后一个字符的值等于拆分标记，那么将其去掉
        String lastStr = str.substring(str.length() - 1, str.length());
        if (lastStr.equals(tag)) {
            str = str.substring(0, str.length() - 1);
        }

        // 如果字符串的长度为1，或者，字符串中不包含拆分标志
        if (str.length() == 1 || !str.contains(tag)) {
            String[] arr = new String[1];
            arr[0] = str;

            return arr;
        }

        return str.split(tag);
    }

    /**
     * @param sList     元素为纯字符串的集合
     * @param partition 转换为字符串后的分隔符
     * @return
     * @author hankeOne
     * @description 将字符串集合转换为字符串
     * @date 2018/2/12 15:43
     */
    public static String list2String(Collection<String> sList, String partition) {
        if (null != sList && sList.size() > 0) {
            List<String> list = new ArrayList(sList);

            List<String> tList = new ArrayList<String>();

            for (String str : list) {
                if (isNotEmpty(str)) {
                    tList.add(str);
                }
            }

            if (tList.size() > 0) {
                list = tList;
            }

            StringBuffer bf = new StringBuffer("");

            int firstIndex = 0;

            if (isEmpty(partition)) {
                partition = ",";
            }

            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);

                if (i == firstIndex) {
                    bf.append(str);
                } else {
                    bf.append(partition).append(str);
                }
            }

            if (bf.length() > 0) {
                return bf.toString();
            }
        }

        return null;
    }

    /**
     * @param array     元素为纯字符串的数组
     * @param partition 转换为字符串后的分隔符
     * @return
     * @author hankeOne
     * @description 将字符串数组转换为字符串
     * @date 2018/2/12 15:44
     */
    public static String array2String(String[] array, String partition) {
        if (null != array && array.length > 0) {
            List<String> list = new ArrayList<String>();

            for (String str : array) {
                if (isNotEmpty(str)) {
                    list.add(str);
                }
            }

            if (list.size() > 0) {
                array = list.toArray(new String[list.size()]);
            }

            StringBuffer bf = new StringBuffer("");

            int firstIndex = 0;

            if (isEmpty(partition)) {
                partition = ",";
            }

            for (int i = 0; i < array.length; i++) {
                String str = array[i];

                if (i == firstIndex) {
                    bf.append(str);
                } else {
                    bf.append(partition).append(str);
                }
            }

            if (bf.length() > 0) {
                return bf.toString();
            }
        }

        return null;
    }

    /**
     * @param array     元素为纯字符串的JSON数组
     * @param partition 转换为字符串后的分隔符
     * @return
     * @author hankeOne
     * @description 将JSONArray array 转换为字符串
     * @date 2018/2/12 15:44
     */
    public static String jsonArray2String(JSONArray array, String partition) {
        if (null != array && array.size() > 0) {
            JSONArray tArray = new JSONArray();

            for (Object jObj : array) {
                if (jObj != null && isNotEmpty(jObj.toString())) {
                    tArray.add(jObj);
                }
            }

            if (tArray.size() > 0) {
                array = tArray;
            }

            StringBuffer bf = new StringBuffer();

            int firstIndex = 0;

            if (isEmpty(partition)) {
                partition = ",";
            }

            for (int i = 0; i < array.size(); i++) {
                String str = array.get(i).toString();

                if (i == firstIndex) {
                    bf.append(str);
                } else {
                    bf.append(partition).append(str);
                }
            }

            if (bf.length() > 0) {
                return bf.toString();
            }
        }

        return null;
    }

    /**
     * @param s
     * @return
     * @author hankeOne
     * @description 检测字符串是否不为空
     * @date 2018/2/12 15:44
     */
    public static boolean isNotEmpty(String s) {
        boolean notEmpty = true;

        if (null == s || "" == s || "".equalsIgnoreCase(s) || s.trim() == ""
                || s.trim().equalsIgnoreCase("")) {
            notEmpty = false;
        }

        return notEmpty;
    }

    /**
     * @param s
     * @return
     * @author hankeOne
     * @description 检测字符串是否为空
     * @date 2018/2/12 15:44
     */
    public static boolean isEmpty(String s) {
        boolean isEmpty = true;

        if (null != s && "" != s && !"".equalsIgnoreCase(s) && s.trim() != "") {
            isEmpty = false;
        }

        return isEmpty;
    }

}
