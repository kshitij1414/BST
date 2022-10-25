import com.bst.BinarySearchTree;
import com.bst.INode;
import com.bst.Student;
import com.bst.strategy.AscendingOrderRedIdStrategy;
import com.bst.visitor.NumberOfNullNodesVisitor;
import com.bst.visitor.PathLengthVisitor;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest extends BSTTest{

    @Test
    void testNullNodesCount() {
        NumberOfNullNodesVisitor visitor = new NumberOfNullNodesVisitor();
        INode root = bst.getRoot();
        root.accept(visitor);
        assertEquals(11, visitor.getCount());
    }

    @Test
    void testMaxPathLength() {
        PathLengthVisitor visitor = new PathLengthVisitor();
        INode root = bst.getRoot();
        root.accept(visitor);
        assertEquals(7, visitor.getMaximumLength());
    }

    @Test
    void testAveragePathLength() {
        PathLengthVisitor visitor = new PathLengthVisitor();
        INode root = bst.getRoot();
        root.accept(visitor);
        assertEquals(4, visitor.getAverageLength(), 0);
    }

    @Test
    void testMaxPathLengthForEmptyTree() {
        BinarySearchTree<Student> bst = new BinarySearchTree<Student>(new AscendingOrderRedIdStrategy().order());
        PathLengthVisitor visitor = new PathLengthVisitor();
        INode root = bst.getRoot();
        root.accept(visitor);
        assertEquals(0, visitor.getMaximumLength());
    }

    @Test
    void testAverageLengthForEmptyTree() {
        BinarySearchTree<Student> bst = new BinarySearchTree<Student>(new AscendingOrderRedIdStrategy().order());
        PathLengthVisitor visitor = new PathLengthVisitor();
        INode root = bst.getRoot();
        root.accept(visitor);
        assertEquals(0, visitor.getAverageLength(),0);
    }

    @Test
    void testNullNodeCountForEmptyTree() {
        BinarySearchTree<Student> bst = new BinarySearchTree<Student>(new AscendingOrderRedIdStrategy().order());
        NumberOfNullNodesVisitor visitor = new NumberOfNullNodesVisitor();
        INode root = bst.getRoot();
        root.accept(visitor);
        assertEquals(1, visitor.getCount());
    }


}
