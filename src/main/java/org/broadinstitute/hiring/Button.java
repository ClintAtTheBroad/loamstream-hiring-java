package org.broadinstitute.hiring;

/**
 * An enum to represent all the buttons on our remote control
 */
public enum Button {
	Up, Down, Left, Right, Select;

	public Boolean isUp() {
		return this == Up;
	}

	public Boolean isDown() {
		return this == Down;
	}

	public Boolean isLeft() {
		return this == Left;
	}

	public Boolean isRight() {
		return this == Right;
	}

	public Boolean isSelect() {
		return this == Select;
	}

	public boolean isDirection() {
		return isUp() || isDown() || isLeft() || isRight();
	}
}
