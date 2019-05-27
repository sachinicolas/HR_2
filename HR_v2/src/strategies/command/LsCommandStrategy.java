package strategies.command;

import models.Resource;

public class LsCommandStrategy implements CommandStrategy {
	public String execute(Resource currentDirectory, String[] args) {
		String ls = "";
		
		for (Resource r : currentDirectory.getResourcesList()) {
			ls = ls + r.getName() + "       ";
		}
		
		return ls;
	}
}
