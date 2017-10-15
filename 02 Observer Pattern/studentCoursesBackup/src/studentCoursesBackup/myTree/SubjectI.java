package studentCoursesBackup.myTree;

public interface SubjectI {

    public void addObserver(Node node);

    public void removeObserver(Node node);

    public void notifyAll(Node node);

}

