import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    private String question;
    private String[] options;
    private int correctOptionIndex;
    
    public QuizQuestion(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public String[] getOptions() {
        return options;
    }
    
    public boolean isCorrect(int selectedOptionIndex) {
        return selectedOptionIndex == correctOptionIndex;
    }
}

public class QuizProgram {
    private static int score = 0;
    private static int questionIndex = 0;
    private static QuizQuestion[] questions = {
        new QuizQuestion("Who is the father of our nation?", new String[]{"A. Gandhiji", "B.Nehru", "C. Bose", "D.Patel"}, 0),
        new QuizQuestion("Which planet is known as the Red Planet?", new String[]{"A. Mars", "B. Venus", "C. Jupiter", "D. Saturn"}, 0),
        new QuizQuestion("What is our national bird'?", new String[]{"A. Peacock", "B. Sparrow", "C. Parrot", "D.Dove"}, 0)
    };
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Quiz Program!");
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                showResult();
                timer.cancel();
                scanner.close();
            }
        }, 20000); // Set timer to 20 seconds
        
        displayNextQuestion(scanner);
    }
    
    private static void displayNextQuestion(Scanner scanner) {
        if (questionIndex < questions.length) {
            QuizQuestion currentQuestion = questions[questionIndex];
            System.out.println("\nQuestion " + (questionIndex + 1) + ": " + currentQuestion.getQuestion());
            String[] options = currentQuestion.getOptions();
            for (String option : options) {
                System.out.println(option);
            }
            System.out.print("Your answer: ");
            int selectedOptionIndex = scanner.nextInt();
            if (currentQuestion.isCorrect(selectedOptionIndex - 1)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
            questionIndex++;
            displayNextQuestion(scanner);
        } else {
            showResult();
        }
    }
    
    private static void showResult() {
        System.out.println("\nQuiz ended!");
        System.out.println("Your score: " + score + "/" + questions.length);
    }
}
