package node;

import java.util.Arrays;
import java.util.List;

public class OperatorFactory {
  static List<Character> operators = Arrays.asList('(', ')', '-', '+', '*', '/');


  public static Boolean isOperator(Character s) {
    return operators.contains(s);
  }

  public static Boolean isOperator(String s) {
    return isOperator(s.charAt(0));
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

  public static Node getOperatorNode(String s, Node left, Node right) {
    return getOperatorNode(s.charAt(0), left, right);
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
  public static boolean isHigerOrderOperator(String op1, String op2) {
    return operators.indexOf(op1.charAt(0)) > operators.indexOf(op2.charAt(0));
  }

}
