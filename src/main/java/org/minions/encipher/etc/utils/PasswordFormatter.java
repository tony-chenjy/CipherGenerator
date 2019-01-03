package org.minions.encipher.etc.utils;

public class PasswordFormatter {

    // 格式：
    // 0 - 默认：2；
    // 1 - 数字；
    // 2 - 数字 + 小写字母；
    // 3 - 数字 + 大写字母；
    // 4 - 数字 + 小写字母 + 大写字母；
    // 5 - 小写字母；
    // 6 - 大写字母；
    // 7 - 小写字母 + 大写字母；
    // 8 - 带特殊字符；
    public static final short FORMAT_DEFAULT = 0;
    public static final short FORMAT_DIGIT = 1;
    public static final short FORMAT_DIGIT_LOWER = 2;
    public static final short FORMAT_DIGIT_UPPER = 3;
    public static final short FORMAT_DIGIT_LETTER = 4;
    public static final short FORMAT_LETTER_LOWER = 5;
    public static final short FORMAT_LETTER_UPPER = 6;
    public static final short FORMAT_LETTER = 7;
    public static final short FORMAT_SPECIAL = 8;

    // 密码格式化
    public static String format(short format, String password, int maxLength) {
        String result = null;
        switch (format) {
            case FORMAT_DEFAULT:
                result = getDefault(password, maxLength);
                break;
            case FORMAT_DIGIT:
                result = getDigit(password, maxLength);
                break;
            case FORMAT_DIGIT_LOWER:
                result = getDigitLower(password, maxLength);
                break;
            case FORMAT_DIGIT_UPPER:
                result = getDigitUpper(password, maxLength);
                break;
            case FORMAT_DIGIT_LETTER:
                result = getDigitLetter(password, maxLength);
                break;
            case FORMAT_LETTER_LOWER:
                result = getLetterLower(password, maxLength);
                break;
            case FORMAT_LETTER_UPPER:
                result = getLetterUpper(password, maxLength);
                break;
            case FORMAT_LETTER:
                result = getLetter(password, maxLength);
                break;
            case FORMAT_SPECIAL:
                result = getSpecial(password, maxLength);
                break;
            default:
                result = getDefault(password, maxLength);
                break;
        }
        return result;
    }

    // 默认：2
    private static String getDefault(String str, int maxLength) {
        return getDigitLower(str, maxLength);
    }

    // 数字
    private static String getDigit(String str, int maxLength) {
        StringBuilder sb = new StringBuilder(maxLength);

        int i = 0;
        while (sb.length() < maxLength && i < str.length()) {
            while (i < str.length() && !Character.isDigit(str.charAt(i))) {
                i++;
            }
            sb.append(str.charAt(i++));
        }
        return sb.toString();
    }

    // 数字 + 小写字母；
    private static String getDigitLower(String str, int maxLength) {
        return getDigitLetter(str.toLowerCase(), maxLength);
    }

    // 数字 + 大写字母；
    private static String getDigitUpper(String str, int maxLength) {
        return getDigitLetter(str.toUpperCase(), maxLength);
    }

    // 数字 + 小写字母 + 大写字母；
    private static String getDigitLetter(String str, int maxLength) {
        StringBuilder sb = new StringBuilder(maxLength);

        int i = 0;
        while (sb.length() < maxLength && i < str.length()) {
            while (i < str.length() && !Character.isLetterOrDigit(str.charAt(i))) {
                i++;
            }
            sb.append(str.charAt(i++));
        }
        return sb.toString();
    }

    // 小写字母；
    private static String getLetterLower(String str, int maxLength) {
        return getLetter(str.toLowerCase(), maxLength);
    }

    // 大写字母；
    private static String getLetterUpper(String str, int maxLength) {
        return getLetter(str.toUpperCase(), maxLength);
    }

    // 小写字母 + 大写字母；
    private static String getLetter(String str, int maxLength) {
        StringBuilder sb = new StringBuilder(maxLength);

        int i = 0;
        while (sb.length() < maxLength && i < str.length()) {
            while (i < str.length() && !Character.isLetter(str.charAt(i))) {
                i++;
            }
            sb.append(str.charAt(i++));
        }
        return sb.toString();
    }

    // 带特殊字符
    private static String getSpecial(String str, int maxLength) {
        if (maxLength > str.length()) {
            return str;
        }
        return str.substring(0, maxLength);
    }
}
