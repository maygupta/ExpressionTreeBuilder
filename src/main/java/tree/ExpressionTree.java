package tree;

import node.Node;
import traverse.TraverseStrategy;
import visit.Visitor;

public interface ExpressionTree {

  Node getRoot();

  int eval();

  void traverse(TraverseStrategy strategy, Visitor visitor);

}
