package keiken.longlifelearners.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HistoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private HistoryPage historyPage;
    private String question;
    private String answer;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
