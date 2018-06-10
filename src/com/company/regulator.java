package com.company;

import com.company.db.DB;
import com.company.structure.file;
import com.company.structure.fileSearcher;

import java.util.ArrayList;

//отвечает за файловые операции и работу с БД
public class regulator {
    private static String path = "";
    fileSearcher fSearch = new fileSearcher();
    String localDb = "Files";

    public regulator() {
        DB.connectDb("hello");
        fSearch = new fileSearcher();
    }

    public void searchFiles() {
        fSearch.searchFilesInDirectory(path);
    }

    /**
     * для тыканий глупых
     */
    public void makeDbTest() {
        file file1 = new file();
        file1.path = "11";
        file1.name = "cdsdv";
        file1.tags = "1111______worked";

//        DB.createTable(localDb);
//        DB.insertData(localDb,file1);
//        DB.select(localDb);
//        DB.updateTags(localDb,file1);
//        DB.deleteTable(localDb);
//        DB.deleteRow(localDb);
        DB.closeDb();
    }

    public void addFilesFromSearchToDB() {
        String listNames[] = fSearch.getListNames();
        ArrayList<Double> listSizes = fSearch.getListSizes();
        for (int i = 0; i < listNames.length; i++) {
            file l = new file(path, listNames[i], "NOTAGS_YET", listSizes.get(i), 3234);
            DB.insertData(localDb, l);
        }
    }

    public void setPath(String path) {
        regulator.path = path;
    }
}
