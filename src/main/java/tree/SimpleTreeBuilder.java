package tree;

import java.util.Stack;

import node.Node;
import node.OperatorFactory;
import node.LeafNode;

public class SimpleTreeBuilder implements TreeBuilder{

  @Override
  public ExpressionTree build(String expression) {
    Stack<Node> stack = new Stack<>();

    for(char s: expression.toCharArray()) {
      if (OperatorFactory.isOperator(s)) {
        // Pop 2 elements
        Node operatorNode = null;
        Node rightNode = stack.pop();

        if (!stack.empty()) {
          Node leftNode = stack.pop();
          operatorNode = OperatorFactory.getOperatorNode(s, leftNode, rightNode);
        } else {
          operatorNode = OperatorFactory.getOperatorNode(s, rightNode);
        }
        stack.push(operatorNode);
      } else {
        stack.push(new LeafNode(Character.getNumericValue(s)));
      }
    }
    assert stack.size() == 1;
    return new SimpleExpressionTree(stack.pop());
  }

}
