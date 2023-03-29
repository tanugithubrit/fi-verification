package ai.lentra.serviceImpl.summary;



import ai.lentra.controller.ValidationController;
import ai.lentra.dto.responses.ResponseDTO;
import ai.lentra.exceptions.ResidenceException;
import ai.lentra.modal.summary.Summary;
import ai.lentra.repository.summary.SummaryRepository;
import ai.lentra.service.summary.SummaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static ai.lentra.commons.ErrorMessage.SUMMARY_NOT_FOUND;

@Service
@Transactional
public class SummaryServiceImpl implements SummaryService {
    @Autowired
    ValidationController validationController;
    @Autowired
    SummaryRepository summaryRepository;
    @Override
    public List<Summary> findAll() {
        return summaryRepository.findAll();
    }

    @Override
    public ResponseEntity<?> addSummary(Summary summary) throws ResidenceException, ParseException {

    Integer score = calculateScore(summary);
    validations(summary);
    summary.setScore(score);
        summaryRepository.save(summary);
        ResponseDTO ResponseDTO=new ResponseDTO();
        ResponseDTO.setCode(HttpStatus.CREATED);
        ResponseDTO.setMessage("Summary Details Created Successfully");
        ResponseDTO.setStatus("Created");
        new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return  ResponseEntity.status(HttpStatus.CREATED).body(ResponseDTO);
    }

    private boolean validations(Summary summary) throws ResidenceException, ParseException {
        String dateFormat = "dd/MM/yyyy, hh:mm a";
        if (summary.getRemarkDateTime() != null && validationController.isValidFormat(new SimpleDateFormat(dateFormat).parse(summary.getRemarkDateTime()), dateFormat)) {

            throw new ResidenceException("Please provide valid remark date format");


        }else if (summary.getRemarkDateTime() != null && validationController.isValidFormat(new SimpleDateFormat(dateFormat).parse(summary.getDateAndTimePerformed()), dateFormat)) {

            throw new ResidenceException("Please provide valid format for date time performed");


        }else
        if (summary.getRemarkDateTime() != null && validationController.isDateFuture(new SimpleDateFormat(dateFormat).parse(summary.getRemarkDateTime()), dateFormat)) {

                throw new ResidenceException("Please provide valid remark date");
        }
        else if (summary.getDateAndTimePerformed() != null && validationController.isDateFuture(new SimpleDateFormat(dateFormat).parse(summary.getDateAndTimePerformed()), dateFormat)) {
                throw new ResidenceException("Please provide valid date of Performed");


        } else  if (validationController.checkLength(summary.getOtherFindings()) < 0) {
            throw new ResidenceException("Please provide valid other findings value");

        } else if (validationController.checkLength(summary.getFinalScore()) < 1 || validationController.checkLength(summary.getFinalScore()) > 3) {
            throw new ResidenceException("Final score should be between 1 to 3 digits");

        } else if (summary.getRemark().length() < 50 || summary.getRemark().length() > 2000) {
            throw new ResidenceException("Remark should be between 50 to 2000 characters");

        } else if (summary.getPreparedBy().length() < 3 || summary.getPreparedBy().length() > 50) {
            throw new ResidenceException("Prepared by should be between 3 to 50 characters");

        } else if (summary.getReviewedBy().length() < 3 || summary.getReviewedBy().length() > 50) {
            throw new ResidenceException("Reviewed by should be between 3 to 50 characters");

        } else if (summary.getAgencyName() == null || summary.getAgencyName().equals("") || summary.getAgencyName().equals(" ")) {
            throw new ResidenceException("Value required for Agency Name");

        } else if (summary.getAgencyName().length() < 2 || summary.getAgencyName().length() > 50) {
            throw new ResidenceException("Agency Name by should be between 2 to 50 characters");

        } else if (summary.getRefId() == null || summary.getRefId() == 0) {
            throw new ResidenceException("Value required for Red Id");

        }
            return true;

    }
    private Integer calculateScore(Summary summary) {
        Integer score = summary.getFinalScore() + summary.getOtherFindings();
        return  score;
    }
    @Override
    public Summary findSummaryByAppId(Long applicantId) throws EntityNotFoundException {

        return   summaryRepository
                    .findByApplicantId(applicantId)
                    .orElseThrow(() -> new EntityNotFoundException(SUMMARY_NOT_FOUND + " for given Id " + applicantId));

    }

    @Override
    public Summary updateService(Summary newSummary, Summary summary) throws ParseException {
        if(newSummary.getAgencyName()!=null)
            summary.setAgencyName(newSummary.getAgencyName());
        if (newSummary.getRemark()!=null)
            summary.setRemark(newSummary.getRemark());
        if (newSummary.getPreparedBy()!=null)
            summary.setPreparedBy(newSummary.getPreparedBy());
        if (newSummary.getReviewedBy()!=null)
            summary.setReviewedBy(newSummary.getReviewedBy());
        if (newSummary.getFinalScore()!=null)
            summary.setFinalScore(newSummary.getFinalScore());
        if (newSummary.getOtherFindings()!=null)
            summary.setOtherFindings(newSummary.getOtherFindings());
        if (newSummary.getRefId()!=null)
            summary.setRefId(newSummary.getRefId());
        if (newSummary.getRemarkDateTime()!=null)
            summary.setRemarkDateTime(newSummary.getRemarkDateTime());
        if (newSummary.getDateAndTimePerformed()!=null)
            summary.setDateAndTimePerformed(newSummary.getDateAndTimePerformed());
        if (newSummary.getReviewedBy()!=null)
            summary.setReviewedBy(newSummary.getReviewedBy());

        Integer score = calculateScore(summary);
        validations(summary);
       // summary.setScore(score);
        return summaryRepository.save(summary);
    }
}
