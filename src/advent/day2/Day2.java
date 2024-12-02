package advent.day2;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Day2 extends AbstractDay2 {
    File file;

    public Day2(String file) {
        this.file = new File(file);
    }

    public static void main(String[] args) {
        Day2 day2 = new Day2("resources/day2/inputDay2.txt");
        System.out.println(day2.countReportSafety());
    }

    public int countReportSafety() {
        int safeReports = 0;
        try {
            List<List<Integer>> reportList = this.loadReports(file);
            for (List<Integer> report : reportList) {
                if (isReportSafe(report)) {
                    safeReports++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return safeReports;
    }

    protected boolean isReportSafe(List<Integer> report) {
        //assuming there is more than 1 item per report
        Boolean listIncreasing = null;
        Boolean previousListIncreasing = null;

        for (int i = 0; i < report.size() - 1; i++) {
            listIncreasing = isIncreasing(report.get(i), report.get(i + 1));
            if (previousListIncreasing != null) {
                if (isIncreasing(report.get(i), report.get(i + 1)) && !previousListIncreasing) {
                    //is the current increasing but list started as decreasing
                    return false;
                }
                if (isDecreasing(report.get(i), report.get(i + 1)) && previousListIncreasing) {
                    return false;
                }
            }
            if (Math.abs(report.get(i) - report.get(i + 1)) < 1 || Math.abs(report.get(i) - report.get(i + 1)) > 3) {
                return false;
            }
            previousListIncreasing = listIncreasing;
        }
        return true;
    }

}
