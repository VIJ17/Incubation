package bst;

import java.util.Scanner;

import bst.BinarySearchTree.node;

public class BSTRunner
{
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("Enter no of elements...");
		int n = sc.nextInt();
		BinarySearchTree bst = new BinarySearchTree();
		node root = null;
		System.out.println("Enter tree elements one by one...");
		root = bst.insert(root, sc.nextInt());
		
		for(int i = 0; i < (n-1); i++)
		{
			bst.insert(root, sc.nextInt());
		}
		
		bst.printInOrder(root);
	}

}
