import java.util.*;
import java.util.stream.Collectors;

public class GrammarExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //需要从命令行读入
        String firstWordList = sc.nextLine();
        String secondWordList = sc.nextLine();

        List<String> result = findCommonWordsWithSpace(firstWordList, secondWordList);
        //按要求输出到命令行
        System.out.println(result.toString());
    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        boolean isFirstWordsMatch = firstWordList.matches("([a-zA-Z]+\\,)*[a-zA-Z]*");
        boolean isSecondWordMatch = firstWordList.matches("([a-zA-Z]+\\,)*[a-zA-Z]*");
        if(!isFirstWordsMatch||!isSecondWordMatch){
            throw new RuntimeException("Invalid string list");
        }
        String[] firstWordArray = firstWordList.toUpperCase().split(",");
        String[] secondWordArray = secondWordList.toUpperCase().split(",");
        List<String> tempList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        Set<String> stringSet = Arrays.stream(firstWordArray).collect(Collectors.toSet());
        Arrays.stream(secondWordArray).forEach((s) -> {
                    if (stringSet.contains(s)) {
                        tempList.add(s);
                    }
                }
        );
        Collections.sort(tempList);
        tempList.stream().forEach((e) -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < e.length(); i++) {
                        if (i < e.length() - 1) {
                            sb = sb.append(e.charAt(i)).append(" ");
                        } else {
                            sb = sb.append(e.charAt(i));
                        }
                    }
                    result.add(sb.toString());
                }
        );
        return result;
    }
}
