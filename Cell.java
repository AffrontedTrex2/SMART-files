package ems;

public class Cell {
	public int i;
	public int j;
	public int data;
	
	public Cell(int i, int j, int data) {
		this.i = i;
		this.j = j;
		this.data = data;
	}
	
	@Override
	public int hashCode() {
		return i + 1000 * j;
	}
}
