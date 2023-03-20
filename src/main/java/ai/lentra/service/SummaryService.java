package ai.lentra.service;

import ai.lentra.modal.summary.Summary;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface SummaryService {
    List<Summary> findAll();

    ResponseEntity<?> addSummary(Summary summary) throws ParseException;

    Summary findSummaryByAppId(Long applicantId);

    Summary updateService(Summary newSUmmary, Summary summay) throws ParseException;
}
