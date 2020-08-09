package domin;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    class FrameAndIsFollowRule{
        public FrameAndIsFollowRule(List<Frame> frames, boolean isRule){
            this.frames = frames;
            this.isRule = isRule;
        }
        private List<Frame> frames;
        private boolean isRule;

        public List<Frame> getFrames() {
            return frames;
        }

        public void setFrames(List<Frame> frames) {
            this.frames = frames;
        }
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
