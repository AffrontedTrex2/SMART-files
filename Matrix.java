package ems;

import java.util.*;
public class Matrix {
	public static void main(String[] args) {
		int[][] matrix = 
			{
					{1, 2, 3, 4, 5},
					{3, 4, 7, 5, 7},
					{6, 5, 9, 8, 9}
			};
		int min = getNthMin(matrix, 1);
		System.out.println(min);
	}
	
	public static int getNthMin(int[][] matrix, int n) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			throw new IllegalArgumentException("Input invalid");
		}
		
		PriorityQueue<Cell> q = new PriorityQueue<>(new Comparator<Cell>() {
			
			public int compare(Cell c1, Cell c2) {
				return c1.data - c2.data;
			}
		});
		
		HashSet<Cell> cellSet = new HashSet<>();
		int location = 0;
		int i = 0;
		int j = 0;
		Cell cell = new Cell(i, j, matrix[i][j]);
		q.offer(cell);
		while (!q.isEmpty()) {
			Cell current = q.poll();
			i = current.i;
			j = current.j;
			if (i < matrix.length - 1) {
				Cell down = new Cell(i + 1, j, matrix[i + 1][j]);
				if (!cellSet.contains(down)) {
					q.offer(down);
					cellSet.add(down);
				}
			}
			if (j < matrix[0].length - 1) {
				Cell right = new Cell(i, j + 1, matrix[i][j + 1]);
				if (!cellSet.contains(right)) {
					q.offer(right);
					cellSet.add(right);
				}
			}
			location++;
			if (location == n) {
				return current.data;
			}
		}
		throw new IllegalArgumentException();
	}
}
