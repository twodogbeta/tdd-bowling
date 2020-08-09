import domin.Frame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    //判断输入数据是否符合规则：数组长度最多21，最少10（全0）
    public static boolean isInputFollowRule(int[] gameInfo) {
        List<Frame> frameList = new ArrayList<>();
        int countPinInOneRound = 0;
        int i;
        if (gameInfo.length < 11 || gameInfo.length > 21)
            return false;
        for ( i = 0; i < gameInfo.length; i++) {
            if (gameInfo[i] >10 || gameInfo[i] < 0)
                return false;
        }
        //统计1-10论击球数
        for (i = 0; i < gameInfo.length; i=i+countPinInOneRound) {
            if (gameInfo[i] == 10 && frameList.size() < 10){
                List<Integer> throwList = new ArrayList<>();
                throwList.add(gameInfo[i]);
                frameList.add(new Frame(1,throwList));
                countPinInOneRound = 1;
            }
            else if (gameInfo[i] != 10 && frameList.size() < 10 ){
                List<Integer> throwList = new ArrayList<>();
                throwList.add(gameInfo[i]);
                throwList.add(gameInfo[i+1]);
                frameList.add(new Frame(2,throwList));
                countPinInOneRound = 2;
                //判断同一局内总分数是否超过10
                if (Frame.countOneFrameScore(throwList) > 10)
                    return false;
            }
            else if (frameList.size() == 10)
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
        else if (tenthFrameScore < 10  && afterTenthThrowTimes != 0)
            return false;
        return true;
    }
}
