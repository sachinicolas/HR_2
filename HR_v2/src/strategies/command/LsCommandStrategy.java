package strategies.command;

import models.Resource;

public class LsCommandStrategy implements CommandStrategy {
	private String str = new String("");
	
	public String execute(Resource currentDirectory, String[] args) {		
		for (Resource r : currentDirectory.getResourcesList()) {
			str = str + r.getName() + "       ";
		}
		
		return str;
	}
}
