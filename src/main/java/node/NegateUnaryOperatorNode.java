package node;

public class NegateUnaryOperatorNode extends UnaryOperatorNode {

  NegateUnaryOperatorNode(Node right) {
    this.operator = '-';
    this.right = right;
  }

  @Override
  public int eval() {
    return -1 * this.right.eval();
  }
}
