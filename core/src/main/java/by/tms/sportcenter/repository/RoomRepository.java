package by.tms.sportcenter.repository;

import by.tms.sportcenter.entity.Room;

import java.util.List;

public interface RoomRepository {
    void save(Room room);

    List<Room> getAll();
}