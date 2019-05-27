package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Resource {
	String name;
	String path;
	Resource container;
	
	public Resource(String name, String patch, Resource container) {
		this.name = name;
		this.path = patch;
		this.container = container;
	}
	
	public Resource() {}
	
	public Resource getContainer() {
		return container;
	}

	public void setContainer(Resource container) {
		this.container = container;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPatch() {
		return path;
	}

	public void setPatch(String patch) {
		this.path = patch;
	}
	
	public void setResourcesList(List<Resource> resourcesList) {}
	
	public List<Resource> getResourcesList() {
		return new ArrayList<Resource>();
	}
}
