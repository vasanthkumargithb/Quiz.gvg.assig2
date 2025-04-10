package quizsystem;

import java.util.*;


class QuizQuestion {
    String text;
    String[] options;
    int correctAnswer;

    public QuizQuestion(String text, String[] options, int correctAnswer) {
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void display() {
        System.out.println("\n" + text);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}


// / Main quiz application class.
public class quizsystem{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<QuizQuestion> questions = new ArrayList<>();

        // Adding questions
        questions.add(new QuizQuestion("What is the capital of India?", new String[]{"Delhi", "Mumbai", "Chennai", "Kolkata"}, 1));
        questions.add(new QuizQuestion("Which language is used for Android?", new String[]{"Python", "Java", "C++", "C"}, 2));
        questions.add(new QuizQuestion("Who is known as the king of cricket?", new String[]{"Virat", "Dhoni", "Sachin", "Yuvraj Singh"}, 1));

        int score = 0;
        System.out.println("- Welcome to the Quiz -");

        for (QuizQuestion q : questions) {
            q.display();
            int answer = 0;
            boolean valid = false;

            while (!valid) {
                try {
                    System.out.print("Enter your answer (1-4): ");
                    answer = Integer.parseInt(scanner.nextLine());
                    if (answer < 1 || answer > 4) throw new InputMismatchException();
                    valid = true;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            }

            if (q.checkAnswer(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct answer was option " + q.getCorrectAnswer());
            }
        }

        System.out.println("\n=== Quiz Over ===");
        System.out.println("Your Score: " + score + " out of " + questions.size());
    }
}
