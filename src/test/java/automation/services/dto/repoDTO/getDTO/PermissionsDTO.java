package automation.services.dto.repoDTO.getDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionsDTO {
    private boolean admin;
    private boolean maintain;
    private boolean push;
    private boolean triage;
    private boolean pull;
}
