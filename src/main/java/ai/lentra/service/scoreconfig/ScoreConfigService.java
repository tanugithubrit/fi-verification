package ai.lentra.service.scoreconfig;

import ai.lentra.dto.ScoreConfig.ScoreConfigDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScoreConfigService {
    public List<ScoreConfigDTO> getAllFieldScoreFields();

    public void updateScoreFields(ScoreConfigDTO scoreConfigDTO);



}
