import java.util.Random;
import javax.swing.JOptionPane;

 class Lotto
 {
     // Creating int array with a maximum of three values
    int[] threeValues = new int[3];

    private void populateArray()
    {
        Random random = new Random();

        for(int i = 0; i < threeValues.length; i++)
        {
            // Without the +1 there will be zeroes added to the random number pool
            threeValues[i] = 1 + random.nextInt(9);
        }
    }
    // Method to return array
     public int[] returnThreeValues()
     {
         // Need to populate array otherwise it's all 0s
         populateArray();
         return threeValues;
     }

    public static void main(String[] args)
    {
        Lotto lotto = new Lotto();

        // Creating int array called values that uses the returnThreeValues method
        int[] values = lotto.returnThreeValues();
        int sum = 0;
        int tries = 5;

        // This text is outside of loop otherwise it will repeat
        System.out.print("Here are the three randomly chosen numbers: ");
        for (int i = 0; i < values.length; i++)
        {
            // This outputs the numbers that are randomly chosen and their combined sum
            System.out.print(values[i]);
            sum += values[i];
        }
        // Only having this output to terminal to check if logic is working
        System.out.println();
        System.out.print(sum);

        int winningNumber = lottoNumberChosen();

        while(tries > 0) {

            if (winningNumber == sum) {
                JOptionPane.showMessageDialog(null, "Congratulations you won the lottery!");
                return;
                // Need to return otherwise it will loop
            } else {
                JOptionPane.showMessageDialog(null, "Try Again, number of tries left is: " + (tries - 1));
                tries--;

                if(tries > 0)
                {
                    // This is the only way I can make the program continue if the user is incorrect...
                    winningNumber = lottoNumberChosen();
                }

                if(tries == 0)
                {
                    JOptionPane.showMessageDialog(null, "Sorry you have lost! :( Please try again!");
                }
            }
        }
    }

    public static int lottoNumberChosen()
    {
        int lottoNumber = 0;

        for (int i = 0; i < 5; i++)
        {
            String input = JOptionPane.showInputDialog("Please enter a lotto number between 3 and 27: ");
            lottoNumber = Integer.parseInt(input);

            if (lottoNumber >=3 && lottoNumber <= 27)
            {
                return lottoNumber;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "The number chosen is out of the given range for the lottery!");
            }
        }
        // Returning the lottoNumber integer
        return lottoNumber;
    }
}
