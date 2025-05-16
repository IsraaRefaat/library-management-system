package com.esraa.librarymanagementsystem.repository;

import com.esraa.librarymanagementsystem.logging.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityLogRepo extends JpaRepository<ActivityLog, Integer> {
}
