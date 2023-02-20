package keiken.longlifelearners.backend.web;

import keiken.longlifelearners.backend.dtos.HistoryPageDTO;
import keiken.longlifelearners.backend.services.HistoryPageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api")
@CrossOrigin("*")
public class PageHistoryController {
    private HistoryPageService pageService;
    @PostMapping("/pages")
    public HistoryPageDTO savePage(@RequestBody HistoryPageDTO page){
        return pageService.savePage(page);
    }

    @GetMapping("/pages")
    public List<HistoryPageDTO> getAllPagesHistory(){
        return pageService.getAllPagesHistory();
    }

}
