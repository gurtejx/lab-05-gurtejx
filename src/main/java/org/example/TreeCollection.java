package org.example;

import java.util.Iterator;

public class TreeCollection implements Iterable {

  // the root or the very first of the tree collection of nodes.
  Node root;

  /**
   * inserts a node in the tree collection.
   * This method inserts the node by comparing it to the current node and
   * then adding the node at an appropriate place using a determined logic.
   *
   * @param n the new value to be added to the collection at some new node
   */
  public void insert(int n) {
    Node temp = new Node(n);

    if (root == null) {
      root = temp;
      return;
    }

    Node current = root;
    while (current != null) {
      if (current.left == null && temp.value <= current.value) {
        current.left = temp;
        return;
      } else if (current.right == null && temp.value > current.value) {
        current.right = temp;
        return;
      } else if (temp.value <= current.value) {
        current = current.left;
      } else if (temp.value > current.value) {
        current = current.right;
      }
    }
  }

  public Node getRoot() {
    return this.root;
  }

  @Override
  public Iterator iterator() {
    return new TreeIterator(root);
  }
}
