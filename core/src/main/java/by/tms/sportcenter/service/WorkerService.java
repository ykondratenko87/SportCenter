package by.tms.sportcenter.service;

import by.tms.sportcenter.entity.Worker;
import by.tms.sportcenter.repository.WorkerRepository;
import by.tms.sportcenter.repository.impl.WorkerRepositoryImpl;
import by.tms.sportcenter.repository.javaConfig.WorkerRepositoryConfig;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    private final WorkerRepository repository;

    public WorkerService() {
        this.repository = new WorkerRepositoryConfig();
    }

    public void add(Worker worker) {
        repository.add(worker);
    }
}