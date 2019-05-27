package models;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Resource {
	List<Resource> resourcesList = new ArrayList<Resource>();
	
	public Directory(List<Resource> resourcesList, String name, String patch, Resource container) {
		super(name, patch, container);
		this.resourcesList = resourcesList;
	}
	
	public Directory() {
		super();
	}

	public List<Resource> getResourcesList() {
		return resourcesList;
	}

	public void setResourcesList(List<Resource> resourcesList) {
		this.resourcesList = resourcesList;
	}
}
