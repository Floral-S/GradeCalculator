//Import scanner to receive information from user and decimal format to control 
//appearance of numbers stored.

import java.text.DecimalFormat;
import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {

		// Initialize keyboard
		Scanner keyboard = new Scanner(System.in);

		// Print grading scales
		System.out.println("Grading Scale:");
		System.out.println("A\t90 - 100");
		System.out.println("B\t80 - 89");
		System.out.println("C\t70 - 79");
		System.out.println("D\t60 - 69");
		System.out.println("F\tbelow 60");

		// Initialize and store input from user for the desired grade
		String targetLetter;
		System.out.print("What letter grade do you want to achieve for the course?");
		targetLetter = keyboard.next().toUpperCase();

		// Use an array to save % weights for each type of assignment
		int weight[] = new int[7];
		System.out.print("Enter percentage weights below. \n");
		System.out.print("Exam 1:\t\t");
		weight[0] = keyboard.nextInt();
		System.out.print("Exam 2:\t\t");
		weight[1] = keyboard.nextInt();
		System.out.print("Final Exam:\t");
		weight[2] = keyboard.nextInt();
		System.out.print("Labs:\t\t");
		weight[3] = keyboard.nextInt();
		System.out.print("Projects:\t");
		weight[4] = keyboard.nextInt();
		System.out.print("Participation:\t");
		weight[5] = keyboard.nextInt();
		System.out.print("Quizzes:\t");
		weight[6] = keyboard.nextInt();

		// Use for and if - else to check that the total known grade weight = 100.
		// If not, print an error message informing user of the problem and exit
		// program.
		int weightSum = 0;
		for (int i = 0; i < 7; i++)
			weightSum += weight[i];
		if (weightSum != 100) {
			System.out.print("Weights don't add up to 100, program exiting...");
			System.exit(0);
		}

		// Use another array for scores
		int score[] = { 0, 0, 0, 0, 0, 0, 0 };
		int score_available[] = { 0, 0, 0, 0, 0, 0, 0 };

		// Receive input from user as to what scores they know and if they know
		// their exam 1 score.
		String response;
		System.out.print("Do you know your exam 1 score?");
		response = keyboard.next();

		// Ignore case and allow for Yes or Y, store data and note that
		// a score is available.
		if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")) {
			System.out.print("Score received on exam 1:");
			score[0] = keyboard.nextInt();
			score_available[0] = 1;

			// Follow the same process to ask if user has exam 2 (ignore case)
			// get score, store data.
			System.out.print("Do you know your exam 2 score?");
			response = keyboard.next();
			if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")) {
				System.out.print("Score received on exam 2:");
				score[1] = keyboard.nextInt();
				score_available[1] = 1;

				// Follow the same process to ask if user has final exam (ignore case)
				// get score, store data.
				System.out.print("Do you know your final exam score?");
				response = keyboard.next();
				if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")) {
					System.out.print("Score received on final exam:");
					score[2] = keyboard.nextInt();
					score_available[2] = 1;
				}

			}
		}

		// Follow the same process to ask if user has lab average (ignore case)
		// get score, store data.
		System.out.print("Do you know your lab average?");
		response = keyboard.next();
		if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")) {
			System.out.print("Average lab grade:");
			score[3] = keyboard.nextInt();
			score_available[3] = 1;
		}

		// Follow the same process to ask if user has project average (ignore case)
		// get score, store data.
		System.out.print("Do you know your project average?");
		response = keyboard.next();
		if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")) {
			System.out.print("Average project grade:");
			score[4] = keyboard.nextInt();
			score_available[4] = 1;
		}

		// Follow the same process to ask if user has participation average (ignore
		// case)
		// get score, store data.
		System.out.print("Do you know your participation average?");
		response = keyboard.next();
		if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")) {
			System.out.print("Average participation grade:");
			score[5] = keyboard.nextInt();
			score_available[5] = 1;
		}

		// Follow the same process to ask if user has quiz average (ignore case)
		// get score, store data.
		System.out.print("Do you know your quiz average?");
		response = keyboard.next();
		if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")) {
			System.out.print("Average quiz grade:");
			score[6] = keyboard.nextInt();
			score_available[6] = 1;
		}

		// set weight score product and total known weight to 0.
		int weightScoreProduct = 0;
		int totalKnownWeights = 0;
		// Calculate weight score product and total known weights.
		for (int i = 0; i < 7; i++) {
			weightScoreProduct += score_available[i] * score[i] * weight[i];
			totalKnownWeights += score_available[i] * weight[i];
		}

		// Set final overall score to 0.
		int finalOverallScore = 0;
		// Initialize and calculate current score from weight score product and total
		// known weights.
		double currentScore = (double) (weightScoreProduct + 0.0) / totalKnownWeights;
		// Define decimal format to show the correct decimal value when printing
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.print("Current Grade Score:" + df.format(currentScore));
		String letterGrade = " ";
		// Take floor of current score
		currentScore = Math.floor(currentScore);

		// Assign A based on grade scale if current score is within range
		if (currentScore >= 90 && currentScore <= 100) {
			letterGrade = "A";
			finalOverallScore = 90;
		}

		// Use else if to assign B based on grade scale if current score is within range
		else if (currentScore >= 80 && currentScore <= 89) {
			letterGrade = "B";
			finalOverallScore = 80;
		}

		// Use else if to assign C based on grade scale if current score is within range
		else if (currentScore >= 70 && currentScore <= 79) {
			letterGrade = "C";
			finalOverallScore = 70;
		}

		// Use else if to assign D based on grade scale if current score is within range
		else if (currentScore >= 60 && currentScore <= 69) {
			letterGrade = "D";
			finalOverallScore = 60;
		}

		// Use else if to assign F based on grade scale if current score is within range
		else if (currentScore < 60) {
			letterGrade = "F";
			finalOverallScore = 0;
		}

		// Print current grade, let user know if they received the score they want
		System.out.print("\nYour current letter grade:" + letterGrade);
		if (letterGrade.equalsIgnoreCase(targetLetter))
			System.out.print("\nCongratulations! You received the " + targetLetter + " that you wanted!");

		// Otherwise, calculate what average they will need to score to achieve target
		// letter grade
		// if possible.
		else {
			if (totalKnownWeights < 100) {
				double avgToFinalLetterGrade = (100 * finalOverallScore - weightScoreProduct)
						/ (100 - totalKnownWeights);
		
				System.out.print("\nIn order to receive a score of " + targetLetter + "," +
						"\nyou need to score an average greater than"
						+ "\nor equal to " + avgToFinalLetterGrade + " in the rest of the grade items.");

				// Otherwise, tell user it is not possible to achieve the letter grade they want
				// :(
			} else {
				System.out.print("\nUnfortunately, a grade of " + targetLetter + " is not possible");

				// Program has finished running, close keyboard.
				keyboard.close();
			}

		}

	}

}