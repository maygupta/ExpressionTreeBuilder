package traverse;

import node.LeafNode;
import node.Node;

public class InOrderTraversal implements TraverseStrategy {
	@Override
	public void traverse(Node node) {
		if (node != null) {
			traverse(node.left());

			if (node instanceof LeafNode) {
				System.out.println(node.value());
			} else {
				System.out.println((char) node.value());
			}

			traverse(node.right());
		}
	}
}
