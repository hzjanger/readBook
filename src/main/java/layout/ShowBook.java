package layout;

import entity.Book;

import java.util.ArrayList;
import java.util.List;

public class ShowBook {
    private List<Book> list;
    public ShowBook() {
        list = new ArrayList<Book>();
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
