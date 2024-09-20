import java.security.SecureRandom;
import java.util.Scanner;

public class Lotto {
    //Design a Lotto class with one array instance variable to hold three random integer values (from 1 to 9)
    private static int[] numbers;

    //Include a constructor that randomly populates the array for a lotto object.
    public Lotto(SecureRandom random) {
        setLotto(random);
    }

    //Also, include a method in the class to return the array.
    public int[] getNumbersArray(){
        return numbers;
    }

    public void runLotto(Scanner scanner,SecureRandom random, int maxRolls) {
        int counter = 0;
        //input and screenstuff 1 time
        // TODO:change it to JOptionPane
        System.out.println("Enter a Number between 3 and 27");
        int userNumber = scanner.nextInt();
        int lottoPayout;
        // run lotto
        for (int i = 0; i < maxRolls; i++) {
            lottoPayout = 0;

            //Calculate the sum of lotto numbers
            for (int j = 0; j < numbers.length; j++) {
                lottoPayout += numbers[j];
            }

            if (userNumber == lottoPayout) {
                printLottoNumbers(numbers, lottoPayout, userNumber);
                System.out.println("Congrats!! you won to number: " + lottoPayout);
                break;
            }
            else {
                printLottoNumbers(numbers, lottoPayout, userNumber);
                System.out.println("Sorry try again!!");
                setLotto(random);
            }
        }
    }

    //sets the winning numbers
    public static void setLotto(SecureRandom random) {
        numbers = new int[]{random.nextInt(1,9), random.nextInt(1,9), random.nextInt(1,9)};
    }

    public static void printLottoNumbers(int[] numbers, int winningLotto, int choiceNumber) {
        System.out.println("Running Lotto!! to player number: " + choiceNumber);
        System.out.println("First number: " + numbers[0] + " | Second number: " + numbers[1] + " | Third number: " + numbers[2] + " | Winning lotto: " + winningLotto);
    }

}
