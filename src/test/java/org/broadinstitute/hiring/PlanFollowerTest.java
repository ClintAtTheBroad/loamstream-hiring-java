package org.broadinstitute.hiring;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import static org.broadinstitute.hiring.Keyboard.Qwerty;
import static org.broadinstitute.hiring.Button.*;

import org.junit.Test;

public final class PlanFollowerTest {
	@Test
	public void testCanFollowButtonPressPlans() {
		final List<Button> plan = Arrays.asList(
				Down, Down, Right, Right, Select, 
			    Up, Left, Left, Select,
			    Right, Right, Right, Right, Up, Select);
			    
	    assertEquals("cat", PlanFollower.follow(Qwerty, plan));
	}
}
