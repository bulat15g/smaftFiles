package com.company.db;

import com.company.structure.file;

import java.sql.*;

public class filesDB {
    static Connection c = null;
    static Statement stmt = null;

    public static void connectDb(String name) {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:" + name + ".db");
            System.out.println("sucess db opened");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void createTable(String tableName) {
        try {
            stmt = c.createStatement();
            String sql = "CREATE TABLE " + tableName + " " +
                    "(ID INTEGER PRIMARY KEY   AUTOINCREMENT  NOT NULL," +
                    " PATH           TEXT    NOT NULL, " +
                    " NAME            TEXT     NOT NULL, " +
                    " SIZE        REAL , " +
                    " TAGS         TEXT, " +
                    " DATA        INTEGER )";
            stmt.executeUpdate(sql);

            System.out.println("Table created successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * (PATH,NAME,SIZE,TAGS,DATA)
     */
    public static void insertData(String tableName, file file) {
        try {
            c.setAutoCommit(false);
            stmt = c.createStatement();
//            String sql = "INSERT INTO "+tableName+" (PATH,NAME,SIZE,TAGS,DATA) " +
//                    "VALUES ('folder1', 'file1', '22,8', '#tag1 #tag2','data') ;";
            String sql = "INSERT INTO " + tableName + " (PATH,NAME,SIZE,TAGS,DATA) " +
                    "VALUES ('" + file.path + "', '" + file.name + "', '" + file.size + "', '" + file.tags + "','" + file.data + "') ;";
            stmt.executeUpdate(sql);

            c.commit();
            System.out.println("sucess db added");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    /**
     * обновляет текущие теги у совпадающих имени и пути
     */
    public static void updateTags(String tableName, file file) {
        try {
            c.setAutoCommit(false);
            stmt = c.createStatement();

            String sql = "UPDATE " + tableName + " set TAGS = '" + file.tags + "' where PATH='" + file.path + "' AND NAME='" + file.name + "';";
            stmt.executeUpdate(sql);

            c.commit();
            System.out.println("sucess db updated");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void deleteTable(String tableName) {
        try {
            stmt = c.createStatement();
            String sql = "DROP TABLE IF EXISTS " + tableName + ";";
            stmt.executeUpdate(sql);
            System.out.println("success deleted");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    // TODO: 10.06.18 Qqq
    public static void deleteRow(String tableName) {
        try {
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "DELETE from " + tableName + " where NAME='cdsdv';";
            stmt.executeUpdate(sql);
            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 10.06.18 сделать умный поиск,нуууу
    public static void select(String tableName) {
        ResultSet rs = null;
        try {
            String condition = "NAME='test'";

            c.setAutoCommit(false);
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * FROM " + tableName + " where " + condition + ";");
            while (rs.next()) {

                int id = rs.getInt("id");
                String PATH = rs.getString("PATH");
                String NAME = rs.getString("NAME");
                double SIZE = rs.getFloat("SIZE");
                String TAGS = rs.getString("TAGS");
                String DATA = rs.getString("DATA");
                System.out.println(PATH + " || " + NAME + " || " + Double.toString(SIZE) + " || " + TAGS + " || " + DATA);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeDb() {
        try {
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }


    }
}
