import javax.lang.model.type.NullType;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Bienvenu en enfer!");
        String i = null;
        do {
            Scanner sc = new Scanner(System.in);
            i = sc.next();
            System.out.println("unknow Command");
        }while (!"quit".equals(i));
    }
}
