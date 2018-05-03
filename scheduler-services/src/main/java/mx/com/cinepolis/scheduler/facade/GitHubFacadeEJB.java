package mx.com.cinepolis.scheduler.facade;

import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.service.GitHubService;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@LocalBean
public class GitHubFacadeEJB {

    @Inject
    GitHubService gitHubService;

    public GitHubUserTO getSimpleUserGitHub(String login)
    {
        return gitHubService.getGitHubUser(login);
    }
    
    public GitHubUserTO getValidateUSer(String login, String contra)
    {
        return gitHubService.getValidateUSer(login, contra);
    }
    
    public void setGitHubUser(GitHubUserTO gitHubUserTO) {
    	
    	gitHubService.setGitHubUser(gitHubUserTO);
    }
    
}
