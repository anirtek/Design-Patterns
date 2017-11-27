package fileVisitors.element;

import fileVisitors.visitor.VisitorI;

/**
 * @version 1.0
 * @author Vidhi Kamdar & Aniruddha Tekade Submitted on November 22nd, 2017.
 */
public interface ElementI {

    public void accept(VisitorI visitor);
}
