import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Input {
    public static boolean isNum(final String str){
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void readFunction(Directory directory) {
        String csvFile = "H:\\assessment-2-collections-analysis-project\\src\\test_data.csv";
        BufferedReader br;
        String line;
        String cvsSplitBy = ",";
        int i = 0;

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while (!((line = br.readLine()) == null)) {
                String[] temp = line.split(cvsSplitBy);
                directory.insertEntry(new Entry(temp[0], temp[1], temp[2]));
                i++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        Directory arrayDirectory = new ArrayDirectory();
        readFunction(arrayDirectory);
        List<Entry> dzemalas= arrayDirectory.toArrayList();
        int temp = args.length;
        int i=0;
        boolean logic=true;
        while(temp>=3){
            for(  Entry entry : dzemalas){
                logic=true;
                if(args[i].equals(entry.getSurname())){
                   logic=false;
                }
            }
            if (logic &&args[(i+2)].trim().length()==5 && isNum(args[(i+2)])) {
                arrayDirectory.insertEntry(new Entry(args[i], args[(i + 1)], args[(i + 2)]));
            }
            temp = temp - 3;
            i+=3;
        }
        Output.OutputEntries( arrayDirectory );
        Analysis.analysis();




    }
}


