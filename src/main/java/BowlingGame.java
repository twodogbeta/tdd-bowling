import domin.Frame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    static List<Frame> frameListGlobal = new ArrayList<>();

    //判断输入数据是否符合规则：数组长度最多21，最少10（全0）
    public static boolean isInputFollowRule(int[] gameInfo) {
        boolean isRule;
        List<Frame> frameList = new ArrayList<>();
        int countPinInOneRound = 0;
        int i;
        if (gameInfo.length < 11 || gameInfo.length > 21)
            return false;
        for (i = 0; i < gameInfo.length; i++) {
            if (gameInfo[i] > 10 || gameInfo[i] < 0)
                return false;
        }
        //统计1-10论击球数
        for (i = 0; i < gameInfo.length; i = i + countPinInOneRound) {
            if (gameInfo[i] == 10 && frameList.size() < 10) {
                List<Integer> throwList = new ArrayList<>();
                throwList.add(gameInfo[i]);
                frameList.add(new Frame(1, throwList));
                countPinInOneRound = 1;
            } else if (gameInfo[i] != 10 && frameList.size() < 10) {
                List<Integer> throwList = new ArrayList<>();
                throwList.add(gameInfo[i]);
                throwList.add(gameInfo[i + 1]);
                frameList.add(new Frame(2, throwList));
                countPinInOneRound = 2;
                //判断同一局内总分数是否超过10
                if (Frame.countOneFrameScore(throwList) > 10)
                    return false;
            } else if (frameList.size() == 10)
                break;
        }

        //根据第十轮分数判断后面的数据是否合格
        int tenthFrameScore = Frame.countOneFrameScore(frameList.get(9).getThrowList());
        //第十局之后的投球次数
        int afterTenthThrowTimes = gameInfo.length - i;
        if (tenthFrameScore == 10 && frameList.get(9).getThrowTimes() == 1 && afterTenthThrowTimes != 2)
            return false;
        else if (tenthFrameScore == 10 && frameList.get(9).getThrowTimes() == 2 && afterTenthThrowTimes != 1)
            return false;
        else if (tenthFrameScore < 10 && afterTenthThrowTimes != 0)
            return false;
        frameListGlobal = frameList;
        return true;
    }

    //计分
    public static int countScore(int[] gameInfo) {
        int totalScore = 0;
        //把数组转化成frame链表
        if (isInputFollowRule(gameInfo)) {
            //前八轮
            for (int i = 0; i < 8; i++) {
                Frame currentFrame = frameListGlobal.get(i);
                Frame nextFrame = frameListGlobal.get(i + 1);
                Frame nextNextFrame = frameListGlobal.get(i + 2);
                if (Frame.isStrike(currentFrame)) {
                    if (Frame.isStrike(nextFrame))
                        totalScore += 20 + nextNextFrame.getThrowList().get(0);
                    else totalScore += 10 + Frame.countOneFrameScore(nextFrame.getThrowList());
                } else if (Frame.isSpare(currentFrame))
                    totalScore += 10 + nextFrame.getThrowList().get(0);
                else totalScore += Frame.countOneFrameScore(currentFrame.getThrowList());


            }
            //第九轮(1.strike ,2.apare 3.not any)
            Frame ninthFrame = frameListGlobal.get(8);
            Frame tenthFrame = frameListGlobal.get(9);
            if (Frame.isStrike(ninthFrame)) {
                if (Frame.isStrike(tenthFrame))
                    totalScore += 10 + 10 + gameInfo[gameInfo.length - 2];
                else totalScore += 10 + Frame.countOneFrameScore(tenthFrame.getThrowList());
            }
            //spare
            else if (Frame.isSpare(ninthFrame))
                totalScore += 10 + tenthFrame.getThrowList().get(0);

                //notany
            else Frame.countOneFrameScore(ninthFrame.getThrowList());


            //第10轮（如果第十轮全中或者补中，都计算后三次的pin当做第十轮总分）
            if (Frame.isStrike(tenthFrame) || Frame.isSpare(tenthFrame))
                totalScore += gameInfo[gameInfo.length - 3] + gameInfo[gameInfo.length - 1] + gameInfo[gameInfo.length - 2];
            else totalScore += Frame.countOneFrameScore(frameListGlobal.get(9).getThrowList());
            return totalScore;

        }
        return totalScore;
    }

}
