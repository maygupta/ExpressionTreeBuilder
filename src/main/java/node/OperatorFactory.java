package node;

import java.util.Arrays;
import java.util.List;

public class OperatorFactory {
  static List<Character> operators = Arrays.asList('(', ')', '-', '+', '*', '/');


  public static Boolean isOperator(Character s) {
    return operators.contains(s);
  }

  public static Node getOperatorNode(Character s, Node left, Node right) {
    if (isOperator(s)) {
      if ( s.equals('*')) {
        return new MultiplyOperatorNode(left, right);
      } else if (s.equals('+')) {
        return new AddOperatorNode(left, right);
      } else if (s.equals('-')) {
        return new SubtractOperatorNode(left, right);
      } else if (s.equals('/')) {
        return new DivideOperatorNode(left, right);
      }
    }
    return null;
  }

  public static Node getOperatorNode(Character s, Node right) {
    if (isOperator(s)) {
      if ( s.equals('-')) {
        return new NegateUnaryOperatorNode(right);
      }
    }
    return null;
  }

  // Rank op1 > Rank op2
  public static boolean isHigerOrderOperator(Character op1, Character op2) {
    return operators.indexOf(op1) > operators.indexOf(op2);
  }

}
