package visit;

import node.LeafNode;
import node.Node;
import node.OperatorNode;

public class PrintVisitor implements Visitor {
	@Override
	public void visit(Node node) {
		if (node instanceof LeafNode) {
			visit((LeafNode) node);
		} else if (node instanceof OperatorNode) {
			visit((OperatorNode) node);
		}
	}

	@Override
	public void visit(LeafNode node) {
		System.out.println(node.eval());
	}

	@Override
	public void visit(OperatorNode node) {
		System.out.println(node.getOperator());
	}

}
