package test;


public class Test extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("run  i = " + i);
        }
    }

    public static void main(String[] args) {

    }
}
