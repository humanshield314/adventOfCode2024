package advent.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    String fileLoc = "resources/day3/inputDay3.txt";
    File file = new File(fileLoc);
    List<String> reports;

    public Day3() throws IOException {
        reports = this.loadCommands();
    }

    public static void main(String[] args) throws IOException {
        Day3 day3 = new Day3();
        System.out.println(day3.getMultiples(day3.reports));
        System.out.println(day3.getMultiples(day3.parseCommands(day3.reports)));
    }


    public int getMultiples(List<String> commandList) {
        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";

        Pattern pattern = Pattern.compile(regex);
        int count = 0;
        for (String command : commandList) {
            Matcher matcher = pattern.matcher(command);

            while (matcher.find()) {
                count = count + Integer.parseInt(matcher.group(1)) * Integer.parseInt(matcher.group(2));
            }
        }

        return count;
    }

    public List<String> parseCommands(List<String> commandList) {
        ArrayList<String> targetStrings = new ArrayList<>();
        StringBuilder singleCommand = new StringBuilder();
        for (String command : commandList) {
            //the input file was treated as each line as a single command, but the entire file was the command
            singleCommand.append(command);
        }
        String[] doSplits = singleCommand.toString().split("do\\(\\)");
        for (String split : doSplits) {
            String[] dontSplits = split.split("don't\\(\\)", 2);
            targetStrings.add(dontSplits[0]);
        }
        return targetStrings;
    }


    protected List<String> loadCommands() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        //a list of reports, with reports being a list of numbers
        List<String> commands = new ArrayList<>();
        while (line != null) {
            commands.add(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return commands;
    }
}
