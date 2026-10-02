import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) { this.title = title; }

    abstract int loanDays();

    LocalDate dueDate(LocalDate today) { return today.plusDays(loanDays()); }
}

class Book extends LibraryItem {
    Book(String t) { super(t); }
    int loanDays() { return 14; }
}

class Dvd extends LibraryItem {
    Dvd(String t) { super(t); }
    int loanDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String t) { super(t); }
    int loanDays() { return 3; }
}

public class LibraryItemDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate today = LocalDate.of(2023, 10, 26);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String type = line.substring(0, line.indexOf(' '));
            String title = line.substring(line.indexOf('"') + 1, line.lastIndexOf('"'));
            switch (type) {
                case "BOOK":     items.add(new Book(title));     break;
                case "DVD":      items.add(new Dvd(title));      break;
                case "MAGAZINE": items.add(new Magazine(title)); break;
            }
        }

        for (LibraryItem item : items)
            System.out.println(item.title + ": " + item.dueDate(today));
    }
}