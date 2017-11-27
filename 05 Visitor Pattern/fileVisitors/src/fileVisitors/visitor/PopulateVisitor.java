package fileVisitors.visitor;

import fileVisitors.element.MyTree;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.InputProcessor;
import fileVisitors.util.Logger;

/**
 *
 * @author anirtek
 */
public class PopulateVisitor implements VisitorI {

    FileProcessor fp = null;
    InputProcessor ip = null;
    MyTree tree = null;

    public PopulateVisitor() {
        Logger.writeMessage("Constructor called - " + this.toString(), Logger.DebugLevel.CONSTRUCTOR);
    }

    @Override
    public void visit(MyTree tree) {
        Logger.writeMessage(this.toString() + " visit() method is called", Logger.DebugLevel.VISITOR_ACTIVE);
        String line = "";

        while ((line = fp.readLine()) != null) {
            String[] inputParse = ip.processInput(line);
            for (int i = 0; i < inputParse.length; i++) {
                tree.insert(inputParse[i]);
            }
        }
    }

    //Setters
    public void setFileProcessor(FileProcessor fp) {
        this.fp = fp;
    }

    public void setInputProcessor(InputProcessor ip) {
        this.ip = ip;
    }

    public MyTree getTree() {
        return tree;
    }
    
    
    @Override
    public String toString() {
        return "Class : fileVisitors.visitor.PopulateVisitor";
    }
}
