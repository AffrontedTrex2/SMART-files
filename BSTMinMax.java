package SMART;

import java.util.*;
public class BSTMinMax {
	public static void main(String[] args) throws Exception
	{
		TreeNode<Integer> root = new TreeNode<>(15);
		root.left = new TreeNode<>(10);
		root.left.left = new TreeNode<>(5);
		root.left.right = new TreeNode<>(11);
		root.left.left.right = new TreeNode<>(6);
		root.right = new TreeNode<>(20);
		root.right.right = new TreeNode<>(25);
		root.right.right.right = new TreeNode<>(30);
		
		printLayerByLayer(root);
		System.out.println("Min: " + getMinValue(root));
		System.out.println("Max: " + getMaxValue(root));
		System.out.println("2nd Min: " + getSecondMinValue(root));
		System.out.println("2nd Max: " + getSecondMaxValue(root));
		System.out.println("Nth Min: " + getNthMinValue(root, 6));
		System.out.println("Nth Max: " + getNthMaxValue(root, 6));
	}
	
	public static int getNthMaxValue(TreeNode<Integer> root, int n) throws Exception
	{
		if (root == null || n <= 0)
		{
			throw new Exception("Invalid parameter");
		}
		
		Stack<TreeNode<Integer>> stack = new Stack<>();
		TreeNode<Integer> current = root;
		stack.push(current);
		
		while (current.right != null)
		{
			current = current.right;
			stack.push(current);
		}
		
		while (!stack.isEmpty() && n != 1)
		{
			TreeNode<Integer> temp = stack.pop();
			n--;
			
			if (temp.left != null)
			{
				current = temp.left;
				stack.push(current);
				while (current.left != null)
				{
					current = current.left;
					stack.push(current);
				}
			}
		}
		
		if (n == 1 && !stack.isEmpty())
		{
			return stack.pop().data;
		}
		throw new Exception("Not enough elements");
	}
	
	public static int getNthMinValue(TreeNode<Integer> root, int n) throws Exception
	{
		if (root == null || n <= 0)
		{
			throw new Exception("Invalid parameter");
		}
		
		Stack<TreeNode<Integer>> stack = new Stack<>();
		TreeNode<Integer> current = root;
		stack.push(current);
		
		while (current.left != null)
		{
			current = current.left;
			stack.push(current);
		}
		
		while (!stack.isEmpty() && n != 1)
		{
			TreeNode<Integer> temp = stack.pop();
			n--;
			if (temp.right != null)
			{
				current = temp.right;
				stack.push(current);
				while (current.left != null)
				{
					current = current.left;
					stack.push(current);
				}
			}
		}
		
		if (n == 1 && !stack.isEmpty())
		{
			return stack.pop().data;
		}
		throw new Exception("Not enough elements");
	}
	
	public static int getSecondMaxValue(TreeNode<Integer> root) throws Exception
	{
		if (root == null || (root.left == null && root.right == null))
		{
			throw new Exception("No more than one element in the tree");
		}
		
		TreeNode<Integer> current = root.right;
		TreeNode<Integer> parent = null;

		while (current.right != null)
		{
			parent = current;
			current = current.right;
		}
		if (current.left != null)
		{
			return getMinValue(current.left);
		}
		
		return parent.data;
	}
	
	public static int getSecondMinValue(TreeNode<Integer> root) throws Exception
	{
		if (root == null || (root.left == null && root.right == null))
		{
			throw new Exception("No more than one element in the tree");
		}
		
		TreeNode<Integer> current = root.left;
		TreeNode<Integer> parent = null;

		while (current.left != null)
		{
			parent = current;
			current = current.left;
		}
		if (current.right != null)
		{
			return getMinValue(current.right);
		}
		
		return parent.data;
	}
	
	public static int getMaxValue(TreeNode<Integer> root) throws Exception
	{
		if (root == null)
		{
			throw new Exception("No element in the tree");
		}
		
		TreeNode<Integer> current = root;
		while (current.right != null)
		{
			current = current.right;
		}
		return current.data;
	}
	
	public static int getMinValue(TreeNode<Integer> root) throws Exception
	{
		if (root == null)
		{
			throw new Exception("No element in the tree");
		}
		
		TreeNode<Integer> current = root;
		while (current.left != null)
		{
			current = current.left;
		}
		return current.data;
	}
	
	public static void printLayerByLayer(TreeNode<Integer> root) throws Exception
	{
		if (root == null)
		{
			throw new Exception("No element in the tree");
		}
		Queue<TreeNode<Integer>> q = new LinkedList<TreeNode<Integer>>();
		q.offer(root);
		int size = q.size();
		
		while (!q.isEmpty())
		{
			size = q.size();
			while (size > 0)
			{
				TreeNode<Integer> temp = q.poll();
				System.out.print(temp.data + " ");
				
				if (temp.left != null)
				{
					q.offer(temp.left);
				}
				if (temp.right != null)
				{
					q.offer(temp.right);
				}
				size--;
			}
			System.out.println();
		}
	}
}
