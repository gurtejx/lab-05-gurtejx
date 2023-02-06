
import org.example.TreeCollection;
import org.example.TreeIterator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TreeCollectionTest {

  TreeCollection tc;

  @BeforeAll
  void setup() {
    tc = new TreeCollection();
    tc.insert(7);
    tc.insert(5);
    tc.insert(4);
    tc.insert(6);
    tc.insert(1);
    tc.insert(3);
  }

  @Test
  void testEmptyCollection() {
    TreeCollection empty = new TreeCollection();
    TreeIterator i = (TreeIterator) empty.iterator();
    assertTrue(!i.hasNext());
  }

  @Test
  void testStructure() {
    assertEquals(7, tc.getRoot().value);
    assertEquals(5, tc.getRoot().left.value);
    assertEquals(4, tc.getRoot().left.left.value);
    assertEquals(1, tc.getRoot().left.left.left.value);
    assertEquals(3, tc.getRoot().left.left.left.right.value);
    assertEquals(6, tc.getRoot().left.right.value);
    assertEquals(null, tc.getRoot().left.left.left.left); // left of the node storing 1
    assertEquals(null, tc.getRoot().left.left.right); // right of the node storing 4
  }

  @Test
  void testRoot() {
    TreeIterator i = (TreeIterator) tc.iterator();
    assertTrue(i.hasNext());
    assertEquals(7, i.next());
  }

  @Test
  void testLastLeftNodeNodeIsNull() {
    assertEquals(null, tc.getRoot().left.left.left.left);
  }

  @Test
  void testLeftMostNode() {
    TreeIterator i = (TreeIterator) tc.iterator();
    if (i.hasNext()) {
      i.next();
    };
    assertEquals(5, i.next());
  }

  @Test
  void testIteratorFlowsBack() {
    TreeIterator i = (TreeIterator) tc.iterator();
    for (int j = 1; j <= 4; j++) {
      i.next();
    }
    assertEquals( 3, i.next());
  }

  @Test
  void testFirstLeftNode() {
    assertEquals(5, tc.getRoot().left.value);
  }

  @Test
  void testLastNode() {
    TreeIterator i = (TreeIterator) tc.iterator();
    for (int j = 1; j <= 5; j++) {
      i.next();
    }
    assertEquals(6, i.next());
  }

  @Test
  void testNoOfNodes() {
    TreeIterator i = (TreeIterator) tc.iterator();
    int number = 0;
    while (i.hasNext()) {
      i.next();
      number++;
    }
    assertEquals(6, number);
  }

}
