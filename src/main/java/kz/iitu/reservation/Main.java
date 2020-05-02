package kz.iitu.reservation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        Application app = new Application();

        app.runApp(context);

    }
}