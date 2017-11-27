package fileVisitors.util;

/**
 * @version 1.0
 * @author Vidhi Kamdar & Aniruddha Tekade Submitted on November 22nd, 2017.
 */
public class PalindromeCheck {

    public PalindromeCheck() {
        Logger.writeMessage("Constructor called - " + this.toString(), Logger.DebugLevel.CONSTRUCTOR);
    }

    public boolean isPalindrome(String nodeWord) {
        Logger.writeMessage("checking palindrome :" + this.toString(), Logger.DebugLevel.PALINDROME_CHECK);
        String reverseWord = new StringBuffer(nodeWord).reverse().toString();
        if (reverseWord.equals(nodeWord)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Class : fileVisitors.util.PalindromeCheck";
    }

}
