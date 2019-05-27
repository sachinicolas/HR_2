package strategiesCommand;

import models.Resource;

public interface CommandStrategy {
	public String execute(Resource currentDirectory, String[] args);
}
