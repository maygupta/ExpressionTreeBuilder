import traverse.InOrderTraversal;
import tree.ExpressionTree;
import traverse.PreOrderTraversal;
import tree.SimpleTreeBuilder;
import tree.TreeBuilder;

public class ExpressionTreeExecutor {

  public static void main(String[] args) {
    TreeBuilder builder = new SimpleTreeBuilder();
    System.out.println(builder.build("3-5-34+*").eval());
    System.out.println(builder.build("5-34+*").eval());
    System.out.println(builder.build("56*").eval());
  }
}
