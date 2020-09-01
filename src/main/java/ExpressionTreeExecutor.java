import traverse.InOrderTraversal;
import tree.ExpressionTree;
import traverse.PreOrderTraversal;
import tree.InfixTreeBuilder;
import tree.PostfixTreeBuilder;
import tree.TreeBuilder;
import visit.PrintVisitor;

public class ExpressionTreeExecutor {

  public static void main(String[] args) {
//    TreeBuilder builder = new PostfixTreeBuilder();
//    ExpressionTree tree = builder.build("3-5-34+*");
//    tree.traverse(new InOrderTraversal(), new PrintVisitor());
//    tree.traverse(new PreOrderTraversal(), new PrintVisitor());
//    System.out.println(tree.eval());

    TreeBuilder builder = new InfixTreeBuilder();
    ExpressionTree tree = builder.build("((12/6)*4)+18-20");
    tree.traverse(new InOrderTraversal(), new PrintVisitor());
    tree.traverse(new PreOrderTraversal(), new PrintVisitor());
    System.out.println(tree.eval());
  }
}
