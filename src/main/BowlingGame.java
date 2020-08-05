public class BowlingGame {
    public static void main(String[] args) {
        System.out.println(6+5);
    }
    public static int sumArray(int[] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum+= array[i];
        }
        return sum;
    }
    public int getScore(int gameInfo[]){
        int[] score = new int[10];

            for (int i = 0; i < gameInfo.length - 2; i=i+2) {
                if (gameInfo[i] == 10 && (gameInfo[i+2] ==10 || gameInfo[i+3 ] ==10)){
                    score[i/2] = 20 + gameInfo[i + 4];
                }
                else if (gameInfo[i] == 10 && (gameInfo[i+2] !=10 || gameInfo[i+3 ] !=10 )){

                    score[i/2] = 10 + gameInfo[i+2] +  gameInfo[i+3];
                }
                else if (gameInfo[i] + gameInfo[i + 1] == 10){
                    score[i/2] = 10 + gameInfo[i + 2];
                }
                else  score[i/2] = gameInfo[i] + gameInfo[i+1];
            }
            score[9] = gameInfo[gameInfo.length - 1 ]
                     + gameInfo[gameInfo.length - 2 ]
                     +gameInfo[gameInfo.length - 3 ]
                     +gameInfo[gameInfo.length - 4 ];

        return sumArray(score);
    }
}
