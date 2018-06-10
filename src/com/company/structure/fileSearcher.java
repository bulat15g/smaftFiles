package com.company.structure;

import java.io.File;
import java.util.ArrayList;

// TODO: 10.06.18 написать поискатор директорий
public class fileSearcher {
    String listNames[] = null;
    ArrayList<Double> listSizes;

    public void searchFilesInDirectory(String path) {
        listNames = new File(path).list();//"." to this path
        listSizes = new ArrayList<>(0);

        for (int i = 0; i < listNames.length; i++) {
            File f = new File(path + "/" + listNames[i]);
            listSizes.add((double) f.length() / 1024 / 1024);
            System.out.println(listNames[i] + "   " + listSizes.get(i).toString() + "Mb");
        }

    }

    public String[] getListNames() {
        return listNames;
    }

    public ArrayList<Double> getListSizes() {
        return listSizes;
    }
}
