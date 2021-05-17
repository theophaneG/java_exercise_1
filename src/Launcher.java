import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenu en enfer!");
        String i = null;
        Scanner sc = new Scanner(System.in);
        i = sc.next();
        if ((!"quit".equals(i))) {
        } else {
            System.out.println("unknow Command");
        }
    }
}
