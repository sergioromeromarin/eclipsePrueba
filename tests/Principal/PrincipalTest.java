package Principal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Principal class.
 * These tests validate the overridden Object methods.
 */
@DisplayName("Principal Class Tests")
public class PrincipalTest {

    private Principal principal;
    private Principal otherPrincipal;

    @BeforeEach
    public void setUp() {
        principal = new Principal();
        otherPrincipal = new Principal();
    }



    @Test
    @DisplayName("Test equals() with null should return false")
    public void testEqualsWithNull() {
        assertFalse(principal.equals(null), 
                "An object should not be equal to null");
    }

    @Test
    @DisplayName("Test equals() with different object")
    public void testEqualsWithDifferentObject() {
        // Since equals() is not overridden with custom logic, 
        // different instances should not be equal
        assertFalse(principal.equals(otherPrincipal), 
                "Different instances should not be equal using default Object.equals()");
    }

    @Test
    @DisplayName("Test equals() with object of different class")
    public void testEqualsWithDifferentClass() {
        String differentObject = "test";
        assertFalse(principal.equals(differentObject), 
                "Object should not be equal to an object of different class");
    }

    @Test
    @DisplayName("Test hashCode() returns an integer")
    public void testHashCode() {
        int hashCode = principal.hashCode();
        // hashCode returns a primitive int, just verify it can be called
        assertNotEquals(0, hashCode + 1, "hashCode should return a valid integer");
    }

    @Test
    @DisplayName("Test hashCode() consistency")
    public void testHashCodeConsistency() {
        int hashCode1 = principal.hashCode();
        int hashCode2 = principal.hashCode();
        assertEquals(hashCode1, hashCode2, 
                "Multiple calls to hashCode() should return the same value");
    }

    @Test
    @DisplayName("Test toString() returns a non-null String")
    public void testToString() {
        String result = principal.toString();
        assertNotNull(result, "toString() should not return null");
    }

    @Test
    @DisplayName("Test toString() contains class name")
    public void testToStringContainsClassName() {
        String result = principal.toString();
        assertTrue(result.contains("Principal"), 
                "toString() should contain the class name");
    }





    @Test
    @DisplayName("Test object instantiation")
    public void testObjectInstantiation() {
        assertNotNull(principal, "Principal object should be instantiated successfully");
        assertTrue(principal instanceof Principal, 
                "Object should be an instance of Principal class");
    }

    @Test
    @DisplayName("Test equals() is symmetric")
    public void testEqualsSymmetric() {
        boolean result1 = principal.equals(otherPrincipal);
        boolean result2 = otherPrincipal.equals(principal);
        assertEquals(result1, result2, 
                "equals() should be symmetric: x.equals(y) should equal y.equals(x)");
    }

    @Test
    @DisplayName("Test equals() is reflexive")
    public void testEqualsReflexive() {
        assertTrue(principal.equals(principal), 
                "equals() should be reflexive: x.equals(x) should be true");
    }

    @Test
    @DisplayName("Test equals() is consistent")
    public void testEqualsConsistent() {
        boolean result1 = principal.equals(otherPrincipal);
        boolean result2 = principal.equals(otherPrincipal);
        boolean result3 = principal.equals(otherPrincipal);
        assertEquals(result1, result2, 
                "Multiple calls to equals() should return consistent results");
        assertEquals(result2, result3, 
                "Multiple calls to equals() should return consistent results");
    }
}
