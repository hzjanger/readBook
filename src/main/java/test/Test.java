package test;


import config.mysql.ConnectionMysql;
import database.GetDatabase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.sql.*;

public class Test extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run  i = " + i);
        }
    }

    public static void main(String[] args) {
        new Test().start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main  j = " + i);
        }
    }
}
