package com.company.structure;

public class file {
    // TODO: 10.06.18 функция для вычисления веса
    public int id;
    public String path;
    public String name;
    public String tags;//'<tag1> <tag1 weight> <tag2> <tag2 weight>'  at begin all tags 0
    public double size;
    public int data;

    public file(String path, String name, String tags, float size, int data) {
        this.path = path;
        this.name = name;
        this.tags = tags;
        this.size = size;
        this.data = data;
    }

    /**
     * тестовый фаел
     */
    public file() {
        this.path = "test";
        this.name = "test";
        this.tags = "test";
        this.size = 2.04;
        this.data = 30300;
    }

    @Override
    public String toString() {
        return "file{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", tags='" + tags + '\'' +
                ", size=" + size +
                ", data='" + data + '\'' +
                '}';
    }
}
