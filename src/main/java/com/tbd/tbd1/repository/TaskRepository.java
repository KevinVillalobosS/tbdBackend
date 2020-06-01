package com.tbd.tbd1.repository;

import java.util.List;

public interface TaskRepository {
    public List<Integer> getTasksByEmergency(int idEmergency);
}
