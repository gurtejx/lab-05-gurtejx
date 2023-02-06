package org.example;

import java.util.ArrayList;

/**
 * driver class for Node, TreeCollection, and TreeIterator class.
 *
 * @author Gurtej Malik
 * @version 1.0
 */
public class Main {
  public static void main(String[] args) {
    TreeCollection tc = new TreeCollection();
    tc.insert(7);
    tc.insert(5);
    tc.insert(4);
    tc.insert(6);
    tc.insert(1);
    tc.insert(3);

    TreeIterator i = (TreeIterator) tc.iterator();
    ArrayList<Node> order = i.DFSOrder();
    for (int j = 0; j < order.size(); j++) {
      System.out.println(order.get(j));
    }
  }
}