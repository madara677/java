import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    /**
     * 失物排序方法
     * @param lostArray 待排序的失物数组
     */
    public static void sortLost(Lost[] lostArray){
        //按失物时间从大到小排序
        Arrays.asList(lostArray).sort((a1, a2) -> {
            if(a1.getTime().getTimeInMillis() <= a2.getTime().getTimeInMillis()) return 1;
            return -1;
        });
    }

    /**
     *
     * @param lostArray 失物数组
     * @param keyword 用户输入的关键字
     * @return 返回查找到的失物
     */
    public static Lost[] selectByKeyword(Lost[] lostArray, String keyword){
        List<Lost> res = new ArrayList<>();
        for(Lost lost : lostArray){
            if(lost.getName().equals(keyword))
                res.add(lost);
        }

        return res.toArray(new Lost[res.size()]);
    }

    public static Lost[] getData(){
        List<Lost> lost = new ArrayList<>();

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2020, 7, 17, 10, 25);
        lost.add(new Lost(calendar1, "笔"));

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2021, 3, 6, 9, 50);
        lost.add(new Lost(calendar2, "水杯"));

        return lost.toArray(new Lost[lost.size()]);
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Lost[] lostArray = getData();

        sortLost(lostArray);
        System.out.println("所有物品如下：");
        Arrays.asList(lostArray).forEach(System.out::println);

        System.out.println("请输入你要查找的物品名称：");
        Scanner scanner = new Scanner(System.in);

        lostArray = selectByKeyword(lostArray, scanner.nextLine());

        Arrays.asList(lostArray).forEach(System.out::println);
    }
}
