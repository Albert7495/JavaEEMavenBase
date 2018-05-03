package mx.com.cinepolis.scheduler.service.impl;

import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.service.GitHubService;


public class GitHubServiceImpl implements GitHubService {

	@Override
	public GitHubUserTO getGitHubUser(String login) {
		
		GitHubUserTO gitHubUserTO = new GitHubUserTO();
		
		gitHubUserTO.setLogin(login);
		gitHubUserTO.setName("Alberto");
		gitHubUserTO.setUrl("myImage");
		gitHubUserTO.setFollowers(1);
		gitHubUserTO.setFollowing(3);
	       
	        return gitHubUserTO;
	}

	@Override
	public GitHubUserTO getValidateUSer(String login, String contra) {
		
		GitHubUserTO gitHubUserTO = new GitHubUserTO();
		
		if(login.equals("ALR") && contra.equals("alr")) {
		
			gitHubUserTO.setLogin(login);
			gitHubUserTO.setName("Alberto");
			gitHubUserTO.setUrl("myImage");
			gitHubUserTO.setFollowers(1);
			gitHubUserTO.setFollowing(3);
			gitHubUserTO.setPass(true);
		
		}
	    
	   return gitHubUserTO;
		
	}

	@Override
	public void setGitHubUser(GitHubUserTO gitHubUserTO) {
	
	//	System.out.println(gitHubUserTO.getName());
		
	}	
}
