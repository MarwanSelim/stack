package eg.edu.alexu.csd.datastructure.stack.cs73;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {
       ExpressionEvaluator m= new ExpressionEvaluator();
    @org.junit.jupiter.api.Test
    void infixToPostfix() {
        assertEquals("2 3 4 * +",m.infixToPostfix("2+3*4"));
        assertEquals("a b * 5 +",m.infixToPostfix("a * b +5"));
        assertEquals("a b c - d + / e a - * c *",m.infixToPostfix("(a/(b-c+d))*(e-a)*c"));
        assertThrows(RuntimeException.class,()->m.infixToPostfix("2+3)"));
        assertThrows(RuntimeException.class,()->m.infixToPostfix("*5+62-(5*6)"));
        assertThrows(RuntimeException.class,()->m.infixToPostfix("5+23*(6"));
    }

    @org.junit.jupiter.api.Test
    void evaluate() {
       assertEquals(14,m.evaluate(m.infixToPostfix("2+3*4")));
       assertEquals(52,m.evaluate(m.infixToPostfix("(5+8)*4")));
        assertThrows(RuntimeException.class,()->m.evaluate(m.infixToPostfix("a * b +5")));
        assertThrows(RuntimeException.class,()->m.evaluate(m.infixToPostfix("5/0")));

    }
}