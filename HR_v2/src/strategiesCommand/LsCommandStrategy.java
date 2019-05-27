package strategiesCommand;

import models.Resource;
import validations.Validator;

public class LsCommandStrategy implements CommandStrategy {
	private static LsCommandStrategy singleInstance = null;
	private String str = new String("");

	private LsCommandStrategy() {
	}

	public static LsCommandStrategy getInstance() {
		if (singleInstance == null) {
			singleInstance = new LsCommandStrategy();
		}

		return singleInstance;
	}

	public String execute(Resource currentDirectory, String[] args) {
		try {
			Validator.genCheckIfCommandItsOK(args, 1);
		} catch (Exception e) {
			return e.getMessage();
		}
		
		str = "";

		for (Resource r : currentDirectory.getResourcesList()) {
			str = str + r.getName() + "\n";
		}

		str = str + "\n";

		return str;
	}
}
