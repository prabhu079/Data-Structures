   /* Class node is defined as :
    class Node 
       int val;   //Value
       int ht;      //Height
       Node left;   //Left child
       Node right;   //Right child

   */

   	static Node insert(Node node,int data)
    {
		if(null==node)
		{
			node=new Node();
			node.val=data;
			node.ht=-1;
			return node;
		}
		if(data>node.val)
		{
		node.right=	insert(node.right,data);
		}
		else{
		node.left=	insert(node.left,data);
		}
		int balance=balance(node.left,node.right);
		if(balance>1)
		{
			if(returnHeight(node.left.left)>=returnHeight(node.left.right))
			{
				node=rotateRight(node);
			}
			else
			{
				node.left=rotateLeft(node.left);
				node=rotateRight(node);
			}
		}
		else if(balance<-1)
		{
			if(returnHeight(node.right.right)>=returnHeight(node.right.left))
			{
				node=rotateLeft(node);
			}
			else
			{
				node.right=rotateRight(node.right);
				node=rotateLeft(node);
			}
		}
		else
		{
			node.ht=height(node);
		}
		return node;
       
    }
	
	private static Node rotateRight(Node node) {
		Node newNode=node.left;
		node.left=node.left.right;
		newNode.right=node;
		node.ht=height(node);
		newNode.ht=height(newNode);
		return newNode;
	}
	private static Node rotateLeft(Node node) {
		Node newNode=node.right;
		node.right=node.right.left;
		newNode.left=node;
		node.ht=height(node);
		newNode.ht=height(newNode);
		return newNode;
	}

	static int balance(Node left,Node right)
	{
		
		return (returnHeight(left)-returnHeight(right));
		
	}

	static int returnHeight(Node node) {
		if(null==node)
		{
			return -1;
		}
		
		return node.ht;
	}
	static int height(Node node)
	{
		if(null==node)
		{
			return -1;
		}
		node.ht=1+Math.max(height(node.left),height (node.right));
		return node.ht;
	}
	
