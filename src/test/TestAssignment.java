package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import assignment.Assignment;

class TestAssignment {

	@Test
	public void testHelicalPrintArrayWithNull() {
		assertEquals("", Assignment.helicalPrintArray(null));
	}

}
