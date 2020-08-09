public class BowlingGame {

    //判断输入数据是否符合规则：数组长度最多21，最少10（全0）
    public static boolean isInputFollowRule(int[] gameInfo) {
        if (gameInfo.length < 11 || gameInfo.length > 21)
            return false;
        for (int i = 0; i < gameInfo.length; i++) {
            if (gameInfo[i] >10 || gameInfo[i] < 0)
                return false;
        }
        return true;
    }
}
