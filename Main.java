import java.util.*;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }
}

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOption;

    public QuizQuestion(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctOption;
    }
}

class QuizSession {
    private User user;
    private List<QuizQuestion> questions;
    private int timeLimitInSeconds;

    public QuizSession(User user, List<QuizQuestion> questions, int timeLimitInSeconds) {
        this.user = user;
        this.questions = questions;
        this.timeLimitInSeconds = timeLimitInSeconds;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int remainingTimeInSeconds = timeLimitInSeconds;

        System.out.println("Welcome, " + user.getUsername() + "!");
        System.out.println("You have " + timeLimitInSeconds + " seconds for the quiz.");

        for (QuizQuestion question : questions) {
            System.out.println("\n" + question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            System.out.print("Enter your answer (1-" + options.size() + "): ");
            int selectedOption = scanner.nextInt();

            if (question.isCorrect(selectedOption)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }

            remainingTimeInSeconds -= 5; // Simulating time for each question
        }

        System.out.println("\nQuiz session ended. Your score: " + score);
    }
}

public class Main {
    public static void main(String[] args) {
        User user = new User("username", "password");
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of India?", Arrays.asList("Goa", "New Delhi", "Chennai"), 2));
        questions.add(new QuizQuestion("What is the largest planet in our solar system?", Arrays.asList("Venus", "Saturn", "Jupiter"), 3));
        questions.add(new QuizQuestion("Which famous scientist formulated the theory of relativity?", Arrays.asList("Albert Einstein", "Isaac Newton", "Galileo Galilei"), 1));
        questions.add(new QuizQuestion("Which natural wonder is located between the border of Zambia and Zimbabwe?", Arrays.asList(" Grand Canyon", "Victoria Falls", "Mount Everest"), 2));
        questions.add(new QuizQuestion("What is the smallest bone in the human body?", Arrays.asList(" Femur", "Tibia", "Stapes (in the ear)"), 3)); 
        questions.add(new QuizQuestion("Which historical document begins with the words \"When in the Course of human events...\"?", Arrays.asList("The Magna Carta", "The Declaration of Independence", "The Emancipation Proclamation"), 2));
         
        int timeLimitInSeconds = 60; // Total time for the quiz

        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            QuizSession quizSession = new QuizSession(user, questions, timeLimitInSeconds);
            quizSession.start();
        } else {
            System.out.println("Invalid credentials. Exiting.");
        }
    }
}
