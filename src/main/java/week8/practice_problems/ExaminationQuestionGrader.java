import java.util.*;
import java.util.regex.*;

abstract class Question {
    String type, correct, student;
    int points;

    Question(String type, String correct, String student, int points) {
        this.type = type;
        this.correct = correct;
        this.student = student;
        this.points = points;
    }

    abstract double score();
}

class McqQuestion extends Question {
    McqQuestion(String c, String s, int p) { super("MCQ", c, s, p); }
    double score() { return student.equals(correct) ? points : 0; }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String c, String s, int p) { super("TF", c, s, p); }
    double score() { return student.equals(correct) ? points : 0; }
}

class EssayQuestion extends Question {
    EssayQuestion(String c, String s, int p) { super("ESSAY", c, s, p); }

    double score() {
        int matched = 0;
        for (String k : correct.split(","))
            if (student.toLowerCase().contains(k.trim().toLowerCase())) matched++;
        if (matched >= 2) return points * 0.75;
        if (matched == 1) return points * 0.50;
        return 0;
    }
}

public class ExaminationQuestionGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        Pattern quoted = Pattern.compile("\"([^\"]*)\"");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            int points = Integer.parseInt(line.substring(line.lastIndexOf(' ') + 1));

            List<String> parts = new ArrayList<>();
            Matcher m = quoted.matcher(line);
            while (m.find()) parts.add(m.group(1));
            String correct = parts.get(1), student = parts.get(2);

            switch (type) {
                case "MCQ":   questions.add(new McqQuestion(correct, student, points));       break;
                case "TF":    questions.add(new TrueFalseQuestion(correct, student, points)); break;
                case "ESSAY": questions.add(new EssayQuestion(correct, student, points));     break;
            }
        }

        double total = 0;
        for (Question q : questions) {
            double s = q.score();
            System.out.printf("%s: %.2f%n", q.type, s);
            total += s;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}