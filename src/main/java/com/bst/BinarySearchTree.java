package com.bst;

import com.bst.visitor.Visitor;
import java.util.*;
import java.util.function.Consumer;

/**
 * This is an implementation of Binary Search tree. Current implementation has these features :-
 * 1. Adding any data to BST
 * 2. Check if a data exists in the BST
 * A BST  is a rooted binary tree data structure with the key of each internal node being greater than all the keys in
 * the respective node's left subtree and less than the ones in its right subtree.
 *
 * @author Kshitij Poojary <kpoojary4401@sdsu.edu>
 */
public class BinarySearchTree<E extends Comparable<E>>  {
    private INode<E> root;
    private int size;
    private Comparator<? super E> comparator;
    public BinarySearchTree() {
        initializeProperties();
    }
    /**
     * Initializes BST with given strategy
     *
     * @param comparator denotes the strategy by which nodes will be inserted in the BST.
     */
    public BinarySearchTree(Comparator<? super E> comparator) {
        initializeProperties();
        this.comparator = comparator;
    }

    private void initializeProperties() {
        this.root = new NullNode();
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public INode getRoot() {
        return root;
    }

    /**
     * Compares two keys using either a strategy or the default comparsion method for the given data.
     */
    final int compare(Object e1, Object e2) {
        return comparator == null ? ((Comparable<? super E>) e1).compareTo((E) e2)
                : comparator.compare((E) e1, (E) e2);
    }

    /**
     * Adds element to the BST depending on the strategy the BST is initialized with.
     * More specifically , if the tree is empty it sets the incoming node as the root of the tree
     * And if the tree is not empty it calls a node level add method , where in the nodes of the BST
     * decide where the incoming node should be placed in the BST
     * @param e element whose presence in this collection is to be ensured
     * @return
     */
    public boolean add(E e) {
        INode<E> newNode = new Node(e, new NullNode(), new NullNode());
        if (size() == 0 ) {
            root = newNode;
        } else {
            root.add(root, newNode);
        }
        size++;
        return true;
    }

    /**
     * Inserts all the data in the incoming list to the BST
     * @param c list of data that needs to be added to the BST
     * @return true if all the elements are added successfully , false otherwise
     */
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    /**
     * Internal Iterator
     * This performs the given action on all elements of the BST
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     */
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        getRoot().apply(action);
    }

    /**
     * Checks if the incoming data exists in the BST.
     * @param e data that needs to be checked if it exists in the tree
     * @return true if the element exists , false otherwise.
     */
    public boolean contains(E e) {
        return root.contains(e);
    }

    public class Node implements INode<E> {
        INode<E> left;
        INode<E> right;
        E value;

        public Node(E node, INode<E> left,INode<E> right) {
            this.value = node;
            this.left = left;
            this.right = right;
        }

        public INode<E> getLeft() {
            return left;
        }

        public boolean setLeft(INode<E> node) {
            this.left = node;
            return true;
        }

        public INode<E> getRight() {
            return right;
        }
        public boolean setRight(INode<E> node) {
            this.right = node;
            return true;
        }

        public E getValue() {
            return value;
        }

        public boolean setValue(E value) {
            this.value = value;
            return true;
        }

        /**
         * Adds the incoming node to the BST
         * More specifically decides the correct subtree that the node should be inserted in.
         * @param parent Parent of the current node
         * @param node Node to be added to the BST
         * @return true if the node is added , false if not.
         */
        public boolean add(INode<E> parent, INode<E> node) {
            if (compare(this.value,node.getValue()) < 0) {
                this.getRight().add(this,node);
            } else {
                this.getLeft().add(this, node);
            }
            return true;
        }

        /**
         * Accepts the visitor and makes a call to the appropriate visitor by sending the reference of the calling node
         * @param visitor
         */
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }


        /**
         * Checks if the incoming node exists in the BST
         * More specifically decided the correct subtree to traverse in order to find the node in the tree
         * If the current node contains the incoming data , we return true
         * @param e the data that needs to be searched for in the BST
         * @return true if the data exists, false if it does not
         */
        public boolean contains(E e) {
            int cmp = compare(this.getValue(), e);
            if (cmp < 0) {
                return this.getRight().contains(e);
            } else if(cmp > 0) {
                return this.getLeft().contains(e);
            } else {
                if(this.getValue().equals(e)) {
                    return true;
                }
                return this.getLeft().contains(e);
            }
        }

        /**
         * Implements the calling action on the nodes of the subtree
         * First, implements the action on all the nodes in the left subtree
         * Then implements the action on the calling node
         * Then implements the action on all the nodes of the right subtree
         * @param action
         */
        public void apply(Consumer<? super E> action) {
            this.getLeft().apply(action);
            action.accept(this.value);
            this.getRight().apply(action);
        }

    }

    public class NullNode implements INode<E> {
        INode<E> left;
        INode<E> right;
        E value;

        public NullNode() {
            this.value = null;
        }

        public INode<E> getLeft() {
            return null;
        }

        public INode<E> getRight() {
            return right;
        }
        public boolean setRight(INode<E> node) {
            this.right = node;
            return true;
        }

        public boolean setLeft(INode<E> node) {
            this.left = node;
            return true;
        }

        public E getValue() {
            return value;
        }

        /**
         * Adds the incoming node to the BST
         * More specifically adds the incoming node to the appropriate parent of the calling node
         * @param parent the parent node of the calling node
         * @param node the incoming node that needs to be added to the BST.
         * @return
         */
        public boolean add(INode<E> parent, INode<E> node) {
            if (compare(parent.getValue(),node.getValue()) < 0) {
                parent.setRight(node);
            } else {
                parent.setLeft(node);
            }
            return true;
        }

        /**
         * Accepts the visitor and makes a call to the appropriate visitor by sending the reference of the calling node
         * @param visitor
         */
        public void accept(Visitor visitor) {
             visitor.visit(this);
        }

        /**
         * Checks if the incoming data exists in the BST.
         * A do nothing function
         * Returns false as this node will never have any subtree
         * @param e incoming node to be checked
         * @return false
         */
        public boolean contains(E e) {
            return false;
        }

        /**
         * Implements the incoming action to all the nodes of the BST
         * A do nothing function
         * @param action to be implemented on each node
         */
        public void apply(Consumer<? super E> action) {}

    }

}
