package practise.arr;

import java.util.ArrayList;

/**
 * @Author yjy
 * @Description //TODO
 * @Date 2022/10/29
 **/
public class Main {
    // 1 1 2 3 5 8 13 21
    public static int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int sum = 2;
        for (int i = 2; i < n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fib(9));
    }
}
