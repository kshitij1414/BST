import com.bst.BinarySearchTree;
import com.bst.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public abstract class BSTTest {

    BinarySearchTree<Student> bst;
    List<Student> testData;

    @BeforeEach
    public void init() {
        testData = new ArrayList<>(Arrays.asList(
            (new Student(700,"Dhiraj", "Deshmukh", 3.9)),
            (new Student(500,"Abhishek", "Ranjan", 3.67)),
            (new Student(300,"Javed", "Khan", 3.68)),
            (new Student(600,"Shriraj", "Jahagirdar", 3.1)),
            (new Student(200, "Anuj","Kawane", 3.7)),
            (new Student(400,"Kshitij", "Poojary", 3.8)),
            (new Student(350,"Bhuvan", "Bharadwaj", 3.65)),
            (new Student(375,"Roshan", "Basu", 3.61)),
            (new Student(360,"Deven", "Joshi", 3.8)),
            (new Student(365,"Saurabh", "Kulkarni",3.9))));
        bst = new BinarySearchTree<>();
        bst.addAll(testData);
        testData.sort(Comparator.comparing(Student::getRedId));

    }

    @Test
    public void testOrder(){
        List<Student> actualStudentList = new ArrayList<>();
        bst.forEach(actualStudentList::add);

        assertEquals(testData,actualStudentList);
    }
    @Test
    public void testSize(){
        assertEquals(testData.size(), bst.size());
    }

    @Test
    public void testContainsStudent(){
        BinarySearchTree<Student> bst = new BinarySearchTree<>();
        testData.add(2,(new Student(500,"Shukla", "Ranjan", 3.67)));
        bst.addAll(testData);
        assertTrue(bst.contains(testData.get(2)));
    }

    @Test
    public void testDoesNotContainStudent(){
        Student student = new Student(1000,"Test", "Tester", 4.0);
        assertFalse(bst.contains(student));
    }

    @Test
    public void testAddElement(){
        Student student = new Student(1000,"Test", "Tester", 4.0);
        bst.add(student);
        assertTrue(bst.contains(student));
    }

    @Test
    public void testInternalIterator(){
        bst.forEach((student)-> { student.setRedId(student.getRedId() + 1);});
        testData.forEach((student)-> { student.setRedId(student.getRedId() + 1);});
        testData.sort(Comparator.comparing(Student::getRedId));
        List<Student> actualStudentList = new ArrayList<>();
        bst.forEach(actualStudentList::add);

        assertEquals(testData, actualStudentList);
    }
}