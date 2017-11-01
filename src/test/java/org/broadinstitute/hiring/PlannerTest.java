package org.broadinstitute.hiring;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public final class PlannerTest {

	@Test
	public void testSingleLetter0Alphabetical() {
		doTest(new Planner.Default(), Keyboard.Alphabetical, "a");
	}

	@Test
	public void testSingleLetter1Azerty() {
		doTest(new Planner.Default(), Keyboard.Azerty, "a");
	}

	@Test
	public void testSingleLetter2Azerty() {
		doTest(new Planner.Default(), Keyboard.Azerty, "z");
	}

	@Test
	public void testSingleLetter3Qwerty() {
		doTest(new Planner.Default(), Keyboard.Alphabetical, "k");
	}

	@Test
	public void testStarAlphabetical() {
		doTest(new Planner.Default(), Keyboard.Alphabetical, "star");
	}

	@Test
	public void testStarQwerty() {
		doTest(new Planner.Default(), Keyboard.Qwerty, "star");
	}

	@Test
	public void testStarwarsAlphabetical() {
		doTest(new Planner.Default(), Keyboard.Alphabetical, "starwars");
	}

	@Test
	public void testStarwarsQwerty() {
		doTest(new Planner.Default(), Keyboard.Qwerty, "starwars");
	}

	@Test
	public void testLordOfTheRingsAzerty() {
		doTest(new Planner.Default(), Keyboard.Azerty, "lordoftherings");
	}

	@Test
	public void testLordOfTheRingsQwertz() {
		doTest(new Planner.Default(), Keyboard.Qwertz, "lordoftherings");
	}

	@Test
	public void testCatQwerty() {
		doTest(new Planner.Default(), Keyboard.Qwerty, "cat");
	}
	
	private void doTest(final Planner planner, final Keyboard keyboard, final String desired) {
		final List<Button> plan = planner.findButtonPresses(keyboard, desired);

		assertFalse(plan.isEmpty());
		assertEquals(desired.length(), plan.stream().filter(b -> b == Button.Select).count());

		assertEquals(desired, PlanFollower.follow(keyboard, plan));
	}
}
