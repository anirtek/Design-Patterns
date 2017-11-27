package fileVisitors.element;

/**
 * @version 5.0
 * @author Vidhi Kamdar & Aniruddha Tekade Submitted on November 22nd, 2017.
 */
public class TreeBuilder {

    MyTree tree = null;

    public void setTree(MyTree treeIn) {
        this.tree = treeIn;
    }

    public MyTree getTree() {
        return tree;
    }

    public void insert(String wordIn) {
        this.tree.insert(wordIn);
    }

    public void getRoot() {

    }
}
