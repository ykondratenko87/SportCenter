package by.tms.sportcenter;

import by.tms.sportcenter.config.HibernateJavaConfig;
import by.tms.sportcenter.entity.Room;
import by.tms.sportcenter.entity.Service;
import by.tms.sportcenter.entity.User;
import by.tms.sportcenter.entity.UserStatus;
import by.tms.sportcenter.service.RoomService;
import by.tms.sportcenter.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляры сервисов UserService и RoomService
        UserService userService = new UserService();
        RoomService roomService = new RoomService();

        // Создаем пользователя
        User user = new User();
        user.setName("Yuri");
        user.setSurname("Kondratenko");
        user.setAge(36);
        user.setPhoneNumber("125776789");
        user.setLastVisitDate(java.time.LocalDate.now());
        user.setStatus(UserStatus.ACTIVE);
        user.setSpentAmount(BigDecimal.valueOf(0));

        // Добавляем пользователя через UserService
        userService.add(user);
        System.out.println("Клиент добавлен.");

        // Получаем и выводим список пользователей
        List<User> users = userService.getAllUsers();
        System.out.println("Список пользователей:");
        for (User u : users) {
            System.out.println(u);
        }

        // Удаляем пользователя
        userService.delete(user);
        System.out.println("Клиент удален.");

        // Меняем статус пользователя
        userService.changeStatus(user, UserStatus.BLOCKED);
        System.out.println("Статус изменен на BLOCKED.");

        // Обновляем дату последнего посещения пользователя
        userService.updateLastVisitDate(user);
        System.out.println("Дата последнего посещения обновлена.");

        // Получаем пользователя через Hibernate
        SessionFactory sessionFactory = HibernateJavaConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        long userId = 1;
        User foundUser = session.get(User.class, userId);
        System.out.println("Найден клиент:");
        System.out.println(foundUser);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

        // Создаем услуги
        Service service1 = new Service();
        service1.setServiceName("Теннис");
        service1.setCost(BigDecimal.valueOf(100));

        Service service2 = new Service();
        service2.setServiceName("Плавание");
        service2.setCost(BigDecimal.valueOf(80));

        // Добавляем услуги через UserService
        userService.addService(service1);
        userService.addService(service2);

        // Выводим список всех услуг
        List<Service> services = userService.getAllServices();
        System.out.println("Список услуг:");
        for (Service service : services) {
            System.out.println(service.getId() + ": " + service.getServiceName() + " - " + service.getCost());
        }

        // Создаем комнаты
        Room room1 = new Room();
        room1.setRoomName("Теннисный зал");
        room1.setIdentificationNumber("T001");
        room1.setMaxCapacity(10);
        room1.setStatus("Активен");
        room1.setHourlyRate(BigDecimal.valueOf(50));

        Room room2 = new Room();
        room2.setRoomName("Бассейн");
        room2.setIdentificationNumber("P001");
        room2.setMaxCapacity(20);
        room2.setStatus("На ремонте");
        room2.setHourlyRate(BigDecimal.valueOf(100));

        // Добавляем комнаты через RoomService
        roomService.addRoom(room1);
        roomService.addRoom(room2);

        // Выводим список всех комнат
        List<Room> rooms = roomService.getAllRooms();
        System.out.println("Список предоставляемых помещений:");
        for (Room room : rooms) {
            System.out.println(room.getId() + ": " + room.getRoomName() + " - " + room.getHourlyRate() + " за 1 час");
        }
    }
}