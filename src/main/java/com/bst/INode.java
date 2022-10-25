package com.bst;

import com.bst.visitor.Visitor;

import java.util.function.Consumer;

public interface INode<E extends Comparable<E>> {

    boolean add(INode<E> parent, INode<E> node);

    INode<E> getLeft();

    INode<E> getRight();

    boolean setRight(INode<E> node);
    boolean setLeft(INode<E> node);

    boolean contains(E e);

    E getValue();

    void accept(Visitor visitor);

    void apply(Consumer<? super E> action);

}
