package node;

import java.util.Arrays;
import java.util.List;

public class OperatorFactory {
  static List<Character> supporterdOperators = Arrays.asList('*', '/', '+', '-');

  public static Boolean isOperator(Character s) {
    return supporterdOperators.contains(s);
  }

  public static Node getOperatorNode(Character s, Node left, Node right) {
    if (isOperator(s)) {
      if ( s.equals('*')) {
        return new MultiplyOperatorNode(left, right);
      } else if (s.equals('+')) {
        return new AddOperatorNode(left, right);
      } else if (s.equals('-')) {
        return new SubtractOperatorNode(left, right);
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

}
