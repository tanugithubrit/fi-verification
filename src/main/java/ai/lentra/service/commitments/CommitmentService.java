package ai.lentra.service.commitments;


import ai.lentra.dto.CommitmentDTO;
import ai.lentra.modal.Commitment;

import java.util.List;
import java.util.Optional;

public interface CommitmentService {
    public Integer insertCommitment(CommitmentDTO commitmentDTO);

    public Commitment updateCommitment(CommitmentDTO commitmentDTO);

    public List<Commitment> findAll();


    public Optional<Commitment> getcommitmentById(Integer commitmentId);

//    Commitment updateCommitment(CommitmentDTO commitmentDTO, Integer commitmentId);
}
