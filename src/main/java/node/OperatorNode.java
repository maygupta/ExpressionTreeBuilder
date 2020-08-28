package node;

public abstract class OperatorNode implements Node{
	char operator;
	Node left;
	Node right;

	@Override
	public int value() {
		return operator;
	}

	@Override
	public abstract Node left();

	@Override
	public abstract Node right();

}
