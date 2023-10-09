package ru.job4j.chess;

import org.assertj.core.api.AbstractBooleanAssert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenCellOccupied()
            throws OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        PawnBlack pawnBlack = new PawnBlack(Cell.D7);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.add(bishopBlack);
            logic.add(pawnBlack);
            logic.move(bishopBlack.position(), Cell.E6);
        });
        assertThat(exception.getMessage())
                .isEqualTo("The move is impossible, there is an occupied cell in the way"
                );
    }

    @Test
    public void whenFigureBishopImpossibleMove() throws ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.add(bishopBlack);
            logic.move(bishopBlack.position(), Cell.C6);
        });
        assertThat(exception.getMessage()).isEqualTo(
                "Could not move by diagonal from %s to %s",
                bishopBlack.position(), Cell.C6
        );
    }
}
