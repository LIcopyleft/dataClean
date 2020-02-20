package com.drcnet.mc.bigdata.bmap.Utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * 
 * @author qi.sun
 * @time 2019-6-27 16:46:34
 */
public class StringUtils {

    /**
     * 获取32位UUID
     * 
     * @return 32位UUID
     */
    public static String get32UUID() {
        UUID uuid = UUID.randomUUID();
        String uuid32 = uuid.toString().replace("-", "");
        return uuid32;
    }

    /**
     * 判断字符串是否包含汉字
     */
    public static boolean containsChinese(String source) {
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher matcher = pattern.matcher(source);
        boolean contains = false;
        if (matcher.find()) {
            contains = true;
        }
        return contains;
    }

    /**
     * 去掉结尾字符串
     */
    public static String deleteLastChar(String source, String target) {
        if (null != source && target != null && source.length() > 0) {
            if (source.lastIndexOf(target) == source.length()
                - target.length()) {
                return source.substring(0, source.length() - target.length());
            }
        }
        return source;
    };

    /**
     * 以索引位置分隔
     */
    public static String[] splitByIndex(String source, int index) {
        String[] result = new String[2];
        result[0] = source.substring(0, index);
        result[1] = source.substring(index);
        return result;
    }

    /**
     * 获取首字母大写
     */
    public static String firstLetterUpperCase(String source) {
    	char[] cs=source.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
//        return source.substring(0, 1).toUpperCase() + source.substring(1);
    }

    /**
     * 获取首字母小写
     */
    public static String firstLetterLowerCase(String source) {
    	char[] cs=source.toCharArray();
        cs[0]+=32;
        return String.valueOf(cs);
//        return source.substring(0, 1).toLowerCase() + source.substring(1);
    }

    /**
     * 删除Html标签
     */
    public static String removeHtmlTag(String htmlStr) {
        // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
        String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
        // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
        String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
        // 定义HTML标签的正则表达式
        String regEx_html = "<[^>]+>";
        // 定义一些特殊字符的正则表达式 如：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        String regEx_special = "\\&[a-zA-Z]{1,10};";

        // 1.过滤script标签
        Pattern p_script = Pattern.compile(regEx_script,
            Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll("");
        // 2.过滤style标签
        Pattern p_style = Pattern.compile(regEx_style,
            Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll("");
        // 3.过滤html标签
        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll("");
        // 4.过滤特殊标签
        Pattern p_special = Pattern.compile(regEx_special,
            Pattern.CASE_INSENSITIVE);
        Matcher m_special = p_special.matcher(htmlStr);
        htmlStr = m_special.replaceAll("");

        return htmlStr;
    }

    public static String removeEleProp(String htmlStr) {
        final String regEx_tag = "<(\\w[^>|\\s]*)[\\s\\S]*?>";
        Pattern p = Pattern.compile(regEx_tag, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(htmlStr);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String tagWithProp = m.group(0);
            String tag = m.group(1);
            if ("img".equals(tag)) {
                // img标签保留属性，可进一步处理删除无用属性，仅保留src等必要属性
                m.appendReplacement(sb, tagWithProp);
            } else if ("a".equals(tag)) {
                // a标签保留属性，可进一步处理删除无用属性，仅保留href等必要属性
                m.appendReplacement(sb, tagWithProp);
            } else {
                m.appendReplacement(sb, "<" + tag + ">");
            }
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /**
     * 去除html标签
     */
    public static String removeHtmlTagRough(String source) {
        String regEx_html = "<\\/?.+?\\/?>";
        // 去除html标签
        Pattern pattern = Pattern.compile(regEx_html);
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            source = source.replace(matcher.group(), "");
        }
        source = source.replaceAll("&[a-zA-Z]+;", "");
        source = replaceSpace(source);
        return source;
    }

    /**
     * 去除空格
     */
    public static String removeSpace(String source) {
        source = replaceSpace(source).replaceAll("\\s+", "");
        return source;
    }

    /**
     * 替换空格
     */
    public static String replaceSpace(String source) {
        source = source.replaceAll("\t", " ");
        source = source.replaceAll("\r", " ");
        source = source.replaceAll("\n", " ");
        source = source.replaceAll("\\s+", " ");
        source = source.trim();
        return source;
    }

    /**
     * 去除emoji
     */
    public static String removeEmoji(String source) {
        while (true) {
            Integer pos = source.indexOf("\uD83D");
            if (pos == -1) {
                pos = source.indexOf("\uD83C");
            }
            if (pos != -1) {
                source = source.substring(0, pos) + source.substring(pos + 2);
            } else {
                return source;
            }
        }
    }

    /**
     * 替换符号为目标字符串
     */
    public static String StringFilter(String source, String target) {
        // 符号的正则表达式
        final String regex = "[\\pP\\p{Punct}￥ ]";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(source);
        return m.replaceAll(target).trim();
    }


    /**
     * 判断字符串的每个字符是否相等
     *
     * @param str
     * @return
     */
    public static boolean isCharEqual(String str) {
        return str.replace(str.charAt(0), ' ').trim().length() == 0;
    }

    /**
     * 确定字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }


  
    
//    public static void main(String[] args) {
//		System.out.println(firstToUpper("adasda"));
//	}

}
