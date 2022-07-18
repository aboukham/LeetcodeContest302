import java.util.*;

public class MaximumSum {
    public int findMax(List<Integer> l){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < l.size(); i++){
            if (max < l.get(i)){
                max = l.get(i);
            }
        }
        if (max == Integer.MIN_VALUE)
            return -1;
        return max;
    }

    public int sumOfDigits(int num){
        int sum = 0;
        while (num != 0){
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public List<Integer> getSumOfTwoMaxs(Collection<List<Integer>> col){
        List<Integer>  sumsList = new ArrayList<>();
        Iterator<List<Integer>> iter = col.iterator();
        while (iter.hasNext()){
            List<Integer> l = iter.next();
            int size = l.size();
            if (size >= 2){
                Collections.sort(l);
                int value = l.get(size - 1) + l.get(size - 2);
                sumsList.add(value);
            }
        }
        return sumsList;
    }

    public int maximumSum(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int sum1 = sumOfDigits(nums[i]);
            if (!map.containsKey(sum1)){
                List<Integer>   list = new ArrayList<>();
                list.add(nums[i]);
                map.put(sum1, list);
            }else map.get(sum1).add(nums[i]);
        }
        List<Integer> sumsList = getSumOfTwoMaxs(map.values());
        if (sumsList.size() == 0) return -1;
        int max = findMax(sumsList);
        return max;
    }

    public static void main(String[] args){
        MaximumSum ms = new MaximumSum();
        int[] nums = {18,43,36,13,7};
        System.out.println(ms.maximumSum(nums));
    }
}
