package tree;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import node.LeafNode;
import node.Node;
import node.OperatorFactory;

public class InfixTreeBuilder implements TreeBuilder {

  Stack<Character> charStack;
  Stack<Node> nodeStack;

  @Override
  public ExpressionTree build(String expression) {
    charStack = new Stack<>();
    nodeStack = new Stack<>();
    String currentNumber = "";

    for(Character s: expression.toCharArray()) {
      if ( OperatorFactory.isOperator(s)) {
        if (!currentNumber.isEmpty()) {
          nodeStack.push(new LeafNode(Integer.parseInt(currentNumber)));
          currentNumber = "";
        }

        if ( s.equals('(')) {
          charStack.push(s);
          continue;
        }
        if (s.equals(')')) {
          while ( !charStack.peek().equals('(') ) {
            eval();
          }
          // Pop '('
          charStack.pop();
          continue;
        }
        if (!charStack.empty() && !OperatorFactory.isHigerOrderOperator(s, charStack.peek())) {
          while ( !charStack.empty() ) {
            if (charStack.peek().equals('(') ) {
              break;
            } else if (!OperatorFactory.isHigerOrderOperator(s, charStack.peek())) {
              eval();
            }
            break;
          }
        }
        charStack.push(s);
      } else {
        currentNumber += s;
      }
    }

    if (!currentNumber.isEmpty()) {
      nodeStack.push(new LeafNode(Integer.parseInt(currentNumber)));
    }

    while (!charStack.empty()) {
      eval();
    }

    return new SimpleExpressionTree(nodeStack.pop());
  }

  private void eval() {
    Node rightNode = nodeStack.pop();
    Node leftNode = nodeStack.pop();
    Node operatorNode = OperatorFactory.getOperatorNode(charStack.pop(), leftNode, rightNode);
    nodeStack.push(operatorNode);
  }

}
