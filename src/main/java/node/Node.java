package node;

import visit.Visitor;

public interface Node {
  int value();

  default Node left() {
    return null;
  }

  default Node right() {
    return null;
  }

  int eval();

}
