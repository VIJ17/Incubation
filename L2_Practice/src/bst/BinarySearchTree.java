package bst;

public class BinarySearchTree
{
	public static class node
	{
		int key;
		node left, right;
	};
	
	private static node newNode(int key)
	{
		node temp = new node();
		temp.key = key;
		temp.left = temp.right = null;
		
		return temp;
	}
	
	public node insert(node node, int key)
	{
		if(node == null)
		{
			return newNode(key);
		}
		
		if(key < node.key)
		{
			node.left = insert(node.left, key);
		}
		else if(key > node.key)
		{
			node.right = insert(node.right, key);
		}
		
		return node;
	}
	
	public void printInOrder(node root)
	{
		if(root != null)
		{
			printInOrder(root.left);
			System.out.print(" " + root.key);
			printInOrder(root.right);
		}
	}
}
