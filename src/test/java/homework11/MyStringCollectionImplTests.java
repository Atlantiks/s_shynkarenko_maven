package homework11;

import org.junit.Test;
import static org.junit.Assert.*;

public class MyStringCollectionImplTests {
    StringCollection c = new MyStringCollectionImpl();

    private void addElementsToCollection(StringCollection col, String ... elems) {
        for (String x:elems) {
            col.add(x);
        }
    }

    @Test
    public void testSize() {
        assertEquals(c.size(),0);
    }

    @Test
    public void testAdd() {
        addElementsToCollection(c,"one","two","four");
        assertFalse(c.add(10, "five"));
        assertTrue(c.add(1, "five"));
    }

    @Test
    public void testGet() {
        addElementsToCollection(c,"one","two");
        assertEquals(c.get(0),"one");
        assertEquals(c.get(1),"two");
    }

    @Test
    public void testContains() {
        addElementsToCollection(c,"one","two","four");
        assertTrue(c.contains("one"));
        assertFalse(c.contains("three"));
    }

    @Test
    public void testDelete() {
        addElementsToCollection(c,"one","two","four");
        assertTrue (c.delete("two"));
        assertFalse (c.delete("two"));
    }

    @Test
    public void testClear() {
        c.add("Some value");

        assertTrue (c.contains("Some value"));
        c.clear();
        assertFalse (c.contains("Some value"));
        assertEquals (c.size(),0);
    }

    @Test
    public void checkEquals() {
        StringCollection c1 = new MyStringCollectionImpl();

        addElementsToCollection(c,"one","two","four");
        addElementsToCollection(c1,"one","two","four");

        assertTrue(c1.equals(c));
        addElementsToCollection(c1,"ten");
        assertFalse(c1.equals(c));

    }
}
