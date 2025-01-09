package org.example.cryptoautomationpractice.service;

import lombok.RequiredArgsConstructor;
import org.example.cryptoautomationpractice.http.SlackHttpClient;
import org.example.cryptoautomationpractice.http.UpbitHttpClient;
import org.example.cryptoautomationpractice.http.UpbitTickerDto;
import org.example.cryptoautomationpractice.repository.ReportHistoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpbitSlackService {
    private final SlackHttpClient slackHttpClient;
    private final UpbitHttpClient upbitHttpClient;
    private final ReportHistoryRepository repository;

    public void execute(String market) {
        // upbit
        UpbitTickerDto tickerByMarket = upbitHttpClient.getTickerByMarket(market);

        // slack
        StringBuilder sb = new StringBuilder();
        sb.append("[실시간 데이터] ");
        sb.append(market);
        sb.append(" price = ");
        sb.append(tickerByMarket.getTrade_price());
        slackHttpClient.send(sb.toString());

        repository.save(market, String.valueOf(tickerByMarket.getTrade_price()));
    }
}
