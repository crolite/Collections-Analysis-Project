import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapDirectory implements Directory {
    HashMap<String, String> entriesFL= new HashMap<>();
    HashMap<String, String> entriesExt= new HashMap<>();




    @Override
    public void insertEntry(Entry entry) {
        entriesFL.put(entry.getSurname(), entry.getInitials());
        entriesExt.put(entry.getSurname(), entry.getNumber());
    }

    @Override
    public void deleteEntryUsingName(String surname) {
        entriesFL.remove(surname);
        entriesExt.remove(surname);


    }

    @Override
    public void deleteEntryUsingExtension(String number) {
        String temp= null;

        for(String i: entriesExt.values()){
            if (number.equals(i)){
                temp=entriesExt.get(i);
            }
        }
        entriesExt.remove(temp);
        entriesFL.remove(temp);


    }

    @Override
    public void updateExtensionUsingName(String surname, String newNumber) {
        entriesExt.put(surname, newNumber);

    }

    @Override
    public String lookupExtension(String surname) {
        return entriesExt.get(surname);
    }

    @Override
    public List<Entry> toArrayList() {
         ArrayList<Entry> entrylist= new ArrayList<>();
         for (String i:entriesExt.keySet()){
             entrylist.add(new Entry(i,entriesFL.get(i),entriesExt.get(i)));
         }
        return entrylist;
    }

}
