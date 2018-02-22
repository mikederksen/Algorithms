package Algorithms;

public class Som {

    public static int calcRec(int n) {
        if (n <= 0)
            return 0;

        return n + calcRec(n - 1);
    }

    public static int calcLoop(int n) {
        if (n <= 0)
            return 0;

        int total = 0;

        for (int i = 1; i <= n; i++) {
            total += i;
        }

        return total;
    }
}
