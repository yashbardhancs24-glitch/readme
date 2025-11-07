package Exception;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Custom exceptions
class LateSubmissionException extends Exception {
    public LateSubmissionException(String message) {
        super(message);
    }
}

class InvalidFileFormatException extends Exception {
    public InvalidFileFormatException(String message) {
        super(message);
    }
}

// Exam submission class
class ExamSubmission {
    private static final LocalDateTime deadline = LocalDateTime.of(2025, 11, 7, 17, 0); // Nov 7, 2025 5:00 PM

    public void submitExam(String fileName, LocalDateTime submissionTime) throws LateSubmissionException, InvalidFileFormatException {
        if (!fileName.toLowerCase().endsWith(".pdf")) {
            throw new InvalidFileFormatException("Submission failed: invalid file format.");
        }

        if (submissionTime.isAfter(deadline)) {
            throw new LateSubmissionException("Submission failed: late submission.");
        }

        System.out.println("Exam submitted successfully at " + submissionTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
}

// Main class
public class Online_Exam_Submission {
    public static void main(String[] args) {
        ExamSubmission exam = new ExamSubmission();

        // Sample submission time and filename
        String fileName = "exam_answer.pdf";
        LocalDateTime submissionTime = LocalDateTime.of(2025, 11, 7, 16, 30); // Before deadline

        try {
            exam.submitExam(fileName, submissionTime);
        } catch (LateSubmissionException | InvalidFileFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}



