package ai.lentra.controller;
import ai.lentra.commons.EndPointReferer;
import ai.lentra.commons.JsonUtils1;
import ai.lentra.dto.ResponseDto;
import ai.lentra.dto.SummaryDto;
import ai.lentra.exceptions.ResidenceException;
import ai.lentra.modal.summary.Summary;
import ai.lentra.service.SummaryService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import static ai.lentra.commons.EndPointReferer.*;
import static ai.lentra.commons.ErrorMessage.SUMMARY_NOT_FOUND;

@RestController
@RequestMapping(
        value = EndPointReferer.SUMMARY,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SummaryController {
    private static final Logger logger =  LoggerFactory.getLogger(SummaryController.class);

    @Autowired
    private JsonUtils1 jsonUtils;
    @Autowired
    SummaryService summaryService;
    @Operation(summary = "Get all summary")
    @GetMapping(SUMMARY_ALL)
    public ResponseEntity<List<SummaryDto>> getAllSummaries() {
        logger.info("Started API call to get all Summaries");
        List<Summary> summaryList = summaryService.findAll();
        List<SummaryDto> summaryDtoList=

                summaryList.stream()
                        .map(addr -> jsonUtils.mapper().convertValue(addr, SummaryDto.class)).collect(Collectors.toList());
        if (!summaryList.isEmpty()) {

            return  ResponseEntity.status(HttpStatus.OK).body(summaryDtoList);
        }
        throw new EntityNotFoundException(SUMMARY_NOT_FOUND);
    }

    @Operation(summary = "Add Summary")
    @PostMapping(SUMMARY_ADD)
    public ResponseEntity<?> createSummary(@RequestBody SummaryDto summaryDto) throws ResidenceException, ParseException {
        logger.info("Started API request for Creating Summary...");
        Summary summary = jsonUtils.mapper().convertValue(summaryDto, Summary.class);
        logger.info("Done Creating Summary...");
        return summaryService.addSummary(summary);

    }

    @Operation(summary = "Get Single Summary")
    @GetMapping(SUMMARY_ID)
    public ResponseEntity<?> getSummary(@PathVariable("applicantId") Long applicantId) {
        logger.info("Started API call to get summary details for Id {} ...", applicantId);
        Summary summary = null;
        try {
            summary = summaryService.findSummaryByAppId(applicantId);
        }
        catch (EntityNotFoundException e)
        {
            ResponseDto responseDto =new ResponseDto();
            responseDto.setMessage(e.getMessage());
            responseDto.setStatus("NOT_FOUND");
            responseDto.setCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(summary,HttpStatus.OK);
    }


    @Operation(summary = "Update Single Summary")
    @PutMapping(SUMMARY_ID + SUMMARY_UPDATE)
    public ResponseEntity<?> updateSummary(@PathVariable Long applicantId,  @RequestBody SummaryDto summaryDto) {
        logger.info("Started API call to get summary details for Id {} ...", applicantId);
        Summary summary;
        try {
            summary = summaryService.findSummaryByAppId(applicantId);
            Summary summaryCopy = jsonUtils.mapper().convertValue(summaryDto, Summary.class);
            summaryService.updateService(summaryCopy,summary);
            return new ResponseEntity<>(summary, HttpStatus.OK);
        }catch (EntityNotFoundException | ParseException e)
        {
            ResponseDto responseDto =new ResponseDto();
            responseDto.setMessage(e.getMessage());
            responseDto.setStatus("NOT_FOUND");
            responseDto.setCode(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
        }





    }

}
