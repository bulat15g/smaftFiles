package com.company;

public class Main {
    /**
     * 10 sql табла работает причем для первого раза вообще огонь
     * 11 разобраться с фаелами бы
     * 12 окно или 11 окно
     * <p>
     * переработать дату
     * доавить умный поиск
     */
    public static void main(String[] args) {
        regulator r = new regulator();
        r.setPath("/home/bulat/allFiles");
//        r.makeDbTest();
        r.searchFiles();
        r.addFilesFromSearchToDB();
    }

}
