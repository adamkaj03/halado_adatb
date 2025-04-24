package com.adam.buzas.onlab.main.services;

import com.adam.buzas.onlab.main.model.ArchiveLog;
import com.adam.buzas.onlab.main.model.Book;
import com.adam.buzas.onlab.main.repository.ArchiveLogRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArchiveService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ArchiveLogRepository archiveLogRepository;

    @Transactional
    public void archiveOrdersFromYear(int year) {
        entityManager.createNativeQuery("CALL archive_orders_by_year(:year)")
                .setParameter("year", year)
                .executeUpdate();
    }

    public List<ArchiveLog> getArchiveLogs() {
        List<ArchiveLog> list = new ArrayList<>();
        for(ArchiveLog actLog : archiveLogRepository.findAll()){
            list.add(actLog);
        }
        return list;
    }


}
