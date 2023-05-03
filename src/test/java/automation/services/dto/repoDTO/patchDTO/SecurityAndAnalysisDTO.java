package automation.services.dto.repoDTO.patchDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityAndAnalysisDTO {
        private SecretScanningDTO secret_scanning;
        private SecretScanningPushProtectionDTO secret_scanning_push_protection;
}
