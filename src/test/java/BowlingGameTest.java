import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {
 /*   @Test
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
    }*/

    /**
     * 1.判断输入数据是否符合规则
     * a.计分次数不够或者超出(不考虑每局pin是否符合规则)，最多有21次计分，最少有11次计分
     * b.考虑每局分数是否符合规则(每局每次计分不应超过10或者小于0)
     * c.相邻
     */
    @Test
    void inputArrayLengthShouldNotMoreThan21NotLess10WithoutEveryPin() {
        int[] gameInfo_less10_without_every_time_pin = {10, 2, 3, 4, 5, 6, 7};
        int[] gameInfo_too_many_without_every_time_pin = {1, 2, 3, 4, 5, 6, 7, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 54, 5, 6, 7, 5, 5, 5, 5, 5, 5,};

        assertFalse(BowlingGame.isInputFollowRule(gameInfo_less10_without_every_time_pin));
        assertFalse(BowlingGame.isInputFollowRule(gameInfo_too_many_without_every_time_pin));

    }

    @Test
    void inputEveryPinShouldNotMoreThan10NotLess0() {
        int[] gameInfo_exist_pin_more_than_10 = {12, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int[] gameInfo_exist_pin_less_than_0 = {-1, 1, 2, 3, 1, 4, 5, 6, 8, 4};
        assertFalse(BowlingGame.isInputFollowRule(gameInfo_exist_pin_more_than_10));
        assertFalse(BowlingGame.isInputFollowRule(gameInfo_exist_pin_less_than_0));
    }

    




}
