import java.util.Scanner;

public class Student {
    private String name;
    private int[] scores;
    private char grade;

    public Student(String name, int[] scores) {
        this.name = name;
        this.scores = scores;
        this.grade = calculateGrade();
    }

    public void displayInformation() {
        System.out.println("Student Name: " + name);
        System.out.print("Scores: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println("\nAverage Score: " + calculateAverage());
        System.out.println("Grade: " + grade);
    }

    private double calculateAverage() {
        if (scores.length == 0) {
            return 0.0;
        }

        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return (double) total / scores.length;
    }

    private char calculateGrade() {
        double average = calculateAverage();

        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the number of scores: ");
        int numScores = scanner.nextInt();

        int[] scores = new int[numScores];
        for (int i = 0; i < numScores; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = scanner.nextInt();
        }

        Student student = new Student(name, scores);
        student.displayInformation();

        scanner.close();
    }
}
