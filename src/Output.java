import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public  final class  Output {



    public  static void OutputEntries(Directory directory)  {
        List<Entry> entries= directory.toArrayList();
        String format = "|%-13s|%-10s|%11s|%n";
        System.out.println("+-------------+----------+-----------+");
        System.out.println("|   Surname   | Initials | Extension |");
        System.out.println("+-------------+----------+-----------+");
        for (Entry value : entries) {
            if (!(value == null)) {
                System.out.format(format, value.getSurname() , value.getInitials() , value.getNumber());
            }
        }
        System.out.println("+-------------+----------+-----------+");


        try (PrintWriter writer = new PrintWriter(new File("Output.csv"))) {
            StringBuilder sb = new StringBuilder();
            for (Entry value : entries) {
                sb.append(value.getSurname());
                sb.append(',');
                sb.append(value.getInitials());
                sb.append(',');
                sb.append(value.getNumber());
                sb.append('\n');
            }
            writer.write(sb.toString());
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
