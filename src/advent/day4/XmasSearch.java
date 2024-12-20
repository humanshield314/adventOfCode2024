package advent.day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmasSearch {
    File file = new File("resources/day4/wordsearch.txt");
    char[][] wordSearch;

    public XmasSearch() throws IOException {
        wordSearch = this.loadWordSearch();
    }

    public static void main(String[] args) throws IOException {
        XmasSearch xmasSearch = new XmasSearch();
        System.out.println(xmasSearch.searchXmas(xmasSearch.wordSearch));
        System.out.println(xmasSearch.searchDoubleXmas(xmasSearch.wordSearch));
    }

    public int searchDoubleXmas(char[][] wordSearch) {
        int count = 0;

        //if i check 1 to wordSearch.length -1 should be safe...
        for (int row = 1; row < wordSearch.length - 1; row++) {
            for (int col = 1; col < wordSearch[0].length - 1; col++) {
                count += checkMas(wordSearch, row, col);
            }
        }
        return count;
    }

    public int searchXmas(char[][] wordSearch) {
        int count = 0;

        for (int row = 0; row < wordSearch.length; row++) {
            for (int col = 0; col < wordSearch[0].length; col++) {
                count += checkCol(wordSearch, row, col);
                count += checkRow(wordSearch, row, col);
                count += checkDiag(wordSearch, row, col);
            }
        }
        return count;
    }

    private int checkMas(char[][] wordSearch, int row, int col) {
        int rowCount = 0;
        //safety checks
        char A = wordSearch[row][col];
        char ul = wordSearch[row - 1][col - 1];
        char ur = wordSearch[row - 1][col + 1];
        char bl = wordSearch[row + 1][col - 1];
        char br = wordSearch[row + 1][col + 1];

        //could be clever but just gotta check the four different configurations

        if (ul == ur && ul == 'M' && bl == br && bl == 'S' && A == 'A') {
            rowCount++;
        }
        if (ur == br && ur == 'M' && ul == bl && bl == 'S' && A == 'A') {
            rowCount++;
        }
        if (ul == ur && ur == 'S' && bl == br && bl == 'M' && A == 'A') {
            rowCount++;
        }
        if (ur == br && ur == 'S' && ul == bl && bl == 'M' && A == 'A') {
            rowCount++;
        }

        return rowCount;
    }

    private int checkCol(char[][] wordSearch, int row, int col) {
        int rowCount = 0;
        if (row >= 0 && col >= 0 && row < wordSearch.length && col + 3 < wordSearch[0].length) {
            //safety checks
            char X = wordSearch[row][col];
            char M = wordSearch[row][col + 1];
            char A = wordSearch[row][col + 2];
            char S = wordSearch[row][col + 3];

            if (X == 'X' && M == 'M' && A == 'A' && S == 'S') {
                rowCount++;
            }
        }
        if (row >= 0 && col - 3 >= 0 && row < wordSearch.length && col < wordSearch[0].length) {
            //safety checks
            char X = wordSearch[row][col];
            char M = wordSearch[row][col - 1];
            char A = wordSearch[row][col - 2];
            char S = wordSearch[row][col - 3];

            if (X == 'X' && M == 'M' && A == 'A' && S == 'S') {
                rowCount++;
            }
        }
        return rowCount;
    }

    private int checkDiag(char[][] wordSearch, int row, int col) {
        int rowCount = 0;
        if (row >= 0 && col >= 0 && row + 3 < wordSearch.length && col < wordSearch[0].length) {
            //safety checks
            char X = wordSearch[row][col];
            char M = wordSearch[row + 1][col];
            char A = wordSearch[row + 2][col];
            char S = wordSearch[row + 3][col];

            if (X == 'X' && M == 'M' && A == 'A' && S == 'S') {
                rowCount++;
            }
        }
        if (row - 3 >= 0 && col >= 0 && row < wordSearch.length && col < wordSearch[0].length) {
            //safety checks
            char X = wordSearch[row][col];
            char M = wordSearch[row - 1][col];
            char A = wordSearch[row - 2][col];
            char S = wordSearch[row - 3][col];

            if (X == 'X' && M == 'M' && A == 'A' && S == 'S') {
                rowCount++;
            }
        }
        return rowCount;
    }

    private int checkRow(char[][] wordSearch, int row, int col) {
        int rowCount = 0;
        if (row >= 0 && col >= 0 && row + 3 < wordSearch.length && col + 3 < wordSearch[0].length) {
            //safety checks
            char X = wordSearch[row][col];
            char M = wordSearch[row + 1][col + 1];
            char A = wordSearch[row + 2][col + 2];
            char S = wordSearch[row + 3][col + 3];

            if (X == 'X' && M == 'M' && A == 'A' && S == 'S') {
                rowCount++;
            }
        }
        if (row - 3 >= 0 && col - 3 >= 0 && row < wordSearch.length && col < wordSearch[0].length) {
            //safety checks
            char X = wordSearch[row][col];
            char M = wordSearch[row - 1][col - 1];
            char A = wordSearch[row - 2][col - 2];
            char S = wordSearch[row - 3][col - 3];

            if (X == 'X' && M == 'M' && A == 'A' && S == 'S') {
                rowCount++;
            }
        }
        if (row - 3 >= 0 && col >= 0 && row < wordSearch.length && col + 3 < wordSearch[0].length) {
            //safety checks
            char X = wordSearch[row][col];
            char M = wordSearch[row - 1][col + 1];
            char A = wordSearch[row - 2][col + 2];
            char S = wordSearch[row - 3][col + 3];

            if (X == 'X' && M == 'M' && A == 'A' && S == 'S') {
                rowCount++;
            }
        }
        if (row >= 0 && col - 3 >= 0 && row + 3 < wordSearch.length && col < wordSearch[0].length) {
            //safety checks
            char X = wordSearch[row][col];
            char M = wordSearch[row + 1][col - 1];
            char A = wordSearch[row + 2][col - 2];
            char S = wordSearch[row + 3][col - 3];

            if (X == 'X' && M == 'M' && A == 'A' && S == 'S') {
                rowCount++;
            }
        }

        return rowCount;
    }

    private char[][] loadWordSearch() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        List<char[]> wordsearch = new ArrayList<>();
        while (line != null) {
            char[] lineChar = line.toCharArray();
            wordsearch.add(lineChar);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return wordsearch.toArray(new char[0][0]);
    }
}
