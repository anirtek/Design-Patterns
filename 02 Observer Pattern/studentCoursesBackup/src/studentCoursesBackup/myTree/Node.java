package studentCoursesBackup.myTree;

import java.util.ArrayList;

/**
 * @version 1.0
 * @author Aniruddha Tekade Submitted on October 3rd, 2017
 */
public class Node implements Cloneable, SubjectI, ObserverI {

    Integer data;
    public ArrayList<String> courses;
    Node left;
    Node right;
    public ArrayList<Node> observers;

    /**
     * getCourses() is a getter method to return an ArrayList.
     *
     * @return courses.
     */
    public ArrayList getCourses() {
        return courses;
    }

    /**
     * setCourses() is a setter method to store the courseName into the
     * ArrayList of the requested node of the tree.
     *
     * @param courses
     */
    public void setCourses(ArrayList courses) {
        this.courses = courses;
    }

    /**
     * getLeft() is getter method to get the left child of the parent.
     *
     * @return Node
     */
    public Node getLeft() {
        return left;
    }

    /**
     * setLeft() is setter method to set the newly created node as the left
     * child of the parent.
     *
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * getRight() is getter method to get the right child of the parent.
     *
     * @return Node
     */
    public Node getRight() {
        return right;
    }

    /**
     *
     * setLeft() is setter method to set the newly created node as the left
     * child of the parent.
     *
     * @param right
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * getObservers() return the ArrayList of observers.
     *
     * @return ArrayList
     */
    public ArrayList<Node> getObservers() {
        return observers;
    }

    /**
     * setObserver() adds the observer into the ArrayList of observers.
     *
     * @param observers
     */
    public void setObservers(ArrayList<Node> observers) {
        this.observers = observers;
    }

    /**
     * getData() returns the b_number stored in a node.
     *
     * @return
     */
    public int getData() {
        return data;
    }

    /**
     * sets the b_number as the data of Node.
     *
     * @param data
     */
    public void setData(Integer data) {
        this.data = new Integer(data);
    }

    /**
     * Constructor of the Node class.
     */
    public Node() {
        courses = new ArrayList();
        left = null;
        right = null;
        observers = new ArrayList<Node>();
    }

    /**
     * this method adds the course to the courses ArrayList with the node.
     *
     * @param courseName
     */
    public void addToCourses(String courseName) {
        if (!this.courses.contains(courseName)) {
            this.courses.add(courseName);
        }
    }

    /**
     * This method removes a particular course from the courses associated with
     * the node.
     *
     * @param courseName
     */
    public void removeFromCourses(String courseName) {
        int index = this.courses.indexOf(courseName);
        if (index >= 0) {
            this.courses.remove(index);
        }
    }

    /**
     * getCourses() finds the course if available in the courses ArrayList and
     * return it to the callee.
     *
     * @param i
     * @return String
     */
    public String getCourse(int i) {
        if (i >= 0) {
            return this.courses.get(i);
        }
        return null;
    }

    /**
     * Adds the observer to the node's observer list.
     *
     * @param node
     */
    public void addObserver(Node node) {
        this.observers.add(node);
    }

    /**
     * removes the observer from the node's observer list.
     *
     * @param node
     */
    public void removeObserver(Node node) {
        this.observers.remove(node);
    }

    /**
     * notifies all the observers about the changes
     *
     * @param node
     */
    public void notifyAll(Node node) {
        for (int i = 0; i < courses.size(); i++) {

        }
    }

    /**
     * Method implemented due to Observer interface
     */
    public void update() {
    }

    /**
     * Returns the clone of the received object to the requesting control.
     *
     * @return
     */
    public Node clone() {
        try {
            return (Node) super.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("Error occured while cloning the object!");
            return this;
        }
    }
}

