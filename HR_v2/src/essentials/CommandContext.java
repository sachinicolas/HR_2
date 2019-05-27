package essentials;

import models.Resource;
import strategiesCommand.CommandStrategy;

public class CommandContext {
	private CommandStrategy strategy;

	public void setCommandStrategy(CommandStrategy strategy) {
		this.strategy = strategy;
	}

	public String execute(Resource currentDirectory, String[] args) {
		return strategy.execute(currentDirectory, args);
	}
}
