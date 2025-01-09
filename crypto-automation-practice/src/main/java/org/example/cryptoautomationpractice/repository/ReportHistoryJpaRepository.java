package org.example.cryptoautomationpractice.repository;

import org.example.cryptoautomationpractice.entity.ReportHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportHistoryJpaRepository extends JpaRepository<ReportHistory, Integer> {
}
