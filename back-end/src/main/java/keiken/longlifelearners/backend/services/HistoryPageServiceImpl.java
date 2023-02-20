package keiken.longlifelearners.backend.services;

import keiken.longlifelearners.backend.dtos.HistoryPageDTO;
import keiken.longlifelearners.backend.entities.HistoryPage;
import keiken.longlifelearners.backend.mappers.HistoryPageMapper;
import keiken.longlifelearners.backend.repositories.HistoryPageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class HistoryPageServiceImpl implements HistoryPageService {
    private HistoryPageRepository pageRepository;
    private HistoryPageMapper pageMapper;
    @Override
    public HistoryPage savePage(HistoryPage page) {
        log.info("⌛ saving page ... ");
        HistoryPage savedPage = pageRepository.save(page);
        log.info("✔ page saved ");
        return savedPage;
    }

    @Override
    public HistoryPageDTO savePage(HistoryPageDTO pageDTO) {
        log.info("⌛ saving page ... ");
        HistoryPage page = pageMapper.fromHistoryPageDTO(pageDTO);
        HistoryPage savedPage = pageRepository.save(page);
        log.info("✔ page saved ");
        return pageMapper.fromHistoryPage(savedPage);
    }


    @Override
    public List<HistoryPageDTO> getAllPagesHistory() {
        log.info("✔ Got the list of history pages !");
        List<HistoryPage> pages = pageRepository.findAll();
        List<HistoryPageDTO> pageDTOS = pages.stream().map(page -> pageMapper.fromHistoryPage(page)).collect(Collectors.toList());
        return null;
    }
}
