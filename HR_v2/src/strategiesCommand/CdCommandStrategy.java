package strategiesCommand;

import models.*;
import validations.Validator;

public class CdCommandStrategy implements CommandStrategy {
	private static CdCommandStrategy singleInstance = null;
	private String str = new String("Directory patch changed succesfully.");

	private CdCommandStrategy() {
	}

	public static CdCommandStrategy getInstance() {
		if (singleInstance == null) {
			singleInstance = new CdCommandStrategy();
		}

		return singleInstance;
	}

	public String execute(Resource currentDirectory, String[] args) {
		try {
			Validator.genCheckIfCommandItsOK(args, 2, 2);
		} catch (Exception e) {
			return e.getMessage();
		}
		
		switch (args[1]) {
		case "..":
			try {
				Validator.cdCheckIfBackIsNotNull(currentDirectory);

				currentDirectory.setName(currentDirectory.getContainer().getName());
				currentDirectory.setPatch(currentDirectory.getContainer().getPatch());
				currentDirectory.setResourcesList(currentDirectory.getContainer().getResourcesList());
				currentDirectory.setContainer(currentDirectory.getContainer().getContainer());

				break;

			} catch (Exception e) {
				return e.getMessage();
			}

		default:
			try {				
				Validator.cdCheckIfNextIsADirectory(currentDirectory, args[1]);

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

			} catch (Exception e) {
				return e.getMessage();
			}
		}

		str = "";

		return str;
	}
}
