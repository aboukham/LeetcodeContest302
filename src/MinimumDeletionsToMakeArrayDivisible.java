import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MinimumDeletionsToMakeArrayDivisible {
    public boolean isDivideAllElements(int[] numsDivide, int num){
        for (int i = 0; i < numsDivide.length; i++){
            if (numsDivide[i] % num != 0)
                return false;
        }
        return true;
    }

    public Map<Integer, Integer> toMap(int[] nums){
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++){
            if (!map.containsKey(nums[i])) map.put(nums[i], 1);
            else map.put(nums[i], map.get(nums[i]) + 1);
        }
        return map;
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        Map<Integer, Integer> map = toMap(nums);
        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (isDivideAllElements(numsDivide, entry.getKey())) return count;
            else count += entry.getValue();
        }
        return -1;
    }

    public static void main(String[] args){
        MinimumDeletionsToMakeArrayDivisible m = new MinimumDeletionsToMakeArrayDivisible();
        int[] nums = {3,2,6,2,35,5,35,2,5,8,7,3,4};
        int[] divide = {105,70,70,175,105,105,105};
        int count = m.minOperations(nums, divide);
        System.out.println(count);
    }
}
