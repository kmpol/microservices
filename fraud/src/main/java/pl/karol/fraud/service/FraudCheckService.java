package pl.karol.fraud.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.karol.fraud.model.FraudCheckHistory;
import pl.karol.fraud.repository.FraudCheckHistoryRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer(Long customerId) {
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder().isFraudster(false).customerId(customerId).createdAt(LocalDateTime.now()).build());
        return false;
    }
}
