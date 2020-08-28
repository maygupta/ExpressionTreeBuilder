package node;

public class LeafNode implements Node {
  int item;

  public LeafNode(int item) {
    this.item = item;
  }

  @Override
  public int value() {
    return item;
  }

  @Override
  public Node left() {
    return null;
  }

  @Override
  public Node right() {
    return null;
  }

  @Override
  public int eval() {
    return item;
  }
}
