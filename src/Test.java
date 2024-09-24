import javax.swing.*;
import java.security.SecureRandom;
import java.util.Scanner;


public class Test {

    private static final String[] Questions = {"What is a Class?",
                                               "What is an Instance of a Class?",
                                               "What is a Static Method?", "Declare a Secure Random Integer",
                                               "What is the difference from Random and Secure Random?"};
    private static final String[] RightAnswers = {"Excellent!", "Good!", "Keep up the good work!", "Nice work!"};
    private static final String[] WrongAnswers = {"No. Please try again", "Wrong. Try once more", "Don't give up!", "No. Keep trying.."};
    private static final String BlockAnswers = "\na).\nb).\nc).\nd).\n";

    private  int correctCounter = 0;
    private  int wrongCounter = 0;

    // method to call into the main class
    public void runTest(SecureRandom rand, int numberOfTimes){
        welcomeStart();
        startTest(numberOfTimes, rand);
        JOptionPane.showMessageDialog(null, "Number of Correct Answers: " + correctCounter +
                "\nNumber of Wrong Answers: " + wrongCounter +
                "\nPercentage accuracy "  + (double) correctCounter/numberOfTimes * 100 + "%");
    }


    // starts the quiz
    private void startTest(int numberOfQuestions, SecureRandom rand){
        String[] options = {" a ", " b ", " c ", " d "};
        for(int i = 0; i < numberOfQuestions; i++){
            int choice = JOptionPane.showOptionDialog(null,
                    simulateQuestion(rand),
                    "Test",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
            JOptionPane.showMessageDialog(null, checkAnswer(choice, rand));
        }
    }

    //Method to simulate the questions
    private static String simulateQuestion(SecureRandom rand){
        return Questions[rand.nextInt(Questions.length)];
    }
    
    //Method to check the answer
    private String checkAnswer(int answer, SecureRandom rand){
        // sets a correct answer into the char variable for comparing it with user input
        int correctAnswers = rand.nextInt(1,4);

        // leaving enhanced and regular switch for a future consultation
        if (answer == correctAnswers){
            this.correctCounter ++;

            //enhanced switch
            return switch (correctAnswers) {
                case 0 -> (RightAnswers[0]);
                case 1 -> (RightAnswers[1]);
                case 2 -> (RightAnswers[2]);
                case 3 -> (RightAnswers[3]);
                // default case will not trigger, although the logic can be simplified by within the if else statement is required for lab evaluation
                default -> "";
            };

        }
        else{
            this.wrongCounter ++;
            //regular switch
            switch (rand.nextInt(RightAnswers.length)) {
                case 0: return(WrongAnswers[0]);
                case 1: return(WrongAnswers[1]);
                case 2: return(WrongAnswers[2]);
                case 3: return(WrongAnswers[3]);
                // default case will not trigger, although the logic can be simplified by within the if else statement is required for lab evaluation
                default: return"";
            }

        }

    }

    //Welcome Pane logic. Handles options from the first window.
    private static void welcomeStart(){
        int choiceWelcome;
        choiceWelcome = JOptionPane.showConfirmDialog(null,"This will start the test", "My test",JOptionPane.YES_NO_CANCEL_OPTION);
        switch(choiceWelcome){
            case JOptionPane.YES_OPTION:
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null,"Good Bye");
                System.exit(0);
                break;
            case JOptionPane.CLOSED_OPTION:
                System.exit(0);
                break;
            case JOptionPane.CANCEL_OPTION:
                System.exit(0);
                break;
        }
    }



    //Created the getters to test the code before completing the assignment
    public static String getBlockAnswers() {
        return BlockAnswers;
    }


    public static String[] getQuestions() {
        return Questions;
    }

    public static String[] getRightAnswers() {
        return RightAnswers;
    }

    public static String[] getWrongAnswers() {
        return WrongAnswers;
    }


}
