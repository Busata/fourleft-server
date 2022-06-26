package io.busata.fourleft.leaderboards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BoardEntryRepository extends JpaRepository<BoardEntry, UUID> {

    @Query("select distinct name from BoardEntry")
    List<String> findDistinctNames();
}
