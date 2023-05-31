package Tests;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        int[] tab = {1, 3, 6, 7, 3, 9};
        System.out.print("Entrer le nombre: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int nombre = scanner.nextInt();
            for (int i = 0; i < tab.length; i++) {
                if (nombre == tab[i]) {
                    System.out.println("oui");
                    return;
                }
            }
        }
        System.out.println("non");
    }
}
