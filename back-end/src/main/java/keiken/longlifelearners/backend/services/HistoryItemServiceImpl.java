package keiken.longlifelearners.backend.services;

import keiken.longlifelearners.backend.dtos.HistoryItemDTO;
import keiken.longlifelearners.backend.entities.HistoryItem;
import keiken.longlifelearners.backend.exceptions.ItemNotFoundException;
import keiken.longlifelearners.backend.exceptions.PageNotFoundException;
import keiken.longlifelearners.backend.mappers.HistoryItemMapper;
import keiken.longlifelearners.backend.repositories.HistoryItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class HistoryItemServiceImpl implements HistoryItemService {
    private HistoryItemRepository itemRepository;
    private HistoryItemMapper itemMapper;

    @Override
    public HistoryItem saveItem(HistoryItem item) {

        log.info("⌛ saving item... ");
        HistoryItem savedItem = itemRepository.save(item);
        log.info("✔ item saved ");
        return savedItem;
    }

    @Override
    public HistoryItemDTO saveItem(HistoryItemDTO itemDTO) {
        log.info("⌛ saving item... ");
        HistoryItem item =itemMapper.fromHistoryItemDTO(itemDTO);
        HistoryItem savedItem = itemRepository.save(item);
        log.info("✔ item saved ");
        return itemMapper.fromHistoryItem(savedItem);
    }

    @Override
    public List<HistoryItemDTO> getPageItems(Long pageId) throws PageNotFoundException{
        log.info("✔ Got the list of items !");
        List<HistoryItem> items = itemRepository.findByHistoryPageIdOrderByCreatedAtAsc(pageId);
        if(items==null) throw  (new PageNotFoundException("Page history with id "+ pageId + " is not found"));
        List<HistoryItemDTO> itemDTOS = items.stream().map(item -> itemMapper.fromHistoryItem(item)).collect(Collectors.toList());
        return itemDTOS;
    }

    @Override
    public List<HistoryItemDTO> listItems() {
        log.info("✔ Got the list of items !");
        List<HistoryItem> items = itemRepository.findAll();
        List<HistoryItemDTO> itemDTOS = items.stream().map(item -> itemMapper.fromHistoryItem(item)).collect(Collectors.toList());
        return itemDTOS;
    }

    @Override
    public HistoryItemDTO getItem(Long itemId) throws ItemNotFoundException {
        HistoryItem item = itemRepository.findById(itemId).orElseThrow(() -> new ItemNotFoundException("Item with id "+ itemId + " is not found"));
        return itemMapper.fromHistoryItem(item);
    }
}
