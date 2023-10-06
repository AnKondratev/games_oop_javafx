package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BishopBlackTest {

    @Test
    public void bishopBlackStartPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(Cell.C8.equals(bishopBlack.position())).isEqualTo(true);
    }

    @Test
    public void bishopBlackCopyTestPositions() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Figure bishopBlackCopy = bishopBlack.copy(Cell.E6);
        assertThat(Cell.E6.equals(bishopBlackCopy.position())).isEqualTo(true);
    }

    @Test
    public void testWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] actual = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(Arrays.equals(result, actual)).isTrue();
    }
}