package edu.uoc.pac1;

public class PAC1Ex3 {

    public static final int GAMES_PLAYED = 38;


    public static int[][] getCompleteClassification(int[][] array) {

        int[][] newArray = new int[20][6];
        int score = 0;
        int games;

        for (int i = 0; i < 20; i++) {

            newArray[i][0] = array[i][0];
            newArray[i][2] = array[i][1];
            newArray[i][3] = array[i][2];
            newArray[i][4] = array[i][3];

            games = array[i][0] + array[i][1];
            newArray[i][1] = GAMES_PLAYED - games;

            score = newArray[i][0] * 3 + newArray[i][1];
            newArray[i][5] = score;

        }
        return newArray;
    }

    public static void print(int[][] array) {


        getCompleteClassification(array);

        if (array[6].length < 6) {
            System.out.println("[ERROR] Classification table does not have the correct columns");


        } else {
            System.out.println("#   |  W  |  D  |  L  |  GF |  GA |  PTS|");

            for (int i = 0; i < 20; i++) {

                if (i + 1 < 10) {
                    System.out.print((i + 1) + ".  |");

                } else {
                    System.out.print((i + 1) + ". |");
                }

                for (int z = 0; z < 6; z++) {

                    if (array[i][z] < 10) {
                        System.out.print("  " + array[i][z] + "  |");

                    } else {
                        System.out.print("  " + array[i][z] + " |");
                    }
                }
                System.out.print(System.lineSeparator());
            }

        }


    }

    public static int getNumTeamsByGoalDifference(int[][] array, boolean positive) {

        getCompleteClassification(array);
        int sum = 0;
        int rest = 0;

        if (array[6].length < 6) {

            System.out.println("[ERROR] Classification table does not have the correct columns");
            return -1;

        } else {
            for (int i = 0; i < 20; i++) {

                int difScore = array[i][3] - array[i][4];

                if (difScore > 0) {

                    sum++;

                } else {

                    rest++;
                }
            }
            if (positive) {

                return sum;

            } else {

                return rest;
            }
        }
    }

    public static void sort(int[][] array) {

        if (array[6].length < 6) {
            System.out.println("[ERROR] Classification table does not have the correct columns");

        } else {
            bubbleMethod(array);
        }
    }
    public static int[][] bubbleMethod(int[][]array){

        int[] temp;

        for (int i = 0; i < 19; i++) {

            for (int z = 0; z < 19; z++) {

                if (array[z][5] < array[z + 1][5]) {

                    temp = array[z];
                    array[z] = array[z + 1];
                    array[z + 1] = temp;

                } else if (array[z][5] == array[z + 1][5]) {

                    if (array[z][3] < array[z + 1][3]) {

                        temp = array[z];
                        array[z] = array[z + 1];
                        array[z + 1] = temp;

                    }
                }
            }
        }
        return array;
    }

}


