/*
 * Programmer: Rahul Sharma
 * Date: 07/16/16
 * Description: This program guesses the number that the user has thought of in their head in an efficient way. 
 * The program starts of by asking the user to think of a number in their head and then prompts for a "ready" 
 * value to start. From that point, the program attempts to guess the number that the user has in his/her head. 
 * A number is shown a number on the screen and then the user is asked to enter "yes","end","lower" or "higher."
 * The "yes" or "end" indicate that the correct number is displayed on the screen. The "higher" means that the 
 * value that the user had in mind is higher than the number that is displayed. The "lower" means that the value that the 
 * user had in mind is lower than what is displayed.
 */


//DEVELOPMENT TEST
//I LOVE DEVELOPMENT
import javax.swing.JOptionPane;
public class Exercise {

public static void main(String[] args) {
	final int RANGE_MIN = 0;
	final int RANGE_MAX = 1001;
	//calls the method askIfReady with the RANGE_MIN and RANGE_MAX parameters
	String isReady = askIfReady(RANGE_MIN, RANGE_MAX);
	//if the value in isReady is "ready," the guessNum method is called with the RANGE_MIN and RANGE_MAX parameters
	if(isReady.equalsIgnoreCase("ready")){
		guessNum(RANGE_MIN, RANGE_MAX);
	}
}

/*
 * METHOD NAME: askIfReady
 * PARAMETERS: (int) rangeMin, (int) rangeMax
 * RETURN VALUE: (String) response
 * PURPOSE: Prompts the user for a string value to see if they are ready to play the game
 */
private static String askIfReady(int rangeMin, int rangeMax) {
	String response = "";
	do{
		response = JOptionPane.showInputDialog(null, "Think of number between the range of "+ rangeMin + " and " +rangeMax +" in your head!!!\nPlease enter ready if you would like to play");
		if(response.equals("")){
			JOptionPane.showMessageDialog(null, "The Input can't be empty!!! Please enter a valid value");
		}
	}while(response.equals(""));
	return response;
}

/*
 * METHOD NAME: guessNum
 * PARAMETERS: (int) min, (int) max
 * RETURN VALUE: (void) none
 * PURPOSE: Attempts to guess the number and asks for string values such as "yes", "end", "lower" and "higher" to 
 * make decisions to guess the number.
 */
private static void guessNum(int min,int max) {
	String responseToGuess ="";
	int guessNum = 0;
	//the user is asked for a response till he/she enters "yes" or "end"
	do
    {
		//passes min and max values to makeGuess method and the value returned is stored in guessNum
		guessNum = makeGuess(min, max);
		responseToGuess = JOptionPane.showInputDialog(null, "Is the number " + guessNum+  "?\n"
				+ "If this is your number type: 'yes' or 'end'\n"
				+ "If your number is lower than this number type: 'lower'\n"
				+ "If your number is higher than this number type: 'higher'");
		//if the response is lower, the guessNum is assigned as the max value
		if(responseToGuess.equalsIgnoreCase("lower")){
			max = guessNum;
		}
		//if the response is higher, the min guessNum is assigned as the max value
		if(responseToGuess.equalsIgnoreCase("higher")){
			min = guessNum;
		}
    } while(!(responseToGuess.equalsIgnoreCase("yes") || responseToGuess.equalsIgnoreCase("end")));        
}

/*
 * METHOD NAME: makeGuess
 * PARAMETERS: (int) min, (int) max
 * RETURN VALUE: (int) guess
 * PURPOSE: Uses the values min and max to determine the guess values. It takes the min and max value and adds it together. 
 * Then it divides that value by 2 and rounds up the number and returns it. 
 */
private static int makeGuess(int min, int max) {
	final int DIVISOR = 2;
	int guess = (int) Math.ceil((min + max)/DIVISOR);
	return guess;
}
}
