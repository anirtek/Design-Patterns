package studentCoursesBackup.util;

/**
 * @version 1.0
 * @author Aniruddha Tekade Submitted on October 3rd, 2017.
 */
public class FileDisplayInterface {

    public Results results;

    /**
     * FileDisplayInterface() is a parameterized constructor of this class that
     * saves the reference to the result object in the local variable.
     *
     * @param r
     */
    public FileDisplayInterface(Results r) {
        this.results = r;
    }

    /**
     * this method calls to the writeToFile() method defined in the Result class
     * of the same package to write to the output files.
     */
    public void processOutput() {
        this.results.writeToFile();
    }

}

