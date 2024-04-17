package com.targetindia.tests;

import com.targetindia.utils.BDD;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.targetindia.utils.BDD.getResultValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SealedClassTests {

    @Test
    @DisplayName("test sealed class")
    public void TestSealedClass() {
        BDD.Success successResult = new BDD.Success(42);
        BDD.Error errorResult = new BDD.Error("Something went wrong");
        assertEquals(42, getResultValue(successResult));
        assertThrows(IllegalArgumentException.class,()->getResultValue(errorResult));
    }

}
