package strategies.command;

import models.*;

public class CdCommandStrategy implements CommandStrategy {
	public String execute(Resource currentDirectory, String[] args) {
		switch (args[1]) {
		case "..":
			currentDirectory.setName(currentDirectory.getContainer().getName());
			currentDirectory.setPatch(currentDirectory.getContainer().getPatch());
			currentDirectory.setResourcesList(currentDirectory.getContainer().getResourcesList());
			currentDirectory.setContainer(currentDirectory.getContainer().getContainer());

			break;

		default:
			Resource cdCopy = new Directory();
			
			cdCopy.setContainer(currentDirectory.getContainer());
			cdCopy.setName(currentDirectory.getName());
			cdCopy.setPatch(currentDirectory.getPatch());
			cdCopy.setResourcesList(currentDirectory.getResourcesList());
			
			for (Resource r : currentDirectory.getResourcesList()) {
				if (r.getName().equals(args[1])) {					
					currentDirectory.setName(r.getName());
					currentDirectory.setPatch(r.getPatch());
					currentDirectory.setContainer(cdCopy);
					currentDirectory.setResourcesList(r.getResourcesList());
					
					break;
				}
			}
		}

		return new String("Directory patch changed succesfully.");
	}
}
