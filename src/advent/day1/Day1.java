package advent.day1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Day1 {
    File file;
    List<Integer> list1;
    List<Integer> list2;
    List<Integer> sorted1;
    List<Integer> sorted2;

    public Day1(String file) throws IOException {
        this.file = new File(file);
        List<List<Integer>> twoLists = this.loadFromFile();
        list1 = twoLists.get(0);
        list2 = twoLists.get(1);
        sorted1 = new ArrayList<>();
        sorted2 = new ArrayList<>();
        Collections.copy(list1, sorted1);
        Collections.copy(list2, sorted2);
        Collections.sort(sorted1);
        Collections.sort(sorted2);
    }

    public static void main(String[] args) throws IOException {
        Day1 day1 = new Day1("resources/day1/inputDay1.txt");
        Integer diff = day1.listDiff();
        System.out.printf("%d is diff\n", diff);
        System.out.println(day1.similarityScore());

    }

    private Integer listDiff() {
        int distance = 0;
        for (int i = 0; i < sorted1.size(); i++) {
            distance += Math.abs(sorted1.get(i) - sorted2.get(i));
        }
        return distance;
    }

    private int similarityScore() {
        HashMap<Integer, Integer> freq = new HashMap<>();
        List<Integer> simScores = new ArrayList<>();
        for (int item : list2) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }
        for (int key : list1) {
            simScores.add(key * freq.getOrDefault(key, 0));
        }
        return simScores.stream().mapToInt(Integer::intValue).sum();
    }

    private List<List<Integer>> loadFromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> retList = new ArrayList<>();
        retList.add(list1);
        retList.add(list2);
        while (line != null) {
            String[] split = line.split("\\s+");
            list1.add(Integer.parseInt(split[0]));
            list2.add(Integer.parseInt(split[1]));
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return retList;
    }
}
