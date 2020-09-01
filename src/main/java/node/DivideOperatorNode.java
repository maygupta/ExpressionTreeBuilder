package node;

public class DivideOperatorNode extends BinaryOperatorNode {

  DivideOperatorNode(Node left, Node right) {
    this.left = left;
    this.right = right;
    this.operator = '/';
  }

  @Override
  public int eval() {
    return this.left.eval() / this.right.eval();
  }

}
