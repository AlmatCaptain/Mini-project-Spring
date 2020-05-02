package kz.iitu.reservation;

import kz.iitu.reservation.Controller.EmployeeController;
import kz.iitu.reservation.Controller.ReserveController;
import kz.iitu.reservation.Controller.RoomController;
import kz.iitu.reservation.model.Employee;
import kz.iitu.reservation.model.ReservedRooms;
import kz.iitu.reservation.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Application {

    Scanner scanner = new Scanner(System.in);

    EmployeeController employeeController;
    RoomController roomController;
    ReserveController reserveController;

    void runApp(ApplicationContext context) throws SQLException {
        employeeController = context.getBean("employeeController", EmployeeController.class);
        roomController = context.getBean("roomController", RoomController.class);
        reserveController = context.getBean("reserveController", ReserveController.class);

        while (true) {
            System.out.println(
                    "1. List all rooms \n" +
                            "2. List reserved rooms \n" +
                            "3. Log in \n" +
                            "4. Register "
            );

            int key = scanner.nextInt();

            switch (key) {
                case 1:
                    roomController.getAllRooms();
                    break;
                case 2:
                    reserveController.getAllResRoom();
                    break;
                case 3:
                    System.out.println("Employee id:");
                    Integer id = scanner.nextInt();
                    System.out.println("Password:");
                    String pwd = scanner.next();

                    if (employeeController.login(id, pwd)) {
                        while (true) {
                            System.out.println(
                                    "1. Reserve room \n" +
                                            "2. Remove reserves \n" +
                                            "3. List reserves \n" +
                                            "4. Log out"
                            );
                            int key2 = scanner.nextInt();

                            switch (key2) {
                                case 1:
                                    roomController.getAllRooms();
                                    System.out.println("Enter room number:");
                                    String room = scanner.next();
                                    System.out.println("Enter date from: format(yyyy-mm-dd hh:mm:ss[.ff])");
                                    scanner.nextLine();
                                    Timestamp date = Timestamp.valueOf(scanner.nextLine());
                                    System.out.println("Enter date until: format(yyyy-mm-dd hh:mm:ss[.ff])");
                                    Timestamp toDate = Timestamp.valueOf(scanner.nextLine());
                                    reserveController.addReserve(new ReservedRooms(id, room, date, toDate));
                                    break;
                                case 2:
                                    int cnt = 1;
                                    for (ReservedRooms r : reserveController.getReservesById(id)) {
                                        System.out.println(cnt + ". " + r);
                                    }

                                    int rem = scanner.nextInt();
                                    reserveController.removeReserve(reserveController.getReservesById(id).get(rem - 1));
                                    break;
                                case 3:
                                    for (ReservedRooms r : reserveController.getReservesById(id)) {
                                        System.out.println(r);
                                    }
                            }

                            if (key2 == 4)
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter id: ");
                    Integer empid = scanner.nextInt();
                    System.out.println("Enter name: ");
                    String name = scanner.next();
                    System.out.println("Enter password:");
                    String passw = scanner.next();

                    employeeController.addEmployee(new Employee(empid, name, passw));

            }
        }

    }
}
