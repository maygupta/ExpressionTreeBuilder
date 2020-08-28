package traverse;

import node.Node;
import visit.Visitor;

public interface TraverseStrategy {
  void traverse(Node node, Visitor visitor);
}
