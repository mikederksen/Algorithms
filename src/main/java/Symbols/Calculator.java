package Symbols;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) {
        Balance p;

        if (args.length == 0) {
            p = new Balance(new InputStreamReader(System.in));

            System.out.println("Now calculating...");

            if (p.checkBalance() == 0) {
                System.out.println("No errors!");

                return;
            } else {
                System.out.println("Kapoet");
            }
        }

        for (String arg : args) {
            FileReader f = null;

            try {
                f = new FileReader(arg);

                System.out.println(arg + ": ");
                p = new Balance(f);

                if (p.checkBalance() == 0) {
                    System.out.println("No errors!");
                }
            } catch (IOException e) {
                System.err.println(e + arg);
            } finally {
                try {
                    if (f != null) {
                        f.close();
                    }
                } catch (IOException e) {
                    // Swallow
                }
            }
        }
    }
}
