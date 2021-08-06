// Java program to print
// cousins of a node
import java.io.*;
import java.util.*;
import java.lang.*;


// A Binary Tree Node
class Node
{
	int data;
	Node left, right;
	Node(int key)
	{
		data = key;
		left = right = null;
	}
}

class GFG
{
	
// function to print
// cousins of the node
static void printCousins(Node root,
						Node node_to_find)
{
	// if the given node
	// is the root itself,
	// then no nodes would
	// be printed
	if (root == node_to_find)
	{
		System.out.print("Cousin Nodes :" +
						" None" + "\n");
		return;
	}

	Queue<Node> q = new LinkedList<Node>();
	boolean found = false;
	int size_ = 0;
	Node p = null;
	q.add(root);

	// the following loop runs
	// until found is not true,
	// or q is not empty. if
	// found has become true => we
	// have found the level in
	// which the node is present
	// and the present queue will
	// contain all the cousins of
	// that node
	while (q.isEmpty() == false &&
				found == false)
	{

		size_ = q.size();
		while (size_ -- > 0)
		{
			p = q.peek();
			q.remove();

			// if current node's left
			// or right child is the
			// same as the node to find,
			// then make found = true,
			// and don't push any of them
			// into the queue, as we don't
			// have to print the siblings
			if ((p.left == node_to_find ||
				p.right == node_to_find))
			{
				found = true;
			}
			else
			{
				if (p.left != null)
					q.add(p.left);
				if (p.right!= null)
					q.add(p.right);
			}

		}
	}

	// if found == true then the
	// queue will contain the
	// cousins of the given node
	if (found == true)
	{
		System.out.print("Cousin Nodes : ");
		size_ = q.size();

		// size_ will be 0 when
		// the node was at the
		// level just below the
		// root node.
		if (size_ == 0)
			System.out.print("None");
		
		for (int i = 0; i < size_; i++)
		{
			p = q.peek();
			q.poll();
			
			System.out.print(p.data + " ");
		}
	}
	else
	{
		System.out.print("Node not found");
	}
	
	System.out.println("");
	return;
}

// Driver code
public static void main(String[] args)
{
	Node root = new Node(1);
	root.left = new Node(2);
	root.right = new Node(3);
	root.left.left = new Node(4);
	root.left.right = new Node(5);
	root.left.right.right = new Node(15);
	root.right.left = new Node(6);
	root.right.right = new Node(7);
	root.right.left.right = new Node(8);

	Node x = new Node(43);

	printCousins(root, x);
	printCousins(root, root);
	printCousins(root, root.right);
	printCousins(root, root.left);
	printCousins(root, root.left.right);
}
}
