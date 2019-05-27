package essentials;

import java.util.Scanner;
import models.*;
import strategiesCommand.*;

public class Console {
	private Resource rootDirectory = new Directory();
	private Resource currentDirectory = new Directory();
	private CommandContext cmdCtx = new CommandContext();

	public Console() {
		rootDirectory.setName("home");
		rootDirectory.setPatch("root");
		rootDirectory.setContainer(null);

		currentDirectory = rootDirectory;
	}

	public void start() {
		String[] commandInput = new String[2];
		commandInput[0] = "";

		while (!commandInput[0].equals("quit")) {
			System.out.print("@" + currentDirectory.getPatch() + "/" + currentDirectory.getName() + ">   ");

			commandInput = input(commandInput);
			processCommand(commandInput);

			System.out.print("");
		}
	}

	private void processCommand(String[] commandInput) {
		switch (commandInput[0]) {
		case "pwd":
			pwd(commandInput);
			break;

		case "mkdir":
			mkdir(commandInput);
			break;

		case "touch":
			touch(commandInput);
			break;

		case "cd":
			cd(commandInput);
			break;

		case "ls":
			ls(commandInput);
			break;

		case "quit":
			System.out.print("Exited succesfully.");
			break;

		default:
			System.out.println("Invalid command. Try again." + "\n");
		}
	}

	private String[] input(String[] commandInput) {
		Scanner scanner = new Scanner(System.in);
		String scanned = scanner.nextLine();

		commandInput = scanned.split("\\s+");

		return commandInput;
	}

	private void pwd(String[] args) {
		cmdCtx.setCommandStrategy(PwdCommandStrategy.getInstance());

		System.out.print(cmdCtx.execute(currentDirectory, args));
	}

	private void mkdir(String[] args) {
		cmdCtx.setCommandStrategy(MkdirCommandStrategy.getInstance());

		System.out.print(cmdCtx.execute(currentDirectory, args));
	}

	private void touch(String[] args) {
		cmdCtx.setCommandStrategy(TouchCommandStrategy.getInstance());

		System.out.print(cmdCtx.execute(currentDirectory, args));
	}

	private void cd(String[] args) {
		cmdCtx.setCommandStrategy(CdCommandStrategy.getInstance());
		
		System.out.print(cmdCtx.execute(currentDirectory, args));
	}

	private void ls(String[] args) {
		cmdCtx.setCommandStrategy(LsCommandStrategy.getInstance());

		System.out.print(cmdCtx.execute(currentDirectory, args));
	}
}
