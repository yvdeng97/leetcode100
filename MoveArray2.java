package day02;

import java.util.Arrays;

public class MoveArray2 {
    public static void main(String[] args) {
        //给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int k = 7;
        rotate1(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    private static void rotate1(int[] nums, int k) {
        // 处理 k 大于数组长度的情况
        k = k % nums.length;

        // 三次反转法
        reverse(nums, 0, nums.length - 1);  // 全部反转
        reverse(nums, 0, k - 1);            // 反转前 k 个元素
        reverse(nums, k, nums.length - 1);  // 反转剩余元素
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
