package fileVisitors.visitor;

import fileVisitors.element.ElementI;
import fileVisitors.element.MyTree;
import fileVisitors.myTree.Node;
import fileVisitors.store.Results;
import fileVisitors.util.Logger;
import java.util.ArrayList;

/**
 * @version 4.0
 * @author Vidhi Kamdar & Aniruddha Tekade Submitted on November 22nd, 2017.
 */
public class PrintTree implements VisitorI {

    Results results = null;

    public PrintTree(Results results) {
        Logger.writeMessage("Constructor called - " + this.toString(), Logger.DebugLevel.CONSTRUCTOR);
        this.results = results;
    }

    @Override
    public void visit(MyTree tree) {
        Logger.writeMessage(this.toString() + " visit() method is called", Logger.DebugLevel.VISITOR_ACTIVE);
        printNodes(tree.getRoot());
        results.writeToScreen();
        results.writeSchedulesToFile(tree);
    }

    public void printNodes(Node current_node) {
        if (current_node == null) {
            return;
        }
        printNodes(current_node.getLeft());
        results.storeLine(current_node.getWord());
        printNodes(current_node.getRight());
    }

    @Override
    public String toString() {
        return "Class : fileVisitors.visitor.PrintTree";
    }
}
