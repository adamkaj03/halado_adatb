package com.adam.buzas.onlab.main.repository;

import com.adam.buzas.onlab.main.model.ArchiveLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchiveLogRepository extends CrudRepository<ArchiveLog, Integer> {

}
