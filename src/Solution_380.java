import java.util.*;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-04-21
 * @Description: O(1)实现插入、删除、查找
 */
public class Solution_380 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(1);
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());
        int random = randomizedSet.getRandom();
    }
}

class RandomizedSet {

    ArrayList<Integer> org = new ArrayList<>();
    Map<Integer,Integer> valueMap = new HashMap<>();


    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (valueMap.containsKey(val)){
            return false;
        }else {
            org.add(val);
            valueMap.put(val,org.size()-1);
            return true;
        }
    }

    public boolean remove(int val) {
        if (!valueMap.containsKey(val)){
            return false;
        }else {
            // todo arrylist没有删除
            valueMap.remove(val);
            org.remove(org.indexOf(val));
            return true;
        }
    }

    public int getRandom() {
        Random random = new Random();
        int idx = random.nextInt(0, org.size());
        while (!valueMap.containsKey(org.get(idx))){
            idx = random.nextInt(0, org.size());
        }
        return org.get(idx);
    }
}
