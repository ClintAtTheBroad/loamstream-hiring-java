package org.broadinstitute.hiring;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

public final class KeyboardTest {
	@Test
	public void testCharAt() {
		final Optional<Character> none = Optional.empty();

		// past the (right) end
		assertEquals(none, charAt(pos(0, 10)));
		assertEquals(none, charAt(pos(1, 9)));
		assertEquals(none, charAt(pos(2, 7)));

		// way past the (right) end
		assertEquals(none, charAt(pos(0, 42)));
		assertEquals(none, charAt(pos(1, 42)));
		assertEquals(none, charAt(pos(2, 42)));

		// valid keys
		assertEquals(some('q'), charAt(pos(0, 0)));
		assertEquals(some('w'), charAt(pos(0, 1)));
		assertEquals(some('e'), charAt(pos(0, 2)));
		assertEquals(some('r'), charAt(pos(0, 3)));
		assertEquals(some('t'), charAt(pos(0, 4)));
		assertEquals(some('y'), charAt(pos(0, 5)));
		assertEquals(some('u'), charAt(pos(0, 6)));
		assertEquals(some('i'), charAt(pos(0, 7)));
		assertEquals(some('o'), charAt(pos(0, 8)));
		assertEquals(some('p'), charAt(pos(0, 9)));

		assertEquals(some('a'), charAt(pos(1, 0)));
		assertEquals(some('s'), charAt(pos(1, 1)));
		assertEquals(some('d'), charAt(pos(1, 2)));
		assertEquals(some('f'), charAt(pos(1, 3)));
		assertEquals(some('g'), charAt(pos(1, 4)));
		assertEquals(some('h'), charAt(pos(1, 5)));
		assertEquals(some('j'), charAt(pos(1, 6)));
		assertEquals(some('k'), charAt(pos(1, 7)));
		assertEquals(some('l'), charAt(pos(1, 8)));

		assertEquals(some('z'), charAt(pos(2, 0)));
		assertEquals(some('x'), charAt(pos(2, 1)));
		assertEquals(some('c'), charAt(pos(2, 2)));
		assertEquals(some('v'), charAt(pos(2, 3)));
		assertEquals(some('b'), charAt(pos(2, 4)));
		assertEquals(some('n'), charAt(pos(2, 5)));
		assertEquals(some('m'), charAt(pos(2, 6)));
	}

	// Dumb methods to make porting easier
	private Position pos(final int row, final int column) {
		return Position.of(row, column);
	}

	private Optional<Character> charAt(final Position position) {
		return Keyboard.Qwerty.charAt(position);
	}

	private <A> Optional<A> some(final A a) {
		return Optional.of(a);
	}
}
