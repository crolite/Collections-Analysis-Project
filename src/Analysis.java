import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public final class Analysis {


    public static int analysisInsert(Directory directory) {
        Entry entry = new Entry("Joe", "J.M.", "01234");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        directory.insertEntry(entry);
        stopWatch.stop();

        return (int) stopWatch.getElapsedTime() / 1_000_000_000;
    }

    public static int analysisDeleteUsingName(Directory directory) {
        Entry entry1 = new Entry("Glanton", "R.A.D.J.G", "40441");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        directory.deleteEntryUsingName(entry1.getSurname());
        stopWatch.stop();

        return (int) stopWatch.getElapsedTime() / 1_000_000_000;
    }


    public static int analysisDeleteUsingExtension(Directory directory) {
        Entry entry2 = new Entry("Ashleigh", "F.A", "34558");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        directory.deleteEntryUsingExtension(entry2.getNumber());
        stopWatch.stop();

        return (int) stopWatch.getElapsedTime() / 1_000_000_000;
    }

    public static int analysislookupExtension(Directory directory) {
        Entry entry3 = new Entry("Morrall", "S.L.M", "73815");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        directory.lookupExtension(entry3.getSurname());
        stopWatch.stop();

        return (int) stopWatch.getElapsedTime() / 1_000_000_000;
    }


    public static void analysis() {
        Directory arrayDirectory = new ArrayDirectory();
        Directory arrayListDirectory = new ArrayListDirectory();
        Directory hashMapDirectory = new HashMapDirectory();
        Entry entry1 = new Entry("Glanton", "R.A.D.J.G", "40441");
        Entry entry2 = new Entry("Ashleigh", "F.A", "34558");
        int time1 = 0;
        int time1sum = 0;
        int time2sum = 0;
        int time3sum = 0;
        int time2 = 0;
        int time3 = 0;
        int  bestcase1 = analysisInsert(arrayDirectory);
        int  worstcase1 = 0;
        int  bestcase2 = 0;
        int  worstcase2 = analysisInsert(arrayListDirectory);
        int  bestcase3 = analysisInsert(hashMapDirectory);
        int  worstcase3 = 0;
        int time12 = 0;
        int time22 = 0;
        int time32 = 0;
        int  bestcase12 = analysisDeleteUsingName(arrayDirectory);
        arrayDirectory.insertEntry(entry1);
        int  worstcase12 = 0;
        int  bestcase22 = analysisDeleteUsingName(arrayListDirectory);
        arrayDirectory.insertEntry(entry1);
        int  worstcase22 = 0;
        int  bestcase32 = analysisDeleteUsingName(hashMapDirectory);
        arrayDirectory.insertEntry(entry1);
        int  worstcase32 = 0;
        int time13 = 0;
        int time23 = 0;
        int time33 = 0;
        int  bestcase13 = analysisDeleteUsingExtension(arrayDirectory);
        arrayDirectory.insertEntry(entry2);
        int  worstcase13 = 0;
        int  bestcase23 = analysisDeleteUsingExtension(arrayListDirectory);
        arrayDirectory.insertEntry(entry2);
        int  worstcase23 = 0;
        int  bestcase33 = analysisDeleteUsingExtension(hashMapDirectory);
        arrayDirectory.insertEntry(entry2);
        int  worstcase33 = 0;
        int time14 = 0;
        int time24 = 0;
        int time34 = 0;
        int  bestcase14 = analysislookupExtension(arrayDirectory);
        int  worstcase14 = 0;
        int  bestcase24 = analysislookupExtension(arrayListDirectory);
        int  worstcase24 = 0;
        int  bestcase34 = analysislookupExtension(hashMapDirectory);
        int  worstcase34 = 0;
        int looptime=10000;
        for (int i = 0; i < looptime; i++) {
            time1 = analysisInsert(arrayDirectory);
            time1sum += time1;
            if (time1 < bestcase1)
                bestcase1 = time1;
            if (time1 < worstcase1)
                worstcase1 = time1;
            time2 = analysisInsert(arrayListDirectory);
            time2sum +=time2;
            if (time2 < bestcase2)
                bestcase2 = time2;
            if (time2 < worstcase2)
                worstcase2 = time2;
            time3 = analysisInsert(hashMapDirectory);
            time3sum +=time3;
            if (time3 < bestcase3)
                bestcase3 = time3;
            if (time3 < worstcase3)
                worstcase3 = time3;
           // Insert for all directories

            time12 = analysisDeleteUsingName(arrayDirectory);
            arrayDirectory.insertEntry(entry1);
            time1sum += time12;
            if (time12 < bestcase12)
                bestcase12 = time12;
            if (time12 < worstcase12)
                worstcase12 = time12;
            time22 = analysisDeleteUsingName(arrayListDirectory);
            arrayDirectory.insertEntry(entry1);
            time2sum += time22;
            if (time22 < bestcase22)
                bestcase22 = time22;
            if (time22 < worstcase22)
                worstcase22 = time22;
            time32 = analysisDeleteUsingName(hashMapDirectory);
            arrayDirectory.insertEntry(entry1);
            time3sum += time32;
            if (time32 < bestcase32)
                bestcase32 = time32;
            if (time32 < worstcase32)
                worstcase32 = time32;
            // DeleteUsingName for all directories
            time13 = analysisDeleteUsingExtension(arrayDirectory);
            arrayDirectory.insertEntry(entry2);
            time1sum += time13;
            if (time13 < bestcase13)
                bestcase13 = time13;
            if (time13 < worstcase13)
                worstcase13 = time13;
            time23 = analysisDeleteUsingExtension(arrayListDirectory);
            arrayDirectory.insertEntry(entry2);
            time2sum += time23;
            if (time23 < bestcase23)
                bestcase23 = time23;
            if (time23 < worstcase23)
                worstcase23 = time23;
            time33 = analysisDeleteUsingExtension(hashMapDirectory);
            arrayDirectory.insertEntry(entry2);
            time3sum += time33;
            if (time33 < bestcase33)
                bestcase33 = time33;
            if (time33 < worstcase33)
                worstcase33 = time33;
            // DeleteUsingExtension for all directories
            time14 = analysislookupExtension(arrayDirectory);
            time1sum += time14;
            if (time14 < bestcase14)
                bestcase14 = time14;
            if (time14 < worstcase14)
                worstcase14 = time14;
            time24 = analysislookupExtension(arrayListDirectory);
            time2sum += time24;
            if (time24 < bestcase24)
                bestcase24 = time24;
            if (time24 < worstcase24)
                worstcase24 = time24;
            time34 = analysislookupExtension(hashMapDirectory);
            time3sum += time34;
            if (time34< bestcase34)
                bestcase34 = time34;
            if (time34 < worstcase34)
                worstcase34= time34;
            // LookupExtension for all directories
        }
        try {
            File file=new File("Analysis.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw= new PrintWriter(file);
            pw.println("insertEntry analysis");
            pw.println("arrayDirectory best time: "+ bestcase1 +" and worst time: " + worstcase1);
            pw.println("arraylistDirectory best time: "+ bestcase2 +" and worst time: " + worstcase2);
            pw.println("hashMapDirectory best time: "+ bestcase3 +" and worst time: " + worstcase3);
            pw.println("deleteEntryUsingName analysis");
            pw.println("arrayDirectory best time: "+ bestcase12 +" and worst time: " + worstcase12);
            pw.println("arraylistDirectory best time: "+ bestcase22 +" and worst time: " + worstcase22);
            pw.println("hashMapDirectory best time: "+ bestcase32 +" and worst time: " + worstcase32);
            pw.println("deleteEntryUsingExtension analysis");
            pw.println("arrayDirectory best time: "+ bestcase13 +" and worst time: " + worstcase13);
            pw.println("arraylistDirectory best time: "+ bestcase23 +" and worst time: " + worstcase23);
            pw.println("hashMapDirectory best time: "+ bestcase33 +" and worst time: " + worstcase33);
            pw.println("lookupExtension analysis");
            pw.println("arrayDirectory best time: "+ bestcase14 +" and worst time: " + worstcase14);
            pw.println("arraylistDirectory best time: "+ bestcase24 +" and worst time: " + worstcase24);
            pw.println("hashMapDirectory best time: "+ bestcase34 +" and worst time: " + worstcase34);
            pw.println("Average run time for all the methods");
            pw.println("arrayDirectory average time: " + (time1sum/looptime));
            pw.println("arraylistDirectory average time: " + (time2sum/looptime));
            pw.println("hashMapDirectory average time: " + (time3sum/looptime));
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}