package org.example;

public class Node {
  public Node right;
  public Node left;
  public Node parent;
  public int value;

  public Node(int i) {
    this.value = i;
  }

  public String toString() {
    String output = "";
    output += this.value;
    return output;
  }
}
