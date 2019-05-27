package strategiesCommand;

import models.*;
import validations.Validator;

public class TouchCommandStrategy implements CommandStrategy {
	private static TouchCommandStrategy singleInstance = null;
	private String str = new String("New file maked succesfully.");

	private TouchCommandStrategy() {
	}

	public static TouchCommandStrategy getInstance() {
		if (singleInstance == null) {
			singleInstance = new TouchCommandStrategy();
		}

		return singleInstance;
	}

	public String execute(Resource currentDirectory, String[] args) {
		try {
			Validator.touchCheckIfNewIsInexistent(currentDirectory, args[1]);

			Resource newFile = new File();

			newFile.setName(args[1]);
			newFile.setPatch(currentDirectory.getPatch() + "/" + currentDirectory.getName());
			newFile.setContainer(currentDirectory);
			
			currentDirectory.getResourcesList().add(newFile);
		} catch (Exception e) {
			return e.getMessage();
		}

		str = "";

		return str;
	}
}