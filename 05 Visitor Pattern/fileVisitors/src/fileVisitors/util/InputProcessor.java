package fileVisitors.util;

import fileVisitors.element.MyTree;

/**
 * @version 5.0
 * @author Vidhi Kamdar & Aniruddha Tekade Submitted on November 22nd, 2017.
 */
public class InputProcessor {

    MyTree myTreeInstance = null;

    public InputProcessor() {
        Logger.writeMessage("Constructor called - " + this.toString(), Logger.DebugLevel.CONSTRUCTOR);
    }

    public String[] processInput(String inputLine) {
        String[] inputPass = inputLine.split("[^a-zA-Z0-9']+");
        return inputPass;
    }

    @Override
    public String toString() {
        return "Class : fileVisitors.util.InputProcessor"; //To change body of generated methods, choose Tools | Templates.
    }

}
