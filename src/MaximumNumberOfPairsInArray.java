import java.util.*;

public class MaximumNumberOfPairsInArray {
    public static int[] countPairs(Collection<Integer> values){
        int countPairs = 0;
        int countNonPairs = 0;
        Iterator<Integer> iter = values.iterator();
        while (iter.hasNext()){
            int value = iter.next();
            countPairs += value / 2;
            countNonPairs += value % 2;
        }
        return new int[]{countPairs, countNonPairs};
    }
    public static int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
        }
        return countPairs(map.values());
    }

    public static void main(String[] args){
        int [] nums = {1,3,2,1,3,2,2};
        int [] pairs = numberOfPairs(nums);
        System.out.println(Arrays.toString(pairs));
    }
}

