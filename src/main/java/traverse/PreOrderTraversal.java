package traverse;

import node.LeafNode;
import node.Node;
import visit.Visitor;

public class PreOrderTraversal implements TraverseStrategy {
  @Override
  public void traverse(Node node, Visitor visitor) {
    if (node != null) {
      visitor.visit(node);
      traverse(node.left(), visitor);
      traverse(node.right(), visitor);
    }
  }
}
