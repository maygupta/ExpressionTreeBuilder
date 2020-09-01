package node;

import org.junit.Before;
import org.junit.Test;

import tree.InfixTreeBuilder;

public class InfixTreeBuilderTest {
  InfixTreeBuilder builder = new InfixTreeBuilder();

  @Test
  public void testInfixTreeBuild1() {
    assert builder.build("((12/6)*4)+18-20").eval() == 6;
    assert builder.build("((12/6)/1)").eval() == 2;
  }

  @Test
  public void testInfixTreeBuild2() {
    assert builder.build("((12/6)-4)").eval() == -2;
    assert builder.build("3+4+7+8").eval() == 22;
    assert builder.build("(3+4)*(2+4)").eval() == 42;
    assert builder.build("(3+4)*(2-4+2)").eval() == -28;
    assert builder.build("(3+4)*(2+2-4)").eval() == 0;
  }

}
