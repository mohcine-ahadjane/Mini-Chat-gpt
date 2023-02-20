package keiken.longlifelearners.backend.services;

import keiken.longlifelearners.backend.dtos.HistoryItemDTO;
import keiken.longlifelearners.backend.entities.HistoryItem;
import keiken.longlifelearners.backend.exceptions.ItemNotFoundException;
import keiken.longlifelearners.backend.exceptions.PageNotFoundException;

import java.util.List;

public interface HistoryItemService {
    HistoryItem saveItem(HistoryItem item);
    HistoryItemDTO saveItem(HistoryItemDTO itemDTO);

    List<HistoryItemDTO> getPageItems( Long pageId) throws PageNotFoundException;
    List<HistoryItemDTO> listItems();

    HistoryItemDTO getItem(Long itemId) throws ItemNotFoundException;
}
