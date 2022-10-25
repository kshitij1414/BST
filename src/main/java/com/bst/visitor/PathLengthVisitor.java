package com.bst.visitor;

import com.bst.BinarySearchTree;
import com.bst.INode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is an implementation of a visitor, which calculates the maximum path length and the average path length
 * for the BST.
 * The visitor must be sent as a parameter to the accept method of the root of the tree.
 *
 * @author Kshitij Poojary <kpoojary4401@sdsu.edu>
 */
public class PathLengthVisitor implements Visitor{
    private List<Integer> leafNodeDepths;
    private HashMap<INode,Integer> depthMap;
    private int depth;
    private INode parent = null;
    private INode current = null;

    public PathLengthVisitor(){
        leafNodeDepths = new ArrayList<>();
        depthMap = new HashMap<>();
    }
    /**
     * Traverses the tree, and preserves the depth as well as the parent node in current before
     * traversing the subtrees, if a node of type BinarySearchTree.Node is sent as a param
     * @param node of type BinarySearchTree.Node
     */
    public void visit(BinarySearchTree.Node node) {
        current  = node;
        depth += 1;
        depthMap.put(node, depth);

        node.getLeft().accept(this);

        current = node;
        depth = depthMap.get(node);
        node.getRight().accept(this);
    }

    /**
     * Checks for a leaf node and stores the value of the depths of the leaf nodes in a list.
     * A leaf node is node of type Node , which has both its children as NullNodes.
     * More specifically it checks if the current node(which will be the calling node) is same as the parent node , which is
     * set by a previously called NullNode. If for any null node the current calling node is same as the set parent node ,
     * it means that the current calling node is a leaf node as this property is exclusive only to leaf nodes.
     * @param node of type NullNode
     */
    public void visit(BinarySearchTree.NullNode node) {

        if (current == null) {
            return;
        }
        if (parent == null || parent != current)
        {
            parent = current;
        } else {
            leafNodeDepths.add(depth - 1);
        }
    }

    /**
     * Calculates the average of all the different paths in the BST. A path is calculated as
     * the number of edges between a root and the respective leaf node.
     * @return average path length of the BST.
     */
    public double getAverageLength() {
        if (leafNodeDepths.size() == 0) {
            return 0;
        }
        double sum = 0;
        for (Integer value : leafNodeDepths) {
            sum += value;
        }
        return (sum / leafNodeDepths.size()) ;
    }

    /**
     * Calculates the maximum of all the different paths in the BST. A path is calculated as
     * the number of edges between a root and the respective leaf node.
     * @return maximum path length of the BST.
     */
    public int getMaximumLength() {
        int max = 0;
        for(Integer value : leafNodeDepths) {
            if(value > max) {
                max = value;
            }
        }
        return max;
    }
}
