import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        int dice1,//The first dice rolled
                dice2,//The second dice rolled
                roll = 0,//The sum of the two dice rolled
                point = 0,//A point awarded
                checkIfPlayAgain;//user's input to see whether they want to continue the game
        boolean stop = true,//If this is false the game stops
                howManyRoll = true,//use to check if the player rolled once
                checkPlayAgain = true,//use to check if the player wants to end the program
                exitOption = true;//use to check the user's option
        String result;//message if the player wins, lose or the point is awarded

        //Loop while the player wants to play the game
        while (checkPlayAgain) {
            //loop while the player wins or lose
            do {
                dice1 = (int) (Math.random() * 6) + 1;//generate random integer between 1 to 6 and assign the number to the Dice 1
                dice2 = (int) (Math.random() * 6) + 1;//generate random integer between 1 to 6 and assign the number to the Dice 2
                roll = dice1 + dice2;//Get the sum of the dice rolled

                //check if the player is playing for the first time
                if (howManyRoll) {
                    point = roll;//The sum of the dice the user rolled become their next point if they don't win or lose//
                /*If the user rolled the dice and the sum is 2,3, or 12 the result is going to "lose" and if the sum is 7or 11 its going to
                be a win otherwise the result will tell the user their point*/
                    result = (roll == 2 || roll == 3 || roll == 12) ? "You lose!" : ((roll == 7 || roll == 11) ? "You win" : "Your points are: " + point);
                    /*If the user rolled the dice and the sum is 2,3, or 12 the stop becomes false  7or 11 its going to
                be a win otherwise the result will tell the user their point*/
                    stop = (roll == 2 || roll == 3 || roll == 12) ? false : ((roll == 7 || roll == 11) ? false : true);
                    howManyRoll = false;//Indicates that the user already rolled a dice
                } else {
                /* If the user rolled 7 the result will become "You lose" and if the sum of the roll is same as the
                previous point the result is going to be "You Win", otherwise the result will store the user's next point
                 */
                    result = (roll == 7) ? "You lose" : ((roll == point) ? "You win" : "Your points are: " + roll);
                    stop = (roll == 7) ? false : ((roll == point) ? false : true);
                }
                System.out.println("You rolled " + dice1 + " + " + dice2 + " = " + roll + "\n" + result);//print out the result//
                point = roll;//set the new point
            }
            while (stop);
            //Asks the user if they want to end the game

            System.out.println("Input 1 if you want to exit the game! Otherwise input anything except 1");
            Scanner input = new Scanner(System.in);//Create Scanner

            while (exitOption) {
                try {
                    //Check if the input is an integer
                    if (input.hasNextInt()) {
                        checkIfPlayAgain = input.nextInt();//stores user's input
                        exitOption = false;
                        //Check if the input is equal to 1
                        if (checkIfPlayAgain == 1)
                            checkPlayAgain = false;//End the game
                        else
                            howManyRoll = true;
                    } else
                        throw new RuntimeException();//
                } catch (Throwable exception) {
                    System.out.println("Invalid Input!");//Print out "Invalid Input"
                    input = new Scanner(System.in);//The user inputs again
                }
            }
            exitOption = true;
        }
    }
}
