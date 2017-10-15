package studentCoursesBackup.util;

import studentCoursesBackup.myTree.MyTree;
import studentCoursesBackup.myTree.Node;

/**
 * @version 1.0
 * @author Aniruddha Tekade Submitted on October 3rd, 2017.
 */
public class TreeBuilder {

    public MyTree tree, backup_1, backup_2;

    /**
     * Parameterized constructor of the class.
     *
     * @param treeIn
     * @param backupOneIn
     * @param backupTwoIn
     */
    public TreeBuilder(MyTree treeIn, MyTree backupOneIn, MyTree backupTwoIn) {
        this.tree = treeIn;
        this.backup_1 = backupOneIn;
        this.backup_2 = backupTwoIn;

    }

    /**
     * creates and clones the node of the Node class.
     *
     * @param b_number
     * @param courseName
     */
    public void makeNodeObjects(int b_number, String courseName) {
        /**
         * 1. Create Node & clone them & add observers to the original tree node
         */
        Node node = new Node();
        Node bkp_1 = node.clone();
        Node bkp_2 = node.clone();

        /**
         * 2. Add observers to the original node
         */
        /**
         * 3. Insert them into the tree
         */
        tree.insertNode(b_number, courseName);
        backup_1.insertNode(b_number, courseName);
        backup_2.insertNode(b_number, courseName);
    }

    /**
     * Adds the courses to the existing nodes.
     *
     * @param b_number
     * @param courseName
     */
    public void addCourse(int b_number, String courseName) {
        /**
         * 4. Insert the courses to the already existing nodes
         */
        tree.insertCourse(b_number, courseName);
        backup_1.insertCourse(b_number, courseName);
        backup_2.insertCourse(b_number, courseName);
    }

    /**
     * removes the course using internal function of the MyTree class.
     *
     * @param b_number
     * @param courseName
     */
    public void removeCourse(int b_number, String courseName) {
        tree.removeCourse(b_number, courseName);
        backup_1.removeCourse(b_number, courseName);
        backup_1.removeCourse(b_number, courseName);
    }

}

