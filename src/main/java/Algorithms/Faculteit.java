package Algorithms;

public class Faculteit {

    public static int CalcRec(int n) {
        if(n <= 1)
            return 1;

        return n * CalcRec(n - 1);
    }

    public static int CalcLoop(int n) {
        int total = 1;

        for(int i = n; i > 0; i--) {
            total = total * i;
        }

        return total;
    }
}
