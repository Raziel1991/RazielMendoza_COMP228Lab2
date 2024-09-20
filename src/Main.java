import javax.swing.*;
import java.security.SecureRandom;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // create objects
        SecureRandom random = new SecureRandom();
        Test test = new Test();
        Scanner sc = new Scanner(System.in);
        Lotto loto = new Lotto(random);

        //RUN
        System.out.println("Hello World!");
        //test.inputAnswer(random, sc, 5);
        loto.runLotto(sc, random, 5);

        sc.close();
    }
}