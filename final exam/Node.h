#include <cstddef> //FOR NULL.

class Node
{
public:
	char label;
	Node *left;
	Node *right;

	Node()
	{
		label = ' ';
		left = NULL;
		right = NULL;
	}

	Node(char lbl)
	{
		label = lbl;
		left = NULL;
		right = NULL;
	}

	Node(char lbl, Node *lft, Node *rgt)
	{
		label = lbl;
		left = lft;
		right = rgt;
	}

	void setLabel(char lbl)
	{
		label = lbl;
	}

	void setLeft(Node *lft)
	{
		left = lft;
	}

	void setRight(Node *rgt)
	{
		right = rgt;
	}
};
