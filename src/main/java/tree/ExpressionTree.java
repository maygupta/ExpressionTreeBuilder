package tree;

import node.Node;
import traverse.TraverseStrategy;

public interface ExpressionTree {

	Node getRoot();

	int eval();

	void traverse(TraverseStrategy strategy);
}
