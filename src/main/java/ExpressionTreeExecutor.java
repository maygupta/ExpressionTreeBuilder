import traverse.InOrderTraversal;
import tree.ExpressionTree;
import traverse.PreOrderTraversal;
import tree.SimpleTreeBuilder;
import tree.TreeBuilder;
import visit.PrintVisitor;

public class ExpressionTreeExecutor {

  public static void main(String[] args) {
    TreeBuilder builder = new SimpleTreeBuilder();
    ExpressionTree tree = builder.build("3-5-34+*");
    tree.traverse(new InOrderTraversal(), new PrintVisitor());
    tree.traverse(new PreOrderTraversal(), new PrintVisitor());
    System.out.println(tree.eval());
  }
}
