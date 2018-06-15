package entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Author {
    private String author_name;
    private String author_introduction;
    private int author_id;

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_introduction() {
        return author_introduction;
    }

    public void setAuthor_introduction(String author_introduction) {
        this.author_introduction = author_introduction;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_name='" + author_name + '\'' +
                ", author_introduction='" + author_introduction + '\'' +
                ", author_id=" + author_id +
                '}';
    }

    public List<String> getList(String value) {
        List<String> list = new ArrayList<String>();
        String[] split = value.split("\n");
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        return list;
    }
}
