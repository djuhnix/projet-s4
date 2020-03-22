package chess.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PositionTest {
	private Position pos = new Position(4, 5);
	@Test
	void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testPosition() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testPositionIntInt() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testIsAlgebraicNotation() {
		assertEquals(true, Position.isAlgebraicNotation("16"));
	}

	@Test
	void testPositionString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testToAlgebraicNotation() {
		assertEquals("45", pos.toAlgebraicNotation());
	}

	@Test
	void testIsOnSameLineAs() {
		Position pos1 = new Position("15");
		equals(false, pos.isOnSameLineAs(pos1));; // TODO
	}

	@Test
	void testIsOnSameColumnAs() {
		Position pos1 = new Position("41");
		assertEquals(false, pos.isOnSameColumnAs(pos1));
	}

	@Test
	void testIsOnSameDiagonalAs() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetManhattanDistance() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetX() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGetY() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testSetX() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testSetY() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testEqualsObject() {
		fail("Not yet implemented"); // TODO
	}

}
