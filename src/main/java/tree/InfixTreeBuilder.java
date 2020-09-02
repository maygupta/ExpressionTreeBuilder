package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import node.LeafNode;
import node.Node;
import node.OperatorFactory;

public class InfixTreeBuilder implements TreeBuilder {

  Stack<String> charStack;
  Stack<Node> nodeStack;

  @Override
  public ExpressionTree build(String expression) {
    charStack = new Stack<>();
    nodeStack = new Stack<>();
    List<String> expressionList = new ArrayList<>();
    Stream<Character> charStream = expression.chars().mapToObj(c -> (char)c);
    charStream.forEach(c -> {
      if ( OperatorFactory.isOperator(c)) {
        expressionList.add(String.valueOf(c));
      } else {
        if (expressionList.size() > 0
            && !OperatorFactory.isOperator(expressionList.get(expressionList.size() - 1))) {
            expressionList.add(expressionList.remove(expressionList.size() - 1) + c);
        } else {
          expressionList.add(String.valueOf(c));
        }
      }
    });

    expressionList.forEach(s -> {
      if (OperatorFactory.isOperator(s)) {
        handleOperator(s);
      } else {
        nodeStack.push(new LeafNode(Integer.parseInt(s)));
      }
    });

    while (!charStack.empty()) {
      eval();
    }

    return new SimpleExpressionTree(nodeStack.pop());
  }

  private void handleOperator(String s) {
    if ( s.equals("(")) {
      charStack.push(s);
      return;
    }
    if (s.equals(")")) {
      while ( !charStack.peek().equals("(") ) {
        eval();
      }
      // Pop '('
      charStack.pop();
      return;
    }
    if (!charStack.empty() && !OperatorFactory.isHigerOrderOperator(s, charStack.peek())) {
      while( !charStack.empty() ) {
        if (charStack.peek().equals("(") ) {
          break;
        } else if (!OperatorFactory.isHigerOrderOperator(s, charStack.peek())) {
          eval();
        }
        break;
      }
    }
    charStack.push(s);
  }

  private void eval() {
    Node rightNode = nodeStack.pop();
    Node leftNode = nodeStack.pop();
    Node operatorNode = OperatorFactory.getOperatorNode(charStack.pop(), leftNode, rightNode);
    nodeStack.push(operatorNode);
  }

}
