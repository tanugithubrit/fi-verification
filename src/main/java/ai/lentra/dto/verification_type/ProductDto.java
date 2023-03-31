package ai.lentra.dto.verification_type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto
{
    private  long id;
    private long institutionId;
    private String profileName;
    private String productType;

}
