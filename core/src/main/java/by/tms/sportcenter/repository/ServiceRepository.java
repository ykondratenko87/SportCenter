package by.tms.sportcenter.repository;

import by.tms.sportcenter.entity.Service;

import java.util.List;

public interface ServiceRepository {
    void save(Service service);

    List<Service> getAll();
}