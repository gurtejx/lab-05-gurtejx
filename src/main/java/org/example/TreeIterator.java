package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator {

  Node root;
  int current;

  ArrayList<Node> order;
  public TreeIterator(Node root) {
    this.root = root;
    this.current = 0;
    this.order = DFSOrder();
  }

  public ArrayList<Node> DFSOrder() {
    ArrayList<Node> order = new ArrayList<Node>();

    if (root == null) return order;

    Stack<Node> stack = new Stack<Node>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Node curr = stack.pop();
      order.add(curr);
      if (curr.right != null) stack.push(curr.right);
      if (curr.left != null) stack.push(curr.left);
    }
    return order;
  }

  @Override
  public boolean hasNext() {
    System.out.println(current < order.size());
    if (current < order.size()) {
      return true;
    }
    return false;
  }

  @Override
  public Object next() {
    this.current++;
    return order.get(current - 1).value;
  }
}
