package node;

public abstract class BinaryOperatorNode extends OperatorNode {

  @Override
  public Node left() {
    return left;
  }

  @Override
  public Node right() {
    return right;
  }

}
