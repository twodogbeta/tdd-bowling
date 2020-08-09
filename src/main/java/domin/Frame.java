package domin;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    //判断strike
    public static boolean isStrike(Frame frame){
        if (frame.getThrowList().get(0) == 10)
            return true;
        return false;
    }

    //判断 spare
    public static boolean isSpare(Frame frame){
        if (frame.getThrowList().get(0) != 10 && frame.getThrowList().get(0) + frame.getThrowList().get(1) == 10)
            return true;
        return false;
    }

    public static int countOneFrameScore(List<Integer> throwList){
        int totalScore = 0;
        for (Integer throwScore : throwList) {
            totalScore += throwScore.intValue();
        }
        return totalScore;
    }
    private int throwTimes;
    private int scoreInOneFrame;
    private List<Integer> throwList = new ArrayList<>();

    public Frame(int throwTimes, List<Integer> throwList) {
        this.throwTimes = throwTimes;
        this.throwList = throwList;
    }

    public int getThrowTimes() {
        return throwTimes;
    }

    public void setThrowTimes(int throwTimes) {
        this.throwTimes = throwTimes;
    }

    public List<Integer> getThrowList() {
        return throwList;
    }

    public void setThrowList(List<Integer> throwList) {
        this.throwList = throwList;
    }

    public int getScoreInOneFrame() {
        return scoreInOneFrame;
    }

    public void setScoreInOneFrame(int scoreInOneFrame) {
        this.scoreInOneFrame = scoreInOneFrame;
    }
}
