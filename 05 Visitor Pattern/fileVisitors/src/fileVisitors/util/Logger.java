package fileVisitors.util;

/**
 * @version 4.0
 * @author Vidhi Kamdar & Aniruddha Tekade Submitted on November 22nd, 2017.
 */
public class Logger {

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime a accept() method is called]
      DEBUG_VALUE=2 [Print to stdout everytime a visit() is attempted]
      DEBUG_VALUE=1 [Print to stdout everytime a palindromeCheck is performed]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout. However, it doesn't affect what's get written to the output file." ]
     */
    public static enum DebugLevel {
        RELEASE,
        PALINDROME_CHECK,
        VISITOR_ACTIVE,
        ELEMENT_ACCEPT,
        CONSTRUCTOR
    };

    private static DebugLevel debugLevel;

    public static void setDebugValue(int levelIn) {
        switch (levelIn) {
            case 4:
                debugLevel = DebugLevel.CONSTRUCTOR;
                break;
            case 3:
                debugLevel = DebugLevel.ELEMENT_ACCEPT;
                break;
            case 2:
                debugLevel = DebugLevel.VISITOR_ACTIVE;
                break;
            case 1:
                debugLevel = DebugLevel.PALINDROME_CHECK;
                break;
            case 0:
                debugLevel = DebugLevel.RELEASE;
                break;
        }
    }

    public static void setDebugValue(DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    // @return None
    public static void writeMessage(String message, DebugLevel levelIn) {
        if (levelIn == debugLevel) {
            System.out.println(message);
        }
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Debug Level is " + debugLevel;
    }
}
