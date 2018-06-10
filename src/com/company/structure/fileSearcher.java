package com.company.structure;

import java.io.File;

// TODO: 10.06.18 написать поискатор директорий
public class fileSearcher {

    public static void searchFilesInDirectory(String path) {
        String list[] = new File(path).list();//"." to this path

        for (int i = 0; i < list.length; i++)
            System.out.println(list[i]);

    }

}
