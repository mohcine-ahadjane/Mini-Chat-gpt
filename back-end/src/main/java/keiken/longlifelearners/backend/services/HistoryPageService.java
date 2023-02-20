package keiken.longlifelearners.backend.services;

import keiken.longlifelearners.backend.dtos.HistoryPageDTO;
import keiken.longlifelearners.backend.entities.HistoryPage;

import java.util.List;

public interface HistoryPageService {
    HistoryPage savePage(HistoryPage page);
    HistoryPageDTO savePage(HistoryPageDTO pageDTO);
    List<HistoryPageDTO> getAllPagesHistory();

}
