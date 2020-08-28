package visit;

import node.LeafNode;
import node.Node;
import node.OperatorNode;

public interface Visitor {
	void visit(Node node);
	void visit(LeafNode node);
	void visit(OperatorNode node);
}
