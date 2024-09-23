import javax.swing.*;
import java.security.SecureRandom;
import java.util.Scanner;


public class Test {
    private static final char[] CorrectAnswers = {'a', 'b', 'c', 'd'};
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
    public void inputAnswer(SecureRandom rand, Scanner sc, int numberOfTimes){
        StringBuilder allTextToPane = new StringBuilder();
        for(int i = 0; i < Questions.length; i++){
            allTextToPane.append(Questions[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, allTextToPane.toString());

        for(int i = 0; i < numberOfTimes; i++){
            simulateQuestion(rand);
            //System.out.println("Type Answer: ");


            char answer = sc.next().charAt(0);
            //TODO : check if the type in char is in the array of CorrectAnswers // todo: make the check a method
            System.out.println(checkAnswer(answer, rand));
            System.out.println("-------------------");
            System.out.println();
        }
        //one time
        System.out.println("Number of Correct Answers: " + correctCounter);
        System.out.println("Number of Wrong Answers: " + wrongCounter);
        System.out.println("Percentage accuracy "  + (double) correctCounter/numberOfTimes * 100 + "%");
    }

    //Method to simulate the questions
    public static void simulateQuestion(SecureRandom rand){
        System.out.println(Questions[rand.nextInt(Questions.length)] + BlockAnswers);
    }



    //Method to check the answer
    public String checkAnswer(char answer, SecureRandom rand){
        // sets a correct answer into the char variable for comparing it with user input
        char correctAnswers = CorrectAnswers[rand.nextInt(CorrectAnswers.length)];

        // leaving enhanced and regular switch for a future consultation
        if (answer == correctAnswers){
            this.correctCounter ++;

            //enhanced switch
            return switch (rand.nextInt(CorrectAnswers.length)) {
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


    //Created the getters to test the code before completing the assignment
    public static String getBlockAnswers() {
        return BlockAnswers;
    }
    public static char[] getCorrectAnswers() {
        return CorrectAnswers;
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
