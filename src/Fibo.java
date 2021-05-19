import java.util.NoSuchElementException;
import java.util.Scanner;

public class Fibo implements Command {
    public String name() {
        return "fibo";
    }

    public Boolean run(Scanner sc) {
        System.out.println("donner nombre");
        int number = 0;
        boolean isNumber = true;
        while (isNumber) {
            try {
                number = sc.nextInt();

            } catch (NoSuchElementException e) {
                System.out.println("pas un nombre");
                continue;
            } finally {
                sc.nextLine();
            }
            isNumber = false;
        }
        System.out.println(fibo(number));
        return false;
    }

    private static int fibo(int n) {
        if (n <= 1) return n;
        else return fibo(n - 1) + fibo(n - 2);
    }
}

