import java.util.Scanner;

public class Main {
	
	// Added scanner to handle user input
	static Scanner keyboard = new Scanner(System.in);
	
	// Method to convert Roman numeral characters into their respective decimals
	static int convertToInt(char a) {

		switch(a) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			System.out.println("Invalid numeral");
			return 0;		
		}
	}
	
	
	// Method to convert Roman numeral string into decimal
	static int toInt(String numeral) {
		
		// Initialises the sum value to the value of the first character
		int sum = convertToInt(numeral.charAt(0));
		
		// Check for single character numerals to prevent bug
		if(numeral.length() == 1) {
			
			return sum;
			
		}else {
				// Loop over all characters in numeral string
				for (int i = 0; i < numeral.length() - 1; i++) {
					
					// If current numeral is less than next numeral, subtract current value from next value
					if (convertToInt(numeral.charAt(i)) < convertToInt(numeral.charAt(i + 1))) {
						sum = convertToInt(numeral.charAt(i + 1)) - sum;
					
					// If current numeral is greater than or equal to next numeral, add current value to next value
					} else {
						sum = sum + convertToInt(numeral.charAt(i + 1));
					}
				}
		
				return sum;
		}
	}
	

	// Main method
	public static void main(String [] args) {
		
		// Print out list of requested tests
		System.out.println("X in decimal is: " + toInt("X"));
		System.out.println("IX in decimal is: " + toInt("IX"));
		System.out.println("V in decimal is: " + toInt("V"));
		System.out.println("IV in decimal is: " + toInt("IV"));
		System.out.println("MMX in decimal is: " + toInt("MMX"));
		System.out.println("III in decimal is: " + toInt("III"));
		System.out.println("CD in decimal is: " + toInt("CD"));
		
		// Create loop to test additional values
		int i = 0;
		while (i < 3) {
		System.out.println("\nEnter a Roman numeral to test: ");
		String input = (keyboard.next()).toUpperCase();
		System.out.println(input + " in decimal is: " + toInt(input));
		i++;
		}
	}
}
