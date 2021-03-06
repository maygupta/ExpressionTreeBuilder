package tree;

import node.Node;
import traverse.TraverseStrategy;
import visit.Visitor;

public class SimpleExpressionTree implements ExpressionTree {
  Node root;

  SimpleExpressionTree(Node node) {
    this.root = node;
  }

  @Override
  public Node getRoot() {
    return root;
  }

  @Override
  public int eval() {
    return root.eval();
  }

  @Override
  public void traverse(TraverseStrategy strategy, Visitor visitor) {
    strategy.traverse(root, visitor);
  }

}
