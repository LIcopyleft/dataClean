package com.drcnet.mc.bigdata.bmap.Utils;

public class CheckPasswdUtils {

    /**
     * NUM 数字
     * SMALL_LETTER 小写字母
     * CAPITAL_LETTER 大写字母
     * OTHER_CHAR  特殊字符
     */
    private static final int NUM = 1;
    private static final int SMALL_LETTER = 2;
    private static final int CAPITAL_LETTER = 3;
    private static final int OTHER_CHAR = 4;

    /**
     * 简单的密码字典
     */
    private final static String[] DICTIONARY = {"password", "abc123", "iloveyou", "adobe123", "123123", "sunshine",
            "1314520", "a1b2c3", "123qwe", "aaa111", "qweasd", "admin", "passwd"};

    /**
     * 检查字符类型，包括num、大写字母、小写字母和其他字符。
     *
     * @param c
     * @return
     */
    private static int checkCharacterType(char c) {
        if (c >= 48 && c <= 57) {
            return NUM;
        }
        if (c >= 65 && c <= 90) {
            return CAPITAL_LETTER;
        }
        if (c >= 97 && c <= 122) {
            return SMALL_LETTER;
        }
        return OTHER_CHAR;
    }

    /**
     * 按不同类型计算密码的数量
     *
     * @param passwd
     * @param type
     * @return
     */
    private static int countLetter(String passwd, int type) {
        int count = 0;
        if (null != passwd && passwd.length() > 0) {
            for (char c : passwd.toCharArray()) {
                if (checkCharacterType(c) == type) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 检查密码的强度
     *
     * @param passwd
     * @return strength level
     */
    public static int checkPasswordStrength(String passwd) throws Exception {

        int len = passwd.length();
        int level = 0;

        // 增加点
        //判断密码是否含有数字有level++
        if (len >= 6 && countLetter(passwd, NUM) > 0) {
            level++;
        }
        //判断密码是否含有小写字母有level++
        if (len >= 6 && countLetter(passwd, SMALL_LETTER) > 0) {
            level++;
        }

        //判断密码是否还有大写字母有level++
        if (len >= 6 && countLetter(passwd, CAPITAL_LETTER) > 0) {
            level++;
        }


        if (len >= 6 && countLetter(passwd, CAPITAL_LETTER) > 0 && countLetter(passwd, SMALL_LETTER) > 0) {
            level++;
        }
        if (len >= 6 && countLetter(passwd, NUM) > 0 && countLetter(passwd, SMALL_LETTER) > 0) {
            level++;
        }
        //密码长度大于8并且4种类型组合......（不一一概述）
        if (len > 8 && countLetter(passwd, NUM) > 0 && countLetter(passwd, SMALL_LETTER) > 0
                && countLetter(passwd, CAPITAL_LETTER) > 0 && countLetter(passwd, OTHER_CHAR) > 0) {
            level++;
        }
        //密码长度大于6并且2种类型组合每种类型长度大于等于3或者2......（不一一概述）
        if (len > 12 && countLetter(passwd, NUM) >= 3 && countLetter(passwd, SMALL_LETTER) >= 3
                || countLetter(passwd, NUM) >= 3 && countLetter(passwd, CAPITAL_LETTER) >= 3
                || countLetter(passwd, SMALL_LETTER) >= 3 && countLetter(passwd, CAPITAL_LETTER) >= 3
                ) {
            level++;
        }
        //密码长度大于8并且3种类型组合每种类型长度大于等于3或者2......（不一一概述）
        if (len > 12 && countLetter(passwd, NUM) >= 2 && countLetter(passwd, SMALL_LETTER) >= 2 && countLetter(passwd, CAPITAL_LETTER) >= 2 || countLetter(passwd, NUM) >= 2
                && countLetter(passwd, SMALL_LETTER) >= 2
                || countLetter(passwd, NUM) >= 2 && countLetter(passwd, CAPITAL_LETTER) >= 2
                || countLetter(passwd, SMALL_LETTER) >= 2 && countLetter(passwd, CAPITAL_LETTER) >= 2 ) {
            level++;
        }
        //密码长度大于10并且4种类型组合每种类型长度大于等于2......（不一一概述）
        if (len > 12 && countLetter(passwd, NUM) >= 2 && countLetter(passwd, SMALL_LETTER) >= 2
                && countLetter(passwd, CAPITAL_LETTER) >= 2 ) {
            level++;
        }


        //长度>12 >16 level++
        if (len > 13) {
            level++;
            if (len == 16) {
                level++;
            }
        }

        // 减少点
        if ("abcdefghijklmnopqrstuvwxyz".indexOf(passwd) > 0 || "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(passwd) > 0) {
            level--;
        }
        if ("qwertyuiop".indexOf(passwd) > 0 || "asdfghjkl".indexOf(passwd) > 0 || "zxcvbnm".indexOf(passwd) > 0) {
            level--;
        }
        if (StringUtils.isNumeric(passwd) && ("01234567890".indexOf(passwd) > 0 || "09876543210".indexOf(passwd) > 0)) {
            level--;
        }

        if (countLetter(passwd, NUM) == len || countLetter(passwd, SMALL_LETTER) == len
                || countLetter(passwd, CAPITAL_LETTER) == len) {
            level--;
        }

        if (len % 2 == 0) { // aaabbb
            String part1 = passwd.substring(0, len / 2);
            String part2 = passwd.substring(len / 2);
            if (part1.equals(part2)) {
                level--;
            }
            if (StringUtils.isCharEqual(part1) && StringUtils.isCharEqual(part2)) {
                level--;
            }
        }
        if (len % 3 == 0) { // ababab
            String part1 = passwd.substring(0, len / 3);
            String part2 = passwd.substring(len / 3, len / 3 * 2);
            String part3 = passwd.substring(len / 3 * 2);
            if (part1.equals(part2) && part2.equals(part3)) {
                level--;
            }
        }


        if (null != DICTIONARY && DICTIONARY.length > 0) {// dictionary
            for (int i = 0; i < DICTIONARY.length; i++) {
                if (passwd.equals(DICTIONARY[i]) || DICTIONARY[i].indexOf(passwd) >= 0) {
                    level--;
                    break;
                }
            }
        }

        if (len <= 8) {
            level--;
            if (len <= 7) {
                level--;
                /*if (len <= 6) {
                    level = 0;
                }*/
            }
        }

        if (StringUtils.isCharEqual(passwd)) {
            level = 0;
        }

        if (level < 0) {
            level = 0;
        }

        return level;
    }

    /**
     * 校验密码格式 是否为6-16位字母和数字组合
     */
    public static boolean checkPass(String passwd) {
        // 符号的正则表达式
        final String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$";

        return passwd.matches(regex);
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

}
