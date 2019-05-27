package strategies.command;

import models.Resource;

public class PwdCommandStrategy implements CommandStrategy {
	public String execute(Resource currentDirectory, String[] args) {
		return currentDirectory.getPatch() + "/" + currentDirectory.getName() + "/";
	}
}
