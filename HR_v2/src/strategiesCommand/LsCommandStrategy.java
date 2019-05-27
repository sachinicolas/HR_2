package strategiesCommand;

import models.Resource;

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
		str = "";

		for (Resource r : currentDirectory.getResourcesList()) {
			str = str + r.getName() + "       ";
		}

		str = str + "\n\n";

		return str;
	}
}
