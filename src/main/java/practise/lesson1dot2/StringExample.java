package practise.lesson1dot2;

/**
 * @author : YeJunyu
 * @description :
 * @email : yyyejunyu@gmail.com
 * @date : 2022/4/13
 */
public class StringExample {

    public static boolean isPalindromic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        String s3 = str2 + str2;
        int j = str2.indexOf(str1.charAt(0));
        if (j == -1) {
            return false;
        }
        for (int i = 1, size = str1.length(); i < size; i++) {
            if (str1.charAt(i) != s3.charAt(i + size - j)) {
                return false;
            }
        }
        return true;
    }

    public static String mystery(String s) {
        int n = s.length();
        if (n <= 1) return s;
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2, n);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        String s1 = "actgacg";
        String s2 = "tgacgac";
        String s3 = "abcd";
        System.out.println(isPalindromic(s1, s2));
        System.out.println(mystery(s3));
    }
}
