package fit5042.bank.controllers;

public class SimpleObject {
	private int id;
	private String name;
	public SimpleObject(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public SimpleObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SimpleObject [id=" + id + ", name=" + name + "]";
	}
	
	
}
