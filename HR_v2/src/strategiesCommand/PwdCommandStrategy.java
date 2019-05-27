package strategiesCommand;

import models.Resource;
import validations.Validator;

public class PwdCommandStrategy implements CommandStrategy {
	private static PwdCommandStrategy singleInstance = null;
	private String str = new String("");

	private PwdCommandStrategy() {
	}

	public static PwdCommandStrategy getInstance() {
		if (singleInstance == null) {
			singleInstance = new PwdCommandStrategy();
		}

		return singleInstance;
	}

	public String execute(Resource currentDirectory, String[] args) {
		try {
			Validator.genCheckIfCommandItsOK(args, 1);
		} catch (Exception e) {
			return e.getMessage();
		}
		
		str = currentDirectory.getPatch() + "/" + currentDirectory.getName() + "/";

		str = str + "\n\n";

		return str;
	}
}
