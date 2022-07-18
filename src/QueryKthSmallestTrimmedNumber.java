import java.util.Arrays;


public class QueryKthSmallestTrimmedNumber {

    public String[] trimArray(String[] nums, int rightmost){
        int len = nums.length;
        String[] arr = new String[len];
        for (int i = 0; i < len; i++){
            int l = nums[i].length();
            arr[i] = nums[i].substring(l - rightmost);
        }
        return  arr;
    }

    public int getIndexOfSmallest(String[] nums, int k){
        String[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        String num = nums[k - 1];
        for (int i = 0; i < temp.length; i++){
            if (temp[i] == num)
                return i;
        }
        return -1;
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] indexes = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            String[] arr = trimArray(nums, queries[i][1]);
            int index = getIndexOfSmallest(arr, queries[i][0]);
            indexes[i] = index;
        }
        return indexes;
    }

    public static void main(String[] args){
        QueryKthSmallestTrimmedNumber query = new QueryKthSmallestTrimmedNumber();
        String[] nums = {"24","37","96","04"};
        int[][] queries = {new int[]{2,1},new int[]{2,2}};
        int[] arr = query.smallestTrimmedNumbers(nums, queries);
        System.out.println(Arrays.toString(arr));
    }
}
