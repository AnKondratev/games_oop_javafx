package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int startX = position().getX();
        int startY = position().getY();
        int destX = dest.getX();
        int dextY = dest.getY();
        int deltaX = startX;
        int deltaY = startY;
        int size = Math.abs(startX - destX);
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            if (startX > destX && startY < dextY) {
                steps[index] = Cell.findBy(--deltaX, ++deltaY);
            } else if (startX < destX && startY < dextY) {
                steps[index] = Cell.findBy(++deltaX, ++deltaY);
            } else if (startX > destX && startY > dextY) {
                steps[index] = Cell.findBy(--deltaX, --deltaY);
            } else if (startX < destX && startY > dextY) {
                steps[index] = Cell.findBy(++deltaX, --deltaY);
            }
        }

        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY());
    }

    @Override
    public String icon() {
        return Figure.super.icon();
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
