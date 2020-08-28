package node;

import javax.script.ScriptEngineManager;

public class MultiplyOperatorNode extends BinaryOperatorNode {

	MultiplyOperatorNode(Node left, Node right) {
		this.left = left;
		this.right = right;
		this.operator = '*';
	}

	@Override
	public int eval() {
		return this.left.eval() * this.right.eval();
	}
}
