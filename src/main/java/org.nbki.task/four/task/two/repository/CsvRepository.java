package org.nbki.task.four.task.two.repository;

import org.nbki.task.four.task.two.model.CsvModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsvRepository extends JpaRepository<CsvModel, Long> {

    @Query(value = "SELECT * FROM nbki.csv order by fid", nativeQuery = true)
    List<CsvModel> findAllByOrderFid();
}
