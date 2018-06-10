package com.company;

import com.company.db.*;
import com.company.structure.*;

public class regulator {
    public static String path = "";

    public regulator() {
        filesDB.connectDb("hello");
    }

    public static void searchFiles() {
        fileSearcher.searchFilesInDirectory(path);
    }

    public static void makeDbTest() {
        file file1 = new file();
        file1.name = "cdsdv";
//        file1.tags="fifal_Changed";

//        filesDB.createTable("Files");
//        filesDB.insertData("Files",file1);
//        filesDB.select("Files");
//        filesDB.deleteTable("Files");
        filesDB.deleteRow("Files");
        filesDB.closeDb();
    }

    public static void setPath(String path) {
        regulator.path = path;
    }
}
