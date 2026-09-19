class AttendanceSheet {
    private final String[] names;
    private int count;

    public AttendanceSheet(int maxSize) {
        names = new String[maxSize];
        count = 0;
    }

    public void markPresent(String name) {
        if (!isPresent(name) && count < names.length) {
            names[count] = name;
            count++;
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (names[i].equals(name)) return true;
        }
        return false;
    }
}

public class AttendanceSheetMain {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}