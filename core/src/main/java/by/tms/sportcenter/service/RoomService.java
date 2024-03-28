package by.tms.sportcenter.service;

import by.tms.sportcenter.entity.Room;
import by.tms.sportcenter.repository.RoomRepository;
import by.tms.sportcenter.repository.impl.RoomRepositoryImpl;

import java.util.List;

public class RoomService {
    private final RoomRepository roomRepository = new RoomRepositoryImpl();

    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.getAll();
    }
}