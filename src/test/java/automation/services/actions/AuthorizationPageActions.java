package automation.services.actions;

import automation.services.core.BaseAction;
import automation.services.dto.GitUserDTO.getDTO.GitUserDTO;

import java.util.Map;

public class AuthorizationPageActions extends BaseAction {
    public static GitUserDTO getUser(Map<String, String> headers, Map<String, String> queryParameters, String url) {
        headers.put("Accept", "application/vnd.github+json");
        headers.put("X-GitHub-Api-Version", "2022-11-28");
        return BaseAction.get(url,
                queryParameters,
                headers,
                GitUserDTO.class);
    }

    public static GitUserDTO postUser(Map<String, String> headers, Map<String, String> queryParameters, Object object, String url) {
        headers.put("Accept", "application/vnd.github+json");
        headers.put("X-GitHub-Api-Version", "2022-11-28");
        return BaseAction.post(url,
                queryParameters,
                headers, object,
                GitUserDTO.class);
    }

}
