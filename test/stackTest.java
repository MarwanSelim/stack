package eg.edu.alexu.csd.datastructure.stack.cs73;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class stackTest {
          stack m = new stack();
    @Test
    void push() {
        m.push('5');
        m.push(5);
        m.push("5");
    }

    @Test
    void pop() {
        // here we test three types of data to make sure our stack works with any thing
        m.push('5');
        m.push(5);
        m.push("5");
        assertEquals("5",m.pop());
        assertEquals(5,m.pop());
        assertEquals('5',m.pop());
        assertThrows(RuntimeException.class,()->m.pop());
    }

    @Test
    void peek() {
        m.push(5);
        m.push(6);
        assertEquals(6,m.peek());
        m.pop();
        assertEquals(5,m.peek());
        m.pop();
        // here our stack is empty and we see if the class will give an error
        assertThrows(RuntimeException.class,()->m.peek());
    }

    @Test
    void isEmpty() {
        assertEquals(true,m.isEmpty());
        m.push(2);
        assertEquals(false,m.isEmpty());
    }

    @Test
    void size() {
        assertEquals(0,m.size());
        m.push(3);
        m.push(5);
        assertEquals(2,m.size());
    }
}