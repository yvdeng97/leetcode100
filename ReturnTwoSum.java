package day01;

import java.util.*;

public class ReturnTwoSum {
    public static void main(String[] args) {
        //给定一个整数数组 nums 和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
        //你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
        //你可以按任意顺序返回答案。
        //------------------------------------------------------------------------------------------------------------------


        try(Scanner data = new Scanner(System.in);) {
            //定义一个动态大小的数组用来接收输入的数据
            List<Integer> list = new ArrayList<>();
            System.out.println("请输入数组元素(直接回车退出)：");
            while (true) {
                String line = data.nextLine().trim();
                if (line.isEmpty()) {
                    System.out.println("输入结束");
                    break;
                }

                try {
                    list.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.out.println("无效输入: '" + line + "'，请输入整数或直接回车结束。");
                }
            }

            if (list.isEmpty()) {
                System.out.println("未输入任何有效数据，程序退出。");
                return;
            }

            System.out.println("请输入目标值：");

            if (!data.hasNextInt()) {
                System.out.println("目标值输入无效。");
                return;
            }
            int target = data.nextInt();

            //调用twoSum方法，并打印返回的数组
            System.out.println(Arrays.toString(new ReturnTwoSum().twoSum(list.stream().mapToInt(i -> i).toArray(), target)));

        } catch (Exception e) {
            System.err.println("发生未知错误: " + e.getMessage());
            e.printStackTrace();
        }


    }

    //创建一个方法，接收一个数组和一个目标值，返回结果
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }

}



