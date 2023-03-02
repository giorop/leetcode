package com.giorop.leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @ClassName TwoSum
 * @Author 夏雨人
 * @DateTime 2023/3/2 8:30
 * @Version 1.0
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
