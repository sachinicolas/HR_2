package strategies.command;

import models.Resource;

public class PwdCommandStrategy implements CommandStrategy {
	private String str = new String("");
	
	public String execute(Resource currentDirectory, String[] args) {
		str = currentDirectory.getPatch() + "/" + currentDirectory.getName() + "/";
		
		return str;
	}
}
