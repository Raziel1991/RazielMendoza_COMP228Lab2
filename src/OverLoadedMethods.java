import javax.swing.*;

public class OverLoadedMethods {
    public static void displayNumbers(String[] myString){
        String displayString = "";
        for(int i = 0; i < myString.length; i++){
            displayString += myString[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, displayString);
    }
    public static void displayNumbers(int[] myInt){
        String displayString = "";
        for(int i = 0; i < myInt.length; i++){
            displayString += myInt[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, displayString);
    }
    public static void displayNumbers(double[] myLong){
        String displayString = "";
        for(int i = 0; i < myLong.length; i++){
            displayString += myLong[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, displayString);
    }
}
