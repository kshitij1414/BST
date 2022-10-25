package com.bst.visitor;

import com.bst.BinarySearchTree;

public interface Visitor {

    void visit(BinarySearchTree.Node node);
    void visit(BinarySearchTree.NullNode node);

}