package org.broadinstitute.hiring;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * A type to represent a fictional on-screen keyboard for a Netflix-like system.
 */
public final class Keyboard {
	private final List<CharSequence> rows;

	public Keyboard(final List<CharSequence> rows) {
		super();
		this.rows = rows;
	}

	/**
     * The rows of keys on this keyboard.  For example, on a querty keyboard, the first row is
     * q, w, e, r, t, y, u, i, o, p
     */
	public List<CharSequence> getRows() {
		return rows;
	}

	/**
	 * Given a position (a row and column), return an Optional wrapping the character at that row and column on this
	 * keyboard.  If the position is out-of-bounds, return Optional.empty().
	 */
	public final Optional<Character> charAt(final Position position) {
		final int row = position.getRow();
		final int column = position.getColumn();

		if (isValidRow(row) && isValidColumn(row, column)) {
			return Optional.of(rows.get(row).charAt(column));
		} else {
			return Optional.empty();
		}
	}
	
	/**
	 * Widely used in North America
	 */
	public static final Keyboard Qwerty = new Keyboard(Arrays.asList(
		"qwertyuiop",
		"asdfghjkl",
		"zxcvbnm"));
	  
	/**
	 * Most common in France
	 */
	public static final Keyboard Azerty = new Keyboard(Arrays.asList(
		"azertyuiop",
		"qsdfghjklm",
		"wxcvbn"));

    /**
	 * Widely used in German-speaking countries
	 */
	public static final Keyboard Qwertz = new Keyboard(Arrays.asList(
		"qwertzuiopü",
		"asdfghjklöä",
		"yxcvbnm"));
	  
    /**
	 * Arranges letters in rows of 8 or 9 letters, starting with 'a' and proceeding in (English) alphabetical order.
	 */
	public static final Keyboard Alphabetical = new Keyboard(Arrays.asList(
		"abcdefghi",
		"jklmnopqr",
		"stuvwxyz"));

	private Boolean isValidRow(final int row) {
		return row >= 0 && row < rows.size();
	}

	private Boolean isValidColumn(final int row, final int column) {
		return column >= 0 && column < rows.get(row).length();
	}

	@Override
	public String toString() {
		return "Keyboard [rows=" + rows + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (rows == null ? 0 : rows.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Keyboard other = (Keyboard) obj;
		if (rows == null) {
			if (other.rows != null) {
				return false;
			}
		} else if (!rows.equals(other.rows)) {
			return false;
		}
		return true;
	}
}
