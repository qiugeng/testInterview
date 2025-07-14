package org.example;

/**
 * @author jqg
 * @date 2025/07/14/18:25
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(" #Stage 1 - remove chars requirement");
        String str = "aabcccbbad";
        System.out.println(removeConsecutiveChars(str));
        String str2 = "abcccbad";
        System.out.println(" #Stage 2 - advanced requirement");
        System.out.println(replacedConsecutiveCharsAdvanced(str2));

        System.out.println("优化");
    }

    /**
     * For a given string that only contains alphabet characters a-z, if 3 or more consecutive
     * characters are identical, remove them from the string. Repeat this process until
     * there is no more than 3 identical characters sitting besides each other.
     * Example:
     * Input: aabcccbbad
     * Output:
     * -> aabbbad
     * -> aaad
     * -> d
     */
    public static String removeConsecutiveChars(String input) {
        if (input == null || input.length() < 3) {
            return input;
        }
//        System.out.println(input);
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i) == input.charAt(i + 2)) {
                String returnStr = (input.substring(0, i) + input.substring(i + 3));
                System.out.println("-> : " + returnStr);
                return removeConsecutiveChars(returnStr);
            }
        }
        return null;
    }

    /**
     * #Stage 2 - advanced requirement
     * Instead of removing the consecutively identical characters, replace them with a
     * single character that comes before it alphabetically.
     * Example:
     * ccc -> b
     * bbb -> a
     * Input: abcccbad
     * Output:
     * -> abbbad, ccc is replaced by b
     * -> aaad, bbb is replaced by a
     * -> d
     */

    public static String replacedConsecutiveCharsAdvanced(String input) {
        if (input == null || input.length() < 3) {
            return input;
        }
        for (int i = 0; i < input.length() - 2; i++) {
            if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i) == input.charAt(i + 2)) {
                String replaced = null;
                if ((input.charAt(i) - 1) > 96) {
                    replaced = input.substring(0, i) + (char) (input.charAt(i) - 1) + input.substring(i + 3);
                    System.out.println("->：" + replaced + "， " + input.charAt(i) + input.charAt(i + 1) + input.charAt(i + 2) + " is replaced by " + (char) (input.charAt(i) - 1));
                } else {
                    replaced = input.substring(0, i) + input.substring(i + 3);
                    System.out.println("->：" + replaced);
                }
                return replacedConsecutiveCharsAdvanced(replaced);
            }
        }
        return null;
    }
}