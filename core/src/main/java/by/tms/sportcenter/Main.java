package by.tms.sportcenter;

import by.tms.sportcenter.entity.*;
import by.tms.sportcenter.service.CustomerService;
import by.tms.sportcenter.service.UserService;
import by.tms.sportcenter.service.WorkerService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        CustomerService customerService = new CustomerService();
        WorkerService workerService = new WorkerService();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        User user = new User();
        String date = "16/08/1995";
        LocalDate localDate = LocalDate.parse(date, formatter);
        user.setName("Ivan");
        user.setSurname("Ivanov");
        user.setAddress("Timirjazeva");
        user.setBirthday(localDate);
        userService.add(user);

        Customer customer = new Customer();
        String date1 = "15/09/2010";
        String date2 = "15/09/2011";
        LocalDate localDate1 = LocalDate.parse(date1, formatter);
        LocalDate localDate2 = LocalDate.parse(date2, formatter);
        customer.setFirstVisitDate(localDate1);
        customer.setLastVisitDate(localDate2);
        String spentAmountStr = "1000.50";
        BigDecimal spentAmount = new BigDecimal(spentAmountStr);
        customer.setSpentAmount(spentAmount);
        customer.setStatus(UserStatus.ACTIVE);
        customerService.add(customer);

        Worker worker = new Worker();
        String date3 = "14/10/2009";
        String date4 = "14/10/2010";
        LocalDate localDate3 = LocalDate.parse(date3, formatter);
        LocalDate localDate4 = LocalDate.parse(date4, formatter);
        worker.setFirstWorkDay(localDate3);
        worker.setDismissal(localDate4);
        worker.setPosition("builder");
        String spentAmountStr1 = "1100.70";
        BigDecimal spentAmount1 = new BigDecimal(spentAmountStr1);
        worker.setSalary(spentAmount1);
        workerService.add(worker);
    }
}