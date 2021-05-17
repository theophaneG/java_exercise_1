import java.util.NoSuchElementException;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenu en enfer!");
        String i = null;
        do {
            Scanner sc = new Scanner(System.in);
            i = sc.next();
            if ("fibo".equals(i)) {
                System.out.println("donner nombre");
                int number = 0;
                boolean isNumber = true;
                while (isNumber) {
                    try {
                        number = sc.nextInt();

                    } catch (NoSuchElementException e) {
                        System.out.println("pas un nombre");
                        continue;
                    }finally {
                        sc.nextLine();
                    }
                    isNumber = false;
                }
                System.out.println(i + ": " + fibo(number));
                sc.nextLine();
            } else {
                System.out.println("unknow Command");
            }
        } while ((!"quit".equals(i)));
    }

    private static int fibo(int n) {
        if (n <= 1) return n;
        else return fibo(n - 1) + fibo(n - 2);
    }
}
