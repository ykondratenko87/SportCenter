package by.tms.sportcenter.service;

import by.tms.sportcenter.entity.User;

import by.tms.sportcenter.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
//@RequiredArgsConstructor
public class UserService {


    @Autowired
    private UserRepository userRepository;

//    public void add(User user) {
//        repository.add(user);
//    }



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
//
//    public void delete(User user) {
//        repository.delete(user);
//    }
//
//    public void addService(Service service) {
//        serviceRepository.save(service);
//    }
//
//    public List<Service> getAllServices() {
//        return serviceRepository.getAll();
//    }
}