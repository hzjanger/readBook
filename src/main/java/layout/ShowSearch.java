package layout;

import entity.Book;

import java.util.ArrayList;
import java.util.List;

public class ShowSearch {
    private List<Book> list;

    public ShowSearch() {
        list = new ArrayList<Book>();
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public void addBook(Book book) {
        list.add(book);
    }


}
