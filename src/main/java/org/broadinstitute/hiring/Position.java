package org.broadinstitute.hiring;

/**
 * A class representing a position on a virtual keyboard, described by a row and column index.
 * The constructor will throw if negative column or row indices are passed in.
 */
public final class Position {
	private final int row;
	private final int column;

	public Position(final int row, final int column) {
		super();
		
		if(row < 0) {
			throw new IllegalArgumentException("row must be >= 0, but was " + row);
		}
		
		if(column < 0) {
			throw new IllegalArgumentException("column must be >= 0, but was " + column);
		}
		
		this.row = row;
		this.column = column;
	}

	public static Position of(final int row, final int column) {
		return new Position(row, column);
	}
	
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	private Position withRow(final int row) { 
		return new Position(row, this.column);
	}
	
	private Position withColumn(final int column) { 
		return new Position(this.row, column);
	}
	
	/** The Position obtained by moving up from this Position */ 
	public Position up() { return withRow(row - 1); }
	
    /** The Position obtained by moving down from this Position */
	public Position down() { return withRow(row + 1); }
	
	/** The Position obtained by moving left from this Position */
	public Position left() { return withColumn(column - 1); }
	
	/** The Position obtained by moving right from this Position */
	public Position right() { return withColumn(column + 1); }

	/** The Position obtained by moving from this Position in the direction indicated by the passed button. */
	public Position move(final Button button) {
		if(button.isUp()) { return up(); }
		if(button.isDown()) { return down(); }
		if(button.isLeft()) { return left(); }
		if(button.isRight()) { return right(); }
		
		throw new IllegalArgumentException("Only directions are allowed, but got " + button);
	}
	
	@Override
	public String toString() {
		return "Position [row=" + row + ", column=" + column + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
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
		final Position other = (Position) obj;
		if (column != other.column) {
			return false;
		}
		if (row != other.row) {
			return false;
		}
		return true;
	}

}
