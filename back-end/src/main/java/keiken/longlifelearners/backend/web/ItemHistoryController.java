package keiken.longlifelearners.backend.web;

import keiken.longlifelearners.backend.dtos.HistoryItemDTO;
import keiken.longlifelearners.backend.exceptions.ItemNotFoundException;
import keiken.longlifelearners.backend.exceptions.PageNotFoundException;
import keiken.longlifelearners.backend.services.HistoryItemService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api")
@CrossOrigin("*")
public class ItemHistoryController {
    private HistoryItemService itemService;
    @GetMapping("/items/{itemId}")
    public HistoryItemDTO findItem(@PathVariable("itemId") Long ItemId) throws ItemNotFoundException {
        return itemService.getItem(ItemId);
    }
    @GetMapping("/items")
    public List<HistoryItemDTO> getAllItems(){
        return itemService.listItems();
    }
    @PostMapping("/items")
    public HistoryItemDTO saveItem(@RequestBody HistoryItemDTO itemDTO){
        return itemService.saveItem(itemDTO);
    }
    @GetMapping("/page/{pageId}")
    public HistoryItemDTO pageItemsList(@PathVariable("pageId") Long pageId) throws PageNotFoundException {
        return (HistoryItemDTO) itemService.getPageItems(pageId);
    }



}
