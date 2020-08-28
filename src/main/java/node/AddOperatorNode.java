package node;

public class AddOperatorNode extends BinaryOperatorNode {

	AddOperatorNode(Node left, Node right) {
		this.operator = '+';
		this.left = left;
		this.right = right;
	}

	@Override
	public int eval() {
		return this.left.eval() + this.right.eval();
	}
}
