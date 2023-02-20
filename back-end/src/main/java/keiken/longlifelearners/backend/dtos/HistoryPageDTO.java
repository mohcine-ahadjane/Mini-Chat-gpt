package keiken.longlifelearners.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryPageDTO {
    private Long id;
    private List<HistoryItemDTO> items;
}
