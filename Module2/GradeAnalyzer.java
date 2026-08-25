import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class GradeAnalyzer {

    public static void main(String[] args) {
        try {

            // If no argument is passed, we catch the appropriate exception. The filename must be passed via command line argument
            String fileName = args[0];

            // Step 1: read scores from file
            ArrayList<Integer> scores = readScores(fileName);

            if (scores.size() == 0) {
                System.out.println("No score found for calculating average. Aborting...");
                return;
            }

            // Step 2: calculate statistics
            int highestScore = Collections.max(scores);
            int lowestScore = Collections.min(scores);
            double averageScore = calculateAverage(scores);

            //Format the Statistic output with proper alignment
            String statistics = String.format(                   
                    "Highest Score: %d%n" +
                    "Lowest Score:  %d%n" +
                    "Average Score: %.2f%n",
                    highestScore,
                    lowestScore,
                    averageScore);

            System.out.println(statistics);

            // Initialize all counters at once
            int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

            //The score range is already validated in the readScores() method and must be 0-100
            for (Integer score : scores) {
                if (score >= 90) {
                    countA++;
                } else if (score >= 80) {
                    countB++;
                } else if (score >= 70) {
                    countC++;
                } else if (score >= 60) {
                    countD++;
                } else {
                    countF++;
                }
            }

            //Format the grade distribution with proper alignment
            String gradeDistribution = String.format(
                    "Grade Distribution:%n" +
                    "A (90-100):   %d%n" +
                    "B (80-89):    %d%n" +
                    "C (70-79):    %d%n" +
                    "D (60-69):    %d%n" +
                    "F (below 60): %d%n",
                    countA,
                    countB,
                    countC,
                    countD,
                    countF);

            System.out.println(gradeDistribution);

            // Step 3: write and print report
            writeReport(scores, averageScore, highestScore, lowestScore, "report.txt");

        } 
        //If no command line argument is passed
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No command-line argument passed");
        } 
        //Catch general exceptions
        catch (Exception e) {
            System.out.println("Error occured while calculating average. " + e.getMessage());
        }
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {

        int invalidOrSkipped = 0;
        int totalLineCount = 0;
        ArrayList<Integer> scores = new ArrayList<Integer>();

        System.out.println("=".repeat(10) + " Grade Analysis Report " + "=".repeat(10));
        System.out.println(); // Adding empty line to console output for readability
        System.out.println("Processing file: " + filename);

        //Read file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    if(line.isEmpty()){
                        // we need to skip this line and proceed to next iteration while incrementing the invalid and total lines count
                        invalidOrSkipped++;
                        totalLineCount++;
                        System.out.println("[WARNING] Blank value detected at line # " + totalLineCount + 
                        " in the [" + filename +"] file, skipping line.");
                        continue;
                    }

                    int parsedValue = Integer.parseInt(line.trim());
                    if (parsedValue < 0 || parsedValue > 100) {

                        totalLineCount++;
                        System.out.println("[WARNING] The score must be between 0 and 100. The score " + parsedValue +
                        " at line # " + totalLineCount + " in the [" + filename +"] file is invalid, skipping line.");

                        // we need to skip this line and proceed to next iteration while incrementing
                        // the invalid and total lines count
                        invalidOrSkipped++;
                        continue;
                    }
                    totalLineCount++;
                    scores.add(parsedValue);

                } catch (NumberFormatException e) {
                    invalidOrSkipped++;
                    totalLineCount++;
                    System.err.println("[WARNING] Failed to parse '" + line + "' to integer, skipping line # " +
                    totalLineCount+" at file: ["+filename+"].");
                }
            }

            String processingSummary = String.format(
                    "Total lines read:        %d%n" +
                    "Total scores processed:  %d%n" +
                    "Invalid lines skipped:   %d%n",
                    totalLineCount,
                    scores.size(),
                    invalidOrSkipped);

            System.out.println(System.lineSeparator()+processingSummary);

            return scores;

        } catch (IOException e) {
            // propagate the exception to main() method. No need to return the scores.
            throw new RuntimeException("Cannot read the file: " + e.getMessage(), e);
        }
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {

        // Return 0.0 if no score is passed for calculation
        if (scores.size() == 0) {
            return 0.0;
        }

        //No need for try-catch error handling as the validate scores arrives here and then processed
        double totalScores = 0.0;
        for (int score : scores) {
            totalScores += score;
        }
        return totalScores / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low, String outputFile) {
        // Initialize all counters at once
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        // Grade distributions
        for (Integer score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String statistics = String.format(
                    "Highest Score: %d%n" +
                    "Lowest Score:  %d%n" +
                    "Average Score: %.2f%n",
                    high,
                    low,
                    avg);

            String gradeDistribution = String.format(
                    "Grade Distribution:%n" +
                    "A (90-100):   %d%n" +
                    "B (80-89):    %d%n" +
                    "C (70-79):    %d%n" +
                    "D (60-69):    %d%n" +
                    "F (below 60): %d%n",
                    countA,
                    countB,
                    countC,
                    countD,
                    countF);
            // Write the statistics and grade distribution to the report at once .

            writer.write("=".repeat(10) + " Grade Analysis Report " + "=".repeat(10) +
                    System.lineSeparator() + //Add line separators for better readability
                    statistics +
                    System.lineSeparator() +
                    gradeDistribution +
                    System.lineSeparator() + 
                    "Total scores/lines processed: " + scores.size() );

        } catch (Exception e) {
            System.out.println("Could not write file: " + e.getMessage());
        }

    }
}