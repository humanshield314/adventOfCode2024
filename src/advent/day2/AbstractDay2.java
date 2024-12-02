package advent.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDay2 {
    protected boolean isIncreasing(int first, int second) {
        return first < second;
    }

    protected boolean isDecreasing(int first, int second) {
        //for readability
        return first > second;
    }

    protected List<List<Integer>> loadReports(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        //a list of reports, with reports being a list of numbers
        List<List<Integer>> retList = new ArrayList<>();
        while (line != null) {
            String[] split = line.split("\\s+");
            List<Integer> intArray = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
            retList.add(intArray);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return retList;
    }
}
