package com.giorop.leetcode.simple;

import com.giorop.leetcode.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @Description TODO
 * @ClassName SimpleDay3
 * @Author 夏雨人
 * @DateTime 2023/3/6 17:45
 * @Version 1.0
 */
public class SimpleDay3 {
    class _653Solution {
        public boolean findTarget(TreeNode root, int k) {
            Stack<TreeNode>stack1=new Stack<>();
            Stack<TreeNode>stack2=new Stack<>();
            TreeNode cur=root;
            while (cur!=null){
                stack1.push(cur);
                cur=cur.left;
            }
            cur=root;
            while(cur!=null){
                stack2.push(cur);
                cur=cur.right;
            }
            TreeNode left=nextSmallEst(stack1);
            TreeNode right=nextBigEst(stack2);
            while(left!=right){
                int sum=left.val+right.val;
                if(sum==k){
                    return true;
                }else if(sum<k){
                    left=nextSmallEst(stack1);
                }else{
                    right=nextBigEst(stack2);
                }
            }
            return false;
        }
        private TreeNode nextSmallEst(Stack<TreeNode>stack){
            if(stack.isEmpty()){
                return null;
            }
            TreeNode ret=stack.pop();
            TreeNode cur=ret.right;
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            return ret;
        }
        private TreeNode nextBigEst(Stack<TreeNode>stack){
            if(stack.isEmpty()){
                return null;
            }
            TreeNode ret=stack.pop();
            TreeNode cur=ret.left;
            while(cur!=null){
                stack.push(cur);
                cur=cur.right;
            }
            return ret;
        }
    }
    public boolean _657judgeCircle(String moves) {
        int a=0,b=0;
        for(char c:moves.toCharArray()){
            if(c=='U'){
                a++;
            }else if(c=='D'){
                a--;
            }else if(c=='L'){
                b++;
            }else if(c=='R'){
                b--;
            }
        }
        return a==0&&b==0;
    }
    public int _671findSecondMinimumValue(TreeNode root) {
        int smallEst=root.val;
        Integer ans=null;
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                if(cur.val!=smallEst){
                    if(ans==null||cur.val<ans){
                        ans=cur.val;
                    }
                }
                cur=cur.right;
            }
        }
        return ans==null?-1:ans;

    }
    public int _674findLengthOfLCIS(int[] nums) {
        int max=1,cur=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                cur++;
            }else{
                max=Math.max(max,cur);
                cur=1;
            }
        }
        max=Math.max(max,cur);
        return max;
    }
    public int _543diameterOfBinaryTree(TreeNode root) {
        int[]ans=new int[0];
        _543diameterOfBinaryTree(ans,root);
        return ans[0]-1;
    }
    private int _543diameterOfBinaryTree(int[]ans,TreeNode root){
       if(root==null){
           return 0;
       }
       int left=_543diameterOfBinaryTree(ans,root.left);
       int right=_543diameterOfBinaryTree(ans,root.right);
       if(left+right+1>ans[0]){
           ans[0]=left+right+1;
       }
       return Math.max(left,right)+1;
    }
    public String _541reverseStr(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i+=2*k) {
            for(int j=Math.min(s.length(),i+k)-1;j>=i;j--){
                sb.append(s.charAt(j));
            }
            int end=Math.min(s.length(),i+2*k);
            for(int j=i+k;j<end;j++){
                sb.append(s.charAt(j));
            }
        }
        return sb.toString();
    }
    public int _540getMinimumDifference(TreeNode root) {
        if(root==null){
            return 0;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        TreeNode pre=null;
        int min=Integer.MAX_VALUE;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                if(pre!=null){
                    min=Math.min(min,cur.val-pre.val);
                }
                pre=cur;
                cur=cur.right;
            }
        }
        return min;
    }
    public boolean _520detectCapitalUse(String word) {
        if(word.length()<=1){
            return true;
        }
        if(Character.isLowerCase(word.charAt((0)))&&Character.isUpperCase(word.charAt(1))){
            return false;
        }
        for(int i=2;i<word.length();i++){
            boolean a=Character.isLowerCase(word.charAt(i));
            boolean b=Character.isLowerCase((word.charAt(i-1)));
            if(a!=b){
                return false;
            }
        }
        return true;
    }
    public int _509fib(int n) {
        if(n==0){
            return 0;
        }
        int a=0,b=1;
        for(int i=2;i<=n;i++){
            int tmp=b;
            b+=a;
            a=tmp;
        }
        return b;
    }
    public boolean _507checkPerfectNumber(int num) {
        if(num < 4) return false;
        int cur = 0;
        for (int i = 1; i < Math.sqrt(num); i++) {
            if(num % i == 0) {
                cur += i;
                cur += num / i;
            }
        }
        if(Math.sqrt(num) * Math.sqrt(num) == num)
            cur += Math.sqrt(num);
        return num == cur - num;
    }
    public String[] _506findRelativeRanks(int[] score) {
        PriorityQueue<int[]>que=new PriorityQueue((a,b)->((int[])b)[0]-((int[])a)[0]);
        for(int i=0;i<score.length;i++){
            que.offer(new int[]{score[i],i});
        }

        String[]ans=new String[score.length];
        for(int i=0;i<ans.length;i++){
            int[] p=que.poll();
            if(i==0){
                ans[p[1]]="Gold Medal";
            }else if(i==1){
                ans[p[1]]="Silver Medal";
            }else if(i==2){
                ans[p[1]]="Bronze Medal";
            }else{
                ans[p[1]]=i+1+"";
            }
        }
        return ans;
    }
}
