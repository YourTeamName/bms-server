package edu.gatech.buzzmovieselector.server.heroku;

/**
 * Created by yangjianing on 3/4/16.
 */
public class Test {
    public static void main(String[] args) {

        try {
            throw new Exception("shit!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("reached end");
    }
}
