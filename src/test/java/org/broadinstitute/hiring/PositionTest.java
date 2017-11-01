package org.broadinstitute.hiring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.broadinstitute.hiring.Button.*;

import java.util.function.Supplier;

import org.junit.Test;

public final class PositionTest {
	private final Position origin = Position.of(0, 0);

	@Test
	public void testGuards() {
		Position.of(0, 0);
		Position.of(123, 0);
		Position.of(0, 234);
		Position.of(45, 67);

		intercept(() -> Position.of(-1, 0));

		intercept(() -> Position.of(-100, 0));

		intercept(() -> Position.of(0, -1));

		intercept(() -> Position.of(0, -100));

		intercept(() -> Position.of(-1, -1));
	}

	@Test
	public void testUp() {
		final Position p = Position.of(123, 456);

		assertEquals(Position.of(122, 456), p.up());

		intercept(() -> origin.up());
	}

	@Test
	public void testDown() {
		final Position p = Position.of(123, 456);

		assertEquals(Position.of(124, 456), p.down());

		assertEquals(Position.of(1, 0), origin.down());
	}

	@Test
	public void testLeft() {
		final Position p = Position.of(123, 456);

		assertEquals(Position.of(123, 455), p.left());

		intercept(() -> origin.left());
	}

	@Test
	public void testRight() {
		final Position p = Position.of(123, 456);

		assertEquals(Position.of(123, 457), p.right());

		assertEquals(Position.of(0, 1), origin.right());
	}

	@Test
	public void testMove() {

		intercept(() -> origin.move(Up));

		intercept(() -> origin.move(Left));

		assertEquals(origin.right(), origin.move(Right));

		assertEquals(origin.down(), origin.move(Down));

		final Position p = Position.of(123, 456);

		assertEquals(p.up(), p.move(Up));
		assertEquals(p.down(), p.move(Down));
		assertEquals(p.left(), p.move(Left));
		assertEquals(p.right(), p.move(Right));
	}
	
	private <A> void intercept(final Supplier<A> pos) {
		try {
			pos.get();

			fail("Expected an exception to be thrown");
		} catch (final Exception expected) {
			// NOOP
		}
	}
}
