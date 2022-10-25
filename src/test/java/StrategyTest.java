import com.bst.BinarySearchTree;
import com.bst.Student;
import com.bst.strategy.*;
import org.junit.jupiter.api.Test;

import java.util.*;


public class StrategyTest extends BSTTest{
    @Test
    void testAscendingNameOrderingStrategy() {
        bst = new BinarySearchTree<>(new AscendingOrderNameStrategy().order());
        bst.addAll(testData);
        testData.sort(Comparator.comparing(Student::getLastName).thenComparing(Student::getLastName));

        testOrder();

    }

    @Test
    void testDescendingNameOrderingStrategy() {
        bst = new BinarySearchTree<>(new DescendingOrderNameStrategy().order());
        bst.addAll(testData);
        testData.sort(Comparator.comparing(Student::getLastName).thenComparing(Student::getLastName).reversed());

        testOrder();

    }

    @Test
    void testAscendingGPAOrderStrategy() {
        bst = new BinarySearchTree<>(new AscendingOrderGPAStrategy().order());
        bst.addAll(testData);

        testData.sort((Student s1, Student s2) -> {
            Integer s1RoundedGPA = (int)Math.round(s1.getGpa());
            Integer s2RoundedGPA = (int)Math.round(s2.getGpa());
            Integer cmp = s1RoundedGPA == s2RoundedGPA ? s1.getRedId().compareTo(s2.getRedId()) :
                    Integer.compare(s1RoundedGPA,s2RoundedGPA);
            return cmp;
        });

        testOrder();
    }

    @Test
    void testDescendingGPAOrderStrategy() {

        bst = new BinarySearchTree<>(new DescendingOrderGPAStrategy().order());
        bst.addAll(testData);
        Comparator<Student> comparator = (Student s1, Student s2) -> {
            Integer s1RoundedGPA = (int)Math.round(s1.getGpa());
            Integer s2RoundedGPA = (int)Math.round(s2.getGpa());
            Integer cmp = s1RoundedGPA == s2RoundedGPA ? s1.getRedId().compareTo(s2.getRedId()) :
                    Integer.compare(s1RoundedGPA,s2RoundedGPA);
            return cmp;
        };
        testData.sort(comparator.reversed());

        testOrder();

    }

    @Test
    void testAscendingRedidOrderStrategy() {
        bst = new BinarySearchTree<>(new AscendingOrderRedIdStrategy().order());
        bst.addAll(testData);
        testData.sort(Comparator.comparing(Student::getRedId));

        testOrder();
    }
    @Test
    void testDescendingRedidOrderStrategy() {
        bst = new BinarySearchTree<>(new DescendingOrderRedIdStrategy().order());
        bst.addAll(testData);
        testData.sort(Comparator.comparing(Student::getRedId).reversed());

        testOrder();
    }

}
