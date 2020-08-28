package node;

public abstract class UnaryOperatorNode extends OperatorNode {
	Node right;

	@Override
	public Node right() {
		return right;
	}

	@Override
	public Node left() {
		return null;
	}
}
