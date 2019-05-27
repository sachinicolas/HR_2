package essentials;

import java.util.Scanner;
import models.*;
import strategies.command.*;

public class Console {
	private Resource rootDirectory = new Directory();
	private Resource currentDirectory = new Directory();
	private CommandContext cmdCtx = new CommandContext();
	private CommandStrategy cd = new CdCommandStrategy();
	private CommandStrategy ls = new LsCommandStrategy();
	private CommandStrategy mkdir = new MkdirCommandStrategy();
	private CommandStrategy pwd = new PwdCommandStrategy();
	private CommandStrategy touch = new TouchCommandStrategy();

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
		cmdCtx.setCommandStrategy(pwd);

		System.out.println(cmdCtx.execute(currentDirectory, args) + "\n");
	}

	private void mkdir(String[] args) {
		cmdCtx.setCommandStrategy(mkdir);

		cmdCtx.execute(currentDirectory, args);
	}

	private void touch(String[] args) {
		cmdCtx.setCommandStrategy(touch);

		cmdCtx.execute(currentDirectory, args);
	}

	private void cd(String[] args) {
		cmdCtx.setCommandStrategy(cd);

		cmdCtx.execute(currentDirectory, args);
	}

	private void ls(String[] args) {
		cmdCtx.setCommandStrategy(ls);

		System.out.println(cmdCtx.execute(currentDirectory, args));
	}
}
