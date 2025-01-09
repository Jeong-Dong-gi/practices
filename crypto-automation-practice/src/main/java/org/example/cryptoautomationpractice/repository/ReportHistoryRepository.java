package org.example.cryptoautomationpractice.repository;

import lombok.RequiredArgsConstructor;
import org.example.cryptoautomationpractice.entity.ReportHistory;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReportHistoryRepository {
    private final ReportHistoryJpaRepository repository;

    public void save(String market, String price) {
        repository.save(new ReportHistory(market, price));
    }
}
