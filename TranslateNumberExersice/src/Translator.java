import java.util.HashMap;

public class Translator {
    public HashMap<Integer, String> digitsMap = new HashMap<>();
    public HashMap<Integer, String> teensMap = new HashMap<>();
    public HashMap<Integer, String> tensMap = new HashMap<>();
    public HashMap<Integer, String> bigMap = new HashMap<>();

    public Translator() {
        hydrateDigitsMap();
        hydrateTeensMap();
        hydrateTensMap();
        hydrateBigMap();
    }

    private void hydrateDigitsMap() {
        digitsMap.put(0, "zero");
        digitsMap.put(1, "one");
        digitsMap.put(2, "two");
        digitsMap.put(3, "three");
        digitsMap.put(4, "four");
        digitsMap.put(5, "five");
        digitsMap.put(6, "six");
        digitsMap.put(7, "seven");
        digitsMap.put(8, "eight");
        digitsMap.put(9, "nine");
    }

    private void hydrateTeensMap() {
        teensMap.put(0, "ten");
        teensMap.put(1, "eleven");
        teensMap.put(2, "twelve");
        teensMap.put(3, "thirteen");
        teensMap.put(4, "fourteen");
        teensMap.put(5, "fifteen");
        teensMap.put(6, "sixteen");
        teensMap.put(7, "seventeen");
        teensMap.put(8, "eighteen");
        teensMap.put(9, "nineteen");
    }

    private void hydrateTensMap() {
        tensMap.put(2, "twenty");
        tensMap.put(3, "thirty");
        tensMap.put(4, "forty");
        tensMap.put(5, "fifty");
        tensMap.put(6, "sixty");
        tensMap.put(7, "seventy");
        tensMap.put(8, "eighty");
        tensMap.put(9, "ninety");
    }

    private void hydrateBigMap() {
        bigMap.put(1, "thousand");
        bigMap.put(2, "million");
        bigMap.put(3, "billion");
        bigMap.put(4, "trillion");
        bigMap.put(5, "quadrillion");
        bigMap.put(7, "quintillion");
        bigMap.put(8, "sextillion");
    }

    public String sayBig(int digit, String denomination) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.digitsMap.get(digit));
        sb.append(" ");
        sb.append(denomination);

        return sb.toString();
    }

    public String sayHundreds(int number) {
        String strNumber = String.valueOf(number);
        String[] strArr = strNumber.split("");
        StringBuilder sb = new StringBuilder();

        sb.append(this.sayBig(Integer.parseInt(strArr[0]), "hundred"));
        sb.append(" ");
        int tens = Integer.parseInt(strArr[1] + strArr[2]);
        if (tens >= 10) {
            sb.append(this.sayTens(Integer.parseInt(strArr[1] + strArr[2])));
        } else if (tens < 10 && tens > 0) {
            sb.append(this.digitsMap.get(tens));
        }

        return sb.toString();
    }

    public String sayTens(int number) {
        String strNum = String.valueOf(number);
        String[] strArr = strNum.split("");
        StringBuilder sb = new StringBuilder();
        if (strArr[0].equals("1")) {
            return this.teensMap.get(Integer.parseInt(strArr[1]));
        }
        sb.append(this.tensMap.get(Integer.parseInt(strArr[0])));
        sb.append(" ");
        sb.append(this.digitsMap.get(Integer.parseInt(strArr[1])));

        return sb.toString();
    }
}
