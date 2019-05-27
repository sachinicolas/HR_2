package validations;

import models.Directory;
import models.File;
import models.Resource;

public class Validator {
	public static void genCheckIfCommandItsOK(String[] commandWithArgs, int strCount) throws Exception {
		if (commandWithArgs.length != strCount) {
			throw new Exception("Error in the command syntax. Please check that you are writing it OK." + "\n\n");
		}
	}
	
	public static void cdCheckIfBackIsNotNull(Resource currentDirectory) throws Exception {
		if (currentDirectory.getContainer() == null) {
			throw new Exception("");
		}
	}

	public static void cdCheckIfNextIsADirectory(Resource currentDirectory, String dirName) throws Exception {
		boolean dirFound = false;
		
		for (Resource r : currentDirectory.getResourcesList()) {
			if (r.getName().equals(dirName) && r instanceof Directory) {
				dirFound = true;
				
				break;
			}
		}
		
		if (dirFound == false) {
			throw new Exception("Cannot go into that resource because it is not a Directory." + "\n\n");
		}
	}

	public static void mkdirCheckIfNewIsInexistent(Resource currentDirectory, String newDirName) throws Exception {
		for (Resource r : currentDirectory.getResourcesList()) {
			if (r.getName().equals(newDirName) && r instanceof Directory) {
				throw new Exception("Cannot create that directory because already exists one with its name." + "\n\n");
			}
		}
	}
	
	public static void touchCheckIfNewIsInexistent(Resource currentDirectory, String newFileName) throws Exception {
		for (Resource r : currentDirectory.getResourcesList()) {
			if (r.getName().equals(newFileName) && r instanceof File) {
				throw new Exception("Cannot create that file because already exists one with its name." + "\n\n");
			}
		}
	}
}
