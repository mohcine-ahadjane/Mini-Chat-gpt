package keiken.longlifelearners.backend.repositories;

import keiken.longlifelearners.backend.entities.HistoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {

    @Query("SELECT item FROM HistoryItem item WHERE item.historyPage.id = :pageId ORDER BY item.createdAt ASC")
    List<HistoryItem> findByHistoryPageIdOrderByCreatedAtAsc(@Param("pageId") Long pageId);
}
