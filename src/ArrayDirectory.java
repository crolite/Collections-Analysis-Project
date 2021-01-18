import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDirectory implements Directory{
    Entry[] entries;

    public ArrayDirectory() {
        entries = new Entry[100000];
        StopWatch stopWatch= new StopWatch();
    }

    @Override
    public void insertEntry(Entry entry) {
        int i=0;
        while(entries[i]!= null){
            i++;
        }
        entries[i] = entry;
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        int i=0;
        while(!surname.equals(entries[i].getSurname())){
            i++;
        }
        if(entries[i].getSurname().equals(surname)){
            if (entries.length - i >= 0) System.arraycopy(entries, i + 1, entries, i, entries.length - i);
        }
    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        int i=0;
        while(!number.equals(entries[i].getNumber())){
            i++;
        }
        if(entries[i].getNumber().equals(number)){
            if (entries.length - i >= 0) System.arraycopy(entries, i + 1, entries, i, entries.length - i);
        }
    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        int i=0;
        while(!surname.equals(entries[i].getSurname())){
            i++;
        }
        if(surname.equals(entries[i].getSurname())){
           entries[i].setNumber(newNumber);
        }
    }

    @Override
    public String lookupExtension(String surname) {
        int i = 0;
        while (!entries[i].getSurname().equals(surname)) {
            i++;
        }
        if (surname.equals(entries[i].getSurname())) {
            return entries[i].getNumber();
        }
        else return null;
    }



    @Override
    public List<Entry> toArrayList() {

        return new ArrayList<Entry>(Arrays.asList(entries));
    }
}







