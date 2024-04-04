package by.tms.sportcenter.service;

import by.tms.sportcenter.entity.Service;
import by.tms.sportcenter.entity.User;
import by.tms.sportcenter.entity.UserStatus;
import by.tms.sportcenter.repository.ServiceRepository;
import by.tms.sportcenter.repository.UserRepository;
import by.tms.sportcenter.repository.impl.ServiceRepositoryImpl;
import by.tms.sportcenter.repository.impl.UserRepositoryImpl;
import by.tms.sportcenter.repository.javaConfig.UserRepositoryConfig;

import java.util.List;

public class UserService {
    private UserRepository repository;
    private final ServiceRepository serviceRepository = new ServiceRepositoryImpl();

    public UserService() {
        this.repository = new UserRepositoryConfig();
    }

    public void add(User user) {
        repository.add(user);
    }

    public List<User> getAllUsers() {
        return repository.getAllUsers();
    }

    public void delete(User user) {
        repository.delete(user);
    }

    public void addService(Service service) {
        serviceRepository.save(service);
    }

    public List<Service> getAllServices() {
        return serviceRepository.getAll();
    }
}