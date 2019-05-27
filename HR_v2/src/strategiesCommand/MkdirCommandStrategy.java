package strategiesCommand;

import models.Directory;
import models.Resource;
import validations.Validator;

public class MkdirCommandStrategy implements CommandStrategy {
	private static MkdirCommandStrategy singleInstance = null;
	private String str = new String("New directory maked succesfully.");

	private MkdirCommandStrategy() {
	}

	public static MkdirCommandStrategy getInstance() {
		if (singleInstance == null) {
			singleInstance = new MkdirCommandStrategy();
		}

		return singleInstance;
	}

	public String execute(Resource currentDirectory, String[] args) {
		try {
			Validator.genCheckIfCommandItsOK(args, 2);
			Validator.mkdirCheckIfNewIsInexistent(currentDirectory, args[1]);

			Resource newDir = new Directory();

			newDir.setName(args[1]);
			newDir.setPatch(currentDirectory.getPatch() + "/" + currentDirectory.getName());
			newDir.setContainer(currentDirectory);

			currentDirectory.getResourcesList().add(newDir);
		} catch (Exception e) {
			return e.getMessage();
		}

		str = "";

		return str;
	}
}
