package Collections;
import java.util.*;

class Question {
    int questionId;
    String content;

    Question(int questionId, String content) {
        this.questionId = questionId;
        this.content = content;
    }

    
    public String toString() {
        return "Question{" + "id=" + questionId + ", content='" + content + '\'' + '}';
    }
}

class Student {
    String studentId;
    String name;

    Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    
    public String toString() {
        return "Student{" + "id='" + studentId + '\'' + ", name='" + name + '\'' + '}';
    }
}

public class online_management_examination_system {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        Set<String> studentIds = new HashSet<>();
        Queue<Student> studentQueue = new LinkedList<>();
        Stack<Question> questionStack = new Stack<>();

       
        System.out.print("How many students to enroll? ");
        int studentCount = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < studentCount; i++) {
            System.out.println("Enter student ID and name:");
            String id = scanner.nextLine();

            if (studentIds.contains(id)) {
                System.out.println("Duplicate ID found. Student not enrolled: " + id);
            } else {
                String name = scanner.nextLine();
                studentIds.add(id);
                studentQueue.add(new Student(id, name));
                System.out.println("Student enrolled: " + id);
            }
        }

        
        System.out.print("How many questions in the exam? ");
        int questionCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= questionCount; i++) {
            System.out.println("Enter content for Question " + i + ":");
            String content = scanner.nextLine();
            questions.add(new Question(i, content));
        }

        Collections.shuffle(questions);

        
        for (Question q : questions) {
            questionStack.push(q);
        }

        System.out.println("Questions randomized and loaded.");

      
        while (!studentQueue.isEmpty()) {
            Student currentStudent = studentQueue.poll();
            System.out.println("Serving student: " + currentStudent);

          
            System.out.println("Starting exam for " + currentStudent.name);

            Stack<Question> navigationStack = new Stack<>();
            while (!questionStack.isEmpty()) {
                Question currentQuestion = questionStack.pop();
                System.out.println("Current question: " + currentQuestion);

                System.out.println("Enter command (next, back, quit):");
                String command = scanner.nextLine().trim().toLowerCase();

                if (command.equals("next")) {
                    navigationStack.push(currentQuestion);
                    if (questionStack.isEmpty()) {
                        System.out.println("No more questions.");
                        break;
                    }
                } else if (command.equals("back")) {
                    if (!navigationStack.isEmpty()) {
                        Question previousQuestion = navigationStack.pop();
                        System.out.println("Back to question: " + previousQuestion);
                        questionStack.push(currentQuestion);
                    } else {
                        System.out.println("No previous question.");
                        questionStack.push(currentQuestion);
                    }
                } else if (command.equals("quit")) {
                    System.out.println("Exiting exam for " + currentStudent.name);
                    break;
                } else {
                    System.out.println("Invalid command.");
                    questionStack.push(currentQuestion);
                }
            }
            System.out.println("Exam ended for " + currentStudent.name);
        }
    }
}

