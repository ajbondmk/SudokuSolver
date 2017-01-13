import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SolveAll {

	public static void main(String[] args) {
		try {
			BufferedReader b = new BufferedReader(new FileReader("src/HardPuzzles.txt"));
			String line = b.readLine();
			int solvedCount = 0;
			int failedCount = 0;
			int maxGuesses = 0;
			int hardest = 0;
			while (line != null) {
				/*String puzzle = "";
				for (int row = 0; row < 9; row++) {
					line = b.readLine();
					puzzle += line;
				}
				Solver mySolver = new Solver(puzzle);*/
				Solver mySolver = new Solver(line);
				System.out.println("Initial:");
				mySolver.print();
				try {
					mySolver.solve();
					System.out.println("Solved:");
					mySolver.print();
					solvedCount++;
					int guessCount = mySolver.guessCount;
					if (guessCount > maxGuesses) {
						maxGuesses = guessCount;
						hardest	= solvedCount + failedCount;
					}
					System.out.println("Guess count: " + mySolver.guessCount);
				} catch (FailedSolutionException e) {
					System.out.println("Solution cannot be found.");
					failedCount++;
				}
				System.out.println("Puzzles solved: " + solvedCount);
				System.out.println("Puzzles failed: " + failedCount);
				System.out.println();
				System.out.println();
				line = b.readLine();
			}
			System.out.println("Hardest puzzle: " + hardest);
			System.out.println("Most guesses: " + maxGuesses);

		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
		}
		catch (IOException e) {
			System.out.println("Invalid file.");
		}
	}

}