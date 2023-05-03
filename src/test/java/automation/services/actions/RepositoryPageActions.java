package automation.services.actions;

import automation.services.core.BaseAction;
import automation.services.dto.BaseResponseDTO;
import automation.services.dto.repoDTO.getDTO.GithubRepoDTO;
import automation.services.dto.repoDTO.patchDTO.UpdateGitHubDTO;

import java.util.Map;

public class RepositoryPageActions extends BaseAction {
    public static GithubRepoDTO postRepository(Map<String, String> headers, Map<String, String> queryParameters, Object object, String url) {
        headers.put("Accept", "application/vnd.github+json");
        headers.put("X-GitHub-Api-Version", "2022-11-28");
        return BaseAction.post(url,
                queryParameters,
                headers, object,
                GithubRepoDTO.class);
    }

    public static BaseResponseDTO deleteRepo(Map<String, String> headers, String url) {
        headers.put("Accept", "application/vnd.github+json");
        headers.put("X-GitHub-Api-Version", "2022-11-28");
        return BaseAction.delete(url, headers, BaseResponseDTO.class);
    }

    public static UpdateGitHubDTO updateGitHubDTO(Map<String, String> headers, Map<String, String> queryParameters, Object object, String url) {
        headers.put("Accept", "application/vnd.github+json");
        headers.put("X-GitHub-Api-Version", "2022-11-28");
        return BaseAction.patch(url,
                queryParameters,
                headers,
                object,
                UpdateGitHubDTO.class);
    }
}
