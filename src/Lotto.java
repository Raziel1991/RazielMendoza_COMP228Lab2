import javax.swing.*;
import java.security.SecureRandom;

public class Lotto {
    //Design a Lotto class with one array instance variable to hold three random integer values (from 1 to 9)
    private int[] numbers;

    //Include a constructor that randomly populates the array for a lotto object.
    public Lotto(SecureRandom random) {
        setLotto(random);
    }
    //Also, include a method in the class to return the array.
    public int[] getNumbersArray(){
        return numbers;
    }

    // runs the logic of the game
    public void runLotto(SecureRandom random, int maxRolls) {
        String userInput;
        int userNumber = 0;
        int lottoPayout;
        int minNumber = 3;
        int maxNumber = 27;
        //Setting user input ----  try and catch in case user inputs a non integer
        while (userNumber < minNumber || userNumber > maxNumber){
            userInput = JOptionPane.showInputDialog(null, "Enter a Number between " + minNumber + " and " + maxNumber);
            try {
                userNumber = Integer.parseInt(userInput);
            }catch(NumberFormatException e){
                userNumber = 0;
            }
        }

        // run lotto
        for (int i = 0; i < maxRolls; i++) {
            lottoPayout = 0;

            //Calculate the sum of lotto numbers
            for (int j = 0; j < numbers.length; j++) {
                lottoPayout += numbers[j];
            }
            // main screen message
            String lottoMessage = "Your selected number is: " + userNumber + "\n"+
                    "Lotto Numbers: " + numbers[0] + " | " + numbers[1] + " | " + numbers[2] + "\n" +
                    "Payout number: " + lottoPayout;

            //Decides winning message or do a new lotto.
            if (userNumber == lottoPayout) {
                JOptionPane.showMessageDialog(null, lottoMessage + "\nCongrats!! you won");
                // you win no need to do more loops
                break;
            }
            else {
                JOptionPane.showMessageDialog(null, lottoMessage + "\nSorry try again!!");
                // sets new random numbers to win
                setLotto(random);
            }
        }
    }

    //sets the winning numbers
    public void setLotto(SecureRandom random) {
        numbers = new int[]{random.nextInt(1,10), random.nextInt(1,10), random.nextInt(1,10)};
    }
}
