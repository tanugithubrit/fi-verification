package ai.lentra.controller;


import ai.lentra.dto.CommitmentDTO;
import ai.lentra.modal.Commitment;
import ai.lentra.service.CommitmentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static ai.lentra.common.ResponeGen.getResponse;


@RestController
@RequestMapping(value="/api")
@Transactional
@Validated
public class CommitmentController {
    @Autowired
    CommitmentService commitmentService;

    @Operation(summary = "Save familyDetails record")
    @PostMapping("/commitment")
    @ResponseStatus(HttpStatus.CREATED)

    public ResponseEntity<Object> insertCommitment(@Valid @RequestBody CommitmentDTO commitmentDTO) {
        commitmentService.insertCommitment(commitmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(getResponse(201,"Commitment Details for the applicant has been added successfully ","CREATED"));

    }


    @Operation(summary = "Get familyDetails record by using id")

    @GetMapping("/commitment/{commitmentId}")
    public Optional<Commitment> getCommitmentById(@PathVariable Integer commitmentId) {
        return commitmentService.getcommitmentById(commitmentId);
    }

    @Operation(summary = "Get All familyDetails record")
    @GetMapping("/commitmentDetails")
    public List<Commitment> getCommitmentList() throws IOException {
        return commitmentService.findAll();

    }

    @Operation(summary = "Update Commitment record")
    @PutMapping("/commitment")
    public Commitment updateCommitment(@RequestBody CommitmentDTO commitmentDTO) {
        return commitmentService.updateCommitment(commitmentDTO);
    }

//    @PatchMapping("/commitment/{commitmentId}")
//    public Commitment updateCommitment(@RequestBody CommitmentDTO commitmentDTO, @PathVariable Integer commitmentId) {
//        return commitmentService.updateCommitment(commitmentDTO, commitmentId);
    }





