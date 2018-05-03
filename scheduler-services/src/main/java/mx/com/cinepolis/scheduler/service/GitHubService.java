package mx.com.cinepolis.scheduler.service;
import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;;



public interface GitHubService {

	GitHubUserTO getGitHubUser(String login);
	
	GitHubUserTO getValidateUSer(String login, String contra);
	
	void setGitHubUser(GitHubUserTO gitHubUserTO);
}
