import java.util.ArrayList;
import java.util.List;

public class TranslateNumberExercise {

    private static int[] getSegments(String[] strArr) {
        boolean firstHundreds = strArr.length % 3 == 0;
        boolean firstTens = strArr.length % 3 == 2;
        boolean firstDigit = strArr.length % 3 == 1;

        int numSegments = 0;

        if (firstHundreds) {
            numSegments = strArr.length / 3;
        } else {
            numSegments = (int) Math.floor(strArr.length / 3) + 1;
        }

        int[] segments = new int[numSegments];
        StringBuilder segmentSb = new StringBuilder();
        int currStrIndex = 0;
        for (int i = 0; i < numSegments; i++) {
            if (i == 0 && firstTens) {
                for (int j = 0; j < 2; j++) {
                    segmentSb.append(strArr[j]);
                    currStrIndex += 1;
                }
            } else if (i == 0 && firstDigit) {
                segmentSb.append(strArr[0]);
                currStrIndex += 1;
            } else {
                for (int j = currStrIndex; j < currStrIndex + 3; j++) {
                    segmentSb.append(strArr[j]);
                }
                currStrIndex += 3;
            }
            segments[i] = Integer.parseInt(segmentSb.toString());
            segmentSb = new StringBuilder();
        }

        return segments;
    }

    public static String translateNumberToWord(int number) {
        Translator translator = new Translator();
        StringBuilder outSb = new StringBuilder();
        String strNum = String.valueOf(number);
        String[] strArr = strNum.split("");

        int[] segments = getSegments(strArr);

        for (int i = 0; i < segments.length; i++) {
            if (segments[i] < 10) {
                outSb.append(translator.digitsMap.get(segments[i]));
                outSb.append(" ");
            } else if (segments[i] < 100) {
                outSb.append(translator.sayTens(segments[i]));
                outSb.append(" ");
            } else {
                outSb.append(translator.sayHundreds(segments[i]));
                outSb.append(" ");
            }

            if (i < segments.length - 1) {
                outSb.append(translator.bigMap.get(segments.length - i - 1));
                outSb.append(" ");
            }
        }

        return outSb.toString();
    }

    public static void main(String[] args) {
        System.out.println(translateNumberToWord(100000));
    }
}
