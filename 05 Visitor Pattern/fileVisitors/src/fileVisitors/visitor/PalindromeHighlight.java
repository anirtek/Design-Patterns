package fileVisitors.visitor;

import fileVisitors.element.MyTree;
import fileVisitors.myTree.Node;
import fileVisitors.util.Logger;
import fileVisitors.util.PalindromeCheck;

/**
 *
 * @author vidhi
 */
public class PalindromeHighlight implements VisitorI {

    MyTree tree = null;
    PalindromeCheck check = null;

    public PalindromeHighlight() {
        Logger.writeMessage("Constructor called - " + this.toString(), Logger.DebugLevel.CONSTRUCTOR);
    }

    //getTree from PopulateVisitor here or driver?
    @Override
    public void visit(MyTree tree) {
        Logger.writeMessage(this.toString() + " visit() method is called", Logger.DebugLevel.VISITOR_ACTIVE);
        check = new PalindromeCheck();
        traverseTree(tree.getRoot());//??
    }

    void traverseTree(Node current_node) {
        if (current_node == null) {
            return;
        }

        traverseTree(current_node.getLeft());
        if (check.isPalindrome(current_node.getWord()) && isLengthGreaterThanThree(current_node.getWord())) {
            capitalizeWord(current_node);
        }
        traverseTree(current_node.getRight());
    }

    boolean isLengthGreaterThanThree(String nodeWord) {
        if (nodeWord.length() > 3) {
            return true;
        }
        return false;
    }

    void capitalizeWord(Node current_node) {
        current_node.setWord(current_node.getWord().toUpperCase());
    }

    @Override
    public String toString() {
        return "Class : fileVisitors.visitor.PalindromeHighlight";
    }
    
    
}
