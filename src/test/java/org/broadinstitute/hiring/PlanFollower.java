package org.broadinstitute.hiring;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public final class PlanFollower {
	private PlanFollower() {
		super();
	}

	public static String follow(final Keyboard keyboard, final List<Button> plan) {
		//NB: Assume we start at column 0, row 0
		final Position start = Position.of(0, 0);
		    
	    final State init = State.of(new StringBuilder(), start);
		    
	    final BinaryOperator<State> combiner = (lhs, rhs) -> {
	    	return State.of(lhs.accumulator.append(rhs.accumulator), rhs.currentPosition);
	    };
	     
	    final BiFunction<State, Button, State> accumulator = (state, button) -> {
	    	final StringBuilder acc = state.accumulator;
	    	final Position currentPosition = state.currentPosition;
	  		      
	    	if(button.isDirection()) {
	    		return State.of(acc, currentPosition.move(button));
	    	}
	    	
	    	if(button.isSelect()) {
	    		final Optional<Character> charOpt = keyboard.charAt(currentPosition);
	    		
	    		charOpt.ifPresent(acc::append);
	    		
	    		return State.of(acc, currentPosition);
	    	}
	    	
	    	throw new IllegalArgumentException("Expected a known type of button, but got " + button);
	    	
	    };
	    
	    final State result = plan.stream().reduce(init, accumulator, combiner);
	    
	    return result.accumulator.toString();
	}
	
	private static final class State {
		public final StringBuilder accumulator;
		public final Position currentPosition;
		
		public State(final StringBuilder accumulator, final Position currentPosition) {
			super();
			this.accumulator = accumulator;
			this.currentPosition = currentPosition;
		}
		
		public static State of(final StringBuilder accumulator, final Position currentPosition) {
			return new State(accumulator, currentPosition);
		}
	}
}
