package traverse;

import node.LeafNode;
import node.Node;
import visit.Visitor;

public class InOrderTraversal implements TraverseStrategy {
  @Override
  public void traverse(Node node, Visitor visitor) {
    if (node != null) {
      traverse(node.left(), visitor);
      visitor.visit(node);
      traverse(node.right(), visitor);
    }
  }
}
