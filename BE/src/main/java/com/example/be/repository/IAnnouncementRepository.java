package com.example.be.repository;

import com.example.be.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAnnouncementRepository extends JpaRepository<Announcement, Long> {
}
