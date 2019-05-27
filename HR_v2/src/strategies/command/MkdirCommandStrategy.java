package strategies.command;

import models.Directory;
import models.Resource;

public class MkdirCommandStrategy implements CommandStrategy {
	private String str = new String("New directory maked succesfully.");
	
	public String execute(Resource currentDirectory, String[] args) {
		Resource newDir = new Directory();
		
		newDir.setName(args[1]);
		newDir.setPatch(currentDirectory.getPatch() + "/" + currentDirectory.getName());
		newDir.setContainer(currentDirectory);
		
		currentDirectory.getResourcesList().add(newDir);
		
		return str;
	}
}
