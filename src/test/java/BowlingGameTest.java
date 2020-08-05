import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    @Test
    public void shouldCalculateWhenLastGameStrike(){
        int[] gameInfo = {10,0,1,9,2,4,5,4,3,1,6,1,1,2,10,0,2,6,10,0,10,0};
        BowlingGame bowlingGame = new BowlingGame();
        assertEquals(bowlingGame.getScore(gameInfo),107);
    }

    @Test
    public void shouldCalculateWhenLastGameSpare(){
        int[] gameInfo = {10,0,1,9,2,4,5,4,3,1,6,1,1,2,10,0,2,6,5,5,5,0};
        BowlingGame bowlingGame = new BowlingGame();
        assertEquals(bowlingGame.getScore(gameInfo),102);
    }
    @Test
    public void shouldCalculateWhenLastGameNotStrikeOrSpare(){
        int[] gameInfo = {10,0,1,9,2,4,5,4,3,1,6,1,1,2,10,0,2,6,4,3,0,0};
        BowlingGame bowlingGame = new BowlingGame();
        assertEquals(bowlingGame.getScore(gameInfo),94);
    }
}
