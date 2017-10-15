package studentCoursesBackup.myTree;

import java.util.ArrayList;
import studentCoursesBackup.util.Results;

/**
 * @version 1.0
 * @author Aniruddha Tekade Submitted on October 3rd, 2017.
 */
public class MyTree {

    public Node node_orig;

    /**
     * Default constructor
     */
    public MyTree() {
        node_orig = null;
    }

    /**
     * Inserts the node into the tree at the proper location.
     *
     * @param root
     * @param b_number
     * @param courseName
     * @return
     */
    public Node insertNodeSorted(Node root, int b_number, String courseName) {
        if (root == null) {
            root = new Node();
            root.setData(b_number);
            root.addToCourses(courseName);
            return root;
        } else if (root.data >= b_number) {
            root.setLeft(insertNodeSorted(root.getLeft(), b_number, courseName));
        } else /*if (root.data < node.data)*/ {
            root.setRight(insertNodeSorted(root.getRight(), b_number, courseName));
        }
        return root;
    }

    /**
     * Calls the insertNodeSorted() method that actually performs the insertion
     * process and finally returns the link to the root of the actual binary
     * search tree.
     *
     * @param b_number
     * @param courseName
     */
    public void insertNode(int b_number, String courseName) {
        this.node_orig = insertNodeSorted(this.node_orig, b_number, courseName);
    }

    /**
     * this method inserts the course to the proper node by first navigating to
     * the node using in-order traversal.
     *
     * @param node
     * @param b_number
     * @param courseName
     * @return
     */
    public Node insertCourseSorted(Node node, int b_number, String courseName) {
        if (b_number == node.getData()) {
            node.addToCourses(courseName);
        } else if (node.data >= b_number) {
            node.setLeft(insertCourseSorted(node.getLeft(), b_number, courseName));
        } else if (node.data < b_number) {
            node.setRight(insertCourseSorted(node.getRight(), b_number, courseName));
        }
        return node;
    }

    /**
     * Calls insertCourseSorted() method that actually performs the insertion of
     * the course to the required node's courses array list.
     *
     * @param b_number
     * @param courseName
     */
    public void insertCourse(int b_number, String courseName) {
        this.node_orig = insertCourseSorted(this.node_orig, b_number, courseName);
    }

    /**
     * Removes the course requested by finding the node in the tree.
     *
     * @param node
     * @param b_number
     * @param courseName
     * @return
     */
    public Node removeCourseFromNode(Node node, int b_number, String courseName) {
        if (b_number == node.getData()) {
            node.removeFromCourses(courseName);
        } else if (node.getData() >= b_number) {
            node.setLeft(removeCourseFromNode(node.getLeft(), b_number, courseName));
        } else if (node.getData() < b_number) {
            node.setRight(removeCourseFromNode(node.getRight(), b_number, courseName));
        }
        return node;
    }

    /**
     * calls removeCourseFromNode() method to perform removal of the courseName.
     *
     * @param b_number
     * @param courseName
     */
    public void removeCourse(int b_number, String courseName) {
        this.node_orig = removeCourseFromNode(this.node_orig, b_number, courseName);
    }

    /**
     * calls the printInorder() method to print the nodes of the tree.
     *
     * @param results
     */
    public void printNodes(Results results) {
        printInorder(node_orig, results);
    }

    /**
     * Performs the printing of the tree nodes in the sorted fashion. The string
     * line is forwarded to the results object which actually stores the output
     * line instead of letting it print on the command line interface.
     *
     * @param node
     * @param results
     */
    public void printInorder(Node node, Results results) {
        if (node.left != null) {
            printInorder(node.left, results);
        }
        /**
         * Print b_number along with all the courses
         */
        String outputLine = "";
        outputLine = String.valueOf(node.data) + ": ";
        ArrayList courses = node.getCourses();
        for (int i = 0; i < courses.size(); i++) {
            String C = node.getCourse(i);
            outputLine += C;
            if (i != node.courses.size() - 1) {
                outputLine += ", ";
            }
        }
        results.storeLine(outputLine);
        if (node.right != null) {
            printInorder(node.right, results);
        }
    }

}

