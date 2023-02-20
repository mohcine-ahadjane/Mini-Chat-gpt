package keiken.longlifelearners.backend.mappers;

import keiken.longlifelearners.backend.dtos.HistoryPageDTO;
import keiken.longlifelearners.backend.entities.HistoryPage;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class HistoryPageMapper {
    public HistoryPageDTO fromHistoryPage(HistoryPage historyPage){
        HistoryPageDTO historyPageDTO = new HistoryPageDTO();
        BeanUtils.copyProperties(historyPage, historyPageDTO);
        return historyPageDTO;
    }
    public HistoryPage fromHistoryPageDTO(HistoryPageDTO historyPageDTO){
        HistoryPage historyPage = new HistoryPage();
        BeanUtils.copyProperties(historyPageDTO, historyPage);
        return historyPage;
    }
}
