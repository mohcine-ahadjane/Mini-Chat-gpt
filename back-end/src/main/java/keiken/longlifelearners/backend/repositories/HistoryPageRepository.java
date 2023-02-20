package keiken.longlifelearners.backend.repositories;


import keiken.longlifelearners.backend.entities.HistoryPage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryPageRepository extends JpaRepository<HistoryPage, Long> {

    List<HistoryPage> findHistoryPageById(Long pageId);
}
