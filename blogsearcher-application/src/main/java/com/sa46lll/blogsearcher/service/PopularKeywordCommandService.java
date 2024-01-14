package com.sa46lll.blogsearcher.service;

import com.sa46lll.blogsearcher.domain.SearchHistory;
import com.sa46lll.blogsearcher.domain.SearchKeyword;
import com.sa46lll.blogsearcher.port.in.SavePopularKeywordUseCase;
import com.sa46lll.blogsearcher.port.in.UpdateSearchKeywordUseCase;
import com.sa46lll.blogsearcher.port.out.ReadSearchHistoryPersistencePort;
import com.sa46lll.blogsearcher.port.out.WritePopularKeywordCachePort;
import com.sa46lll.blogsearcher.port.out.ReadSearchKeywordPersistencePort;
import com.sa46lll.blogsearcher.port.out.WriteSearchKeywordPersistencePort;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PopularKeywordCommandService implements UpdateSearchKeywordUseCase, SavePopularKeywordUseCase {

    private final ReadSearchKeywordPersistencePort readSearchKeywordPersistencePort;
    private final WriteSearchKeywordPersistencePort writeSearchKeywordPersistencePort;
    private final ReadSearchHistoryPersistencePort readSearchHistoryPersistencePort;
    private final WritePopularKeywordCachePort writePopularKeywordCachePort;

    public PopularKeywordCommandService(final WriteSearchKeywordPersistencePort writeSearchKeywordPersistencePort,
                                        final ReadSearchKeywordPersistencePort readSearchKeywordPersistencePort,
                                        final ReadSearchHistoryPersistencePort readSearchHistoryPersistencePort,
                                        final WritePopularKeywordCachePort writePopularKeywordCachePort) {
        this.writeSearchKeywordPersistencePort = writeSearchKeywordPersistencePort;
        this.readSearchKeywordPersistencePort = readSearchKeywordPersistencePort;
        this.readSearchHistoryPersistencePort = readSearchHistoryPersistencePort;
        this.writePopularKeywordCachePort = writePopularKeywordCachePort;
    }

    @Override
    public void update(String keyword) {
        SearchKeyword searchKeyword = readSearchKeywordPersistencePort.findByKeyword(keyword)
                .orElse(new SearchKeyword(keyword));

        searchKeyword.incrementCount();
        writeSearchKeywordPersistencePort.save(searchKeyword);
    }

    @Override
    @Scheduled(cron = "0 */5 * * * *")
    public void save() {
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();

        Map<String, Long> keywords = readSearchHistoryPersistencePort.findByCreatedDateBetween(start, end).stream()
                .collect(Collectors.groupingBy(SearchHistory::getKeyword, Collectors.counting()));

        List<String> sortedKeywords = keywords.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(keyword -> keyword.getKey() + ":" + keyword.getValue())
                .toList();

        System.out.println(sortedKeywords.size());

        writePopularKeywordCachePort.save(sortedKeywords);
    }
}
