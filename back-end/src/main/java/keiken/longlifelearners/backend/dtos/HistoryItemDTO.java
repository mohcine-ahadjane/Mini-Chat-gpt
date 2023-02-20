package keiken.longlifelearners.backend.dtos;

import keiken.longlifelearners.backend.entities.HistoryPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryItemDTO {
    private Long id;
    private HistoryPage historyPage;
    private String question;
    private String answer;
    private Date date;
}
