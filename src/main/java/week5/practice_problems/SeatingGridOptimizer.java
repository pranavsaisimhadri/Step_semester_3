public class SeatingGridOptimizer {
    static double rowAverage(int[] row) {
        int sum = 0;
        for (int val : row) {
            sum += val;
        }
        return (double) sum / row.length;
    }

    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < seatingScores.length; i++) {
            double avg = rowAverage(seatingScores[i]);
            String zone = avg >= threshold ? "Buzzing Zone" : "Quiet Zone";
            if (i > 0) result.append(" | ");
            result.append("Row ").append(i).append(": ").append(zone);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(seatingScores, 60));
    }
}