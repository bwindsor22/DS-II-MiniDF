import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MiniDF {

    private List<String> columnNames;
    private List<ArrayList<String>> rows = new ArrayList<>();


    private void readCSV(String csvPath) {
        try {
            File myObj = new File(csvPath);
            Scanner reader = new Scanner(myObj);
            if(reader.hasNext()) {
                String firstLine = reader.nextLine();
                String[] firstLine_ = firstLine.split(",");
                columnNames = Arrays.asList(firstLine_);
            }

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                ArrayList<String> nextRow = new ArrayList<>(Arrays.asList(data.split(",")));
                rows.add(nextRow);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void printRow(int i) {
        System.out.println(rows.get(i));
    }


    private void filterRows() {
        int locColumn = columnNames.indexOf("loc");

        List<ArrayList<String>> newRows = new ArrayList<>();
        for (ArrayList<String> row : rows) {
            if(!row.get(locColumn).equals("boston")) {
                newRows.add(row);
            }
        }
        rows = newRows;
    }

    private void dropHeight() {
        int heightColumnIndex = columnNames.indexOf("height");
        for (List<String> row : rows) {
            row.remove(heightColumnIndex);
        }
    }

    public static void main(String[] args) {
        final String peopleCSVPath = "/Users/bradwindsor/teaching/hws/hw2/src/people.csv";
        MiniDF miniDF = new MiniDF();
        miniDF.readCSV(peopleCSVPath);
        miniDF.printRow(0);
        miniDF.printRow(1);
        miniDF.printRow(2);
        miniDF.printRow(3);
        miniDF.printRow(4);

        System.out.println("After filter");
        miniDF.filterRows();

        miniDF.printRow(0);
        miniDF.printRow(1);
        miniDF.printRow(2);
        miniDF.printRow(3);
        miniDF.printRow(4);

        System.out.println("After drop");
        miniDF.dropHeight();
        miniDF.printRow(0);
        miniDF.printRow(1);
        miniDF.printRow(2);
        miniDF.printRow(3);
        miniDF.printRow(4);
    }
}
