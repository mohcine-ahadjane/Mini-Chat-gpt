package keiken.longlifelearners.backend.mappers;

import keiken.longlifelearners.backend.dtos.HistoryItemDTO;
import keiken.longlifelearners.backend.entities.HistoryItem;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class HistoryItemMapper {
    public HistoryItemDTO fromHistoryItem(HistoryItem historyItem){
        HistoryItemDTO historyItemDTO = new HistoryItemDTO();
        BeanUtils.copyProperties(historyItem, historyItemDTO);
        return historyItemDTO;
    }
    public HistoryItem fromHistoryItemDTO(HistoryItemDTO historyItemDTO){
        HistoryItem historyItem = new HistoryItem();
        BeanUtils.copyProperties(historyItemDTO, historyItem);
        return historyItem;
    }
}
