package fileVisitors.visitor;

import fileVisitors.element.MyTree;
import fileVisitors.myTree.Node;
import fileVisitors.util.Logger;
import static java.lang.Math.sqrt;

/**
 *
 * @author anirtek
 */
public class PrimeLength implements VisitorI {

    MyTree tree = null;

    public PrimeLength() {
        Logger.writeMessage("Constructor called - " + this.toString(), Logger.DebugLevel.CONSTRUCTOR);
    }

    @Override
    public void visit(MyTree tree) {
        Logger.writeMessage(this.toString() + " visit() method is called", Logger.DebugLevel.VISITOR_ACTIVE);
        traverseTree(tree.getRoot());//??
    }

    void traverseTree(Node current_node) {
        if (current_node == null) {
            return;
        }
        traverseTree(current_node.getLeft());
        if (isWordLengthPrime(current_node.getWord())) {
            String newWord = current_node.getWord() + "-PRIME";
            current_node.setWord(newWord);
        }
        traverseTree(current_node.getRight());
    }

    public boolean isWordLengthPrime(String nodeWord) {
        int length = nodeWord.length();

        if (length == 0 || length == 1) {
            return false;
        }
        for (int i = 2; i <= sqrt(length); ++i) {
            if (length % i == 0) {
                return false;
            }
        }
        return true;
    }

    public MyTree getTree() {
        return tree;
    }

    public void setTree(MyTree tree) {
        this.tree = tree;
    }

    @Override
    public String toString() {
        return "Class : fileVisitors.visitor.PrimeLength";
    }
}
