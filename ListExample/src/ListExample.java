import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static List<String>[] groupString(List<String> input) {
        ArrayList<String>[] outArray = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            outArray[i] = new ArrayList<String>();
        }
        for (String val : input) {
            Character firstChar = val.charAt(0);
            if (firstChar.toString().equals("a")) {
                outArray[0].add(val);
            } else if (firstChar.toString().equals("b")) {
                outArray[1].add(val);
            } else {
                outArray[2].add(val);
            }
        }
        return outArray;
    }

    public static void main(String[] args) {
        ArrayList<String> arrList = new ArrayList<String>();
        arrList.add("abc");
        arrList.add("kjhs");
        arrList.add("cde");
        arrList.add("aaa");
        arrList.add("bde");
        arrList.add("sdf");
        arrList.add("aaa");
        arrList.add("beyg");
        arrList.add("aay");

        List<String>[] groupedStrings = groupString(arrList);
        System.out.println(groupedStrings[0]);
        System.out.println(groupedStrings[1]);
        System.out.println(groupedStrings[2]);
    }
}
