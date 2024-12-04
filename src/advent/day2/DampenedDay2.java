package advent.day2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DampenedDay2 extends Day2 {
    public DampenedDay2(String file) {
        super(file);
    }

    public static void main(String[] args) {
        DampenedDay2 day2 = new DampenedDay2("resources/day2/inputDay2.txt");
        System.out.println(day2.countReportSafety());
    }

    @Override
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
        //brute force it.  just check every permutation where it is removed
        //tried to do something smart about checking both the next and the next+1
        //but i wasn't sure how to determine if it was increasing or decreasing correctly.
        List<Integer> tempList;
        for (int i = 0; i < report.size(); i++) {
            tempList = new ArrayList<>(report);
            tempList.remove(i);
            if (super.isReportSafe(tempList)) {
                return true;
            }
        }
        return false;
    }

}
