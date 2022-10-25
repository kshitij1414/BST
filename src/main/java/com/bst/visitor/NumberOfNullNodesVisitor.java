package com.bst.visitor;

import com.bst.BinarySearchTree;

/**
 * This is an implementation of a visitor, which calculates the number of null nodes for the tree
 * The visitor must be sent as a parameter to the accept method of the root of the tree.
 *
 * @author Kshitij Poojary <kpoojary4401@sdsu.edu>
 */
public class NumberOfNullNodesVisitor implements Visitor{
    private int count = 0;

    /**
     * Traverses the tree if a node of type BinarySearchTree.node is sent as a param
     * @param node of type BinarySearchTree.node
     */
    public void visit(BinarySearchTree.Node node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
    }

    /**
     * Increments the count variable if BinarySearchTree.node is sent as a param
     * @param node of type BinarySearchTree.node
     */
    public void visit(BinarySearchTree.NullNode node) {
        count ++;
    }

    /**
     * Returns the number of nullnodes in the tree , it is important to call the root's accept method
     * before trying to retrieve the count with this method
     * @return count of nullnodes in the tree
     */
    public int getCount() {
        return count;
    }

}
