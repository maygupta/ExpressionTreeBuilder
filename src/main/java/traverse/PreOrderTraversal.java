package traverse;

import node.LeafNode;
import node.Node;

public class PreOrderTraversal implements TraverseStrategy {
  @Override
  public void traverse(Node node) {
    if (node != null) {
      if (node instanceof LeafNode) {
        System.out.println(node.value());
      } else {
        System.out.println((char)node.value());
      }
      traverse(node.left());
      traverse(node.right());
    }
  }
}
