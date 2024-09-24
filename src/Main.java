
import java.security.SecureRandom;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};
        double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        String[] stringArray = {"one", "two", "three", "four", "five"};

        // create objects
        SecureRandom random = new SecureRandom();
        Test test = new Test();
        Lotto mylotto = new Lotto(random);

        //RUN
        //Exercise 1
        test.runTest(random, 5);

//        //Exercise 2
//        mylotto.runLotto(random, 5);
//        sc.close();
//
//        //Exercise 3
//        OverLoadedMethods.displayNumbers(intArray);
//        OverLoadedMethods.displayNumbers(doubleArray);
//        OverLoadedMethods.displayNumbers(stringArray);
    }
}