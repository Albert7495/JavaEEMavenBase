package mx.com.cinepolis.scheduler.commons.to;

public class GitHubUserTO {
	
	private String login;
	private String name;
	private String url;
	private int followers;
	private int following;
	private int contra;
	private boolean pass=false;
	
	
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	public int getContra() {
		return contra;
	}
	public void setContra(int contra) {
		this.contra = contra;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public int getFollowing() {
		return following;
	}
	public void setFollowing(int following) {
		this.following = following;
	}
	
	
}
