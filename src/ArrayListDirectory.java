import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class ArrayListDirectory implements Directory {
    ArrayList<Entry> entries= new ArrayList<>();

    @Override
    public void insertEntry(Entry entry) {
        entries.add(entry);

    }

    @Override
    public void deleteEntryUsingName(String surname) {
        int i=0;
        while(!surname.equals(entries.get(i).getSurname())){
            i++;

        }
        if(entries.get(i).getSurname().equals(surname)){
            entries.remove(i);
        }
    }



    @Override
    public void deleteEntryUsingExtension(String number) {
        int i=0;
        while(!number.equals(entries.get(i).getNumber())){
            i++;
        }
        if(entries.get(i).getNumber().equals(number)){
            entries.remove(i);
        }
    }



    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        int i=0;
        while(!surname.equals(entries.get(i).getSurname())){
            i++;
        }
        if(surname.equals(entries.get(i).getSurname())){
            entries.get(i).setNumber(newNumber);
        }
    }

    @Override
    public String lookupExtension(String surname) {
        int i = 0;
        while (!entries.get(i).getSurname().equals(surname)) {
            i++;
        }
        if (surname.equals(entries.get(i).getSurname())) {
            return entries.get(i).getNumber();
        }
        else return null;
    }

    @Override
    public List<Entry> toArrayList() {
        return entries;
    }
}
