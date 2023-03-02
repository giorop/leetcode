package com.giorop.leetcode.simple;

import com.giorop.leetcode.ListNode;
import com.giorop.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description TODO
 * @ClassName Simple
 * @Author 夏雨人
 * @DateTime 2023/3/2 8:45
 * @Version 1.0
 */
public class Simple {
    /**
     * 有效括号
     * @param s
     * @return
     */
    public boolean _20isValid(String s) {
        Stack<Character>stack = new Stack<Character>();
        for(char c: s.toCharArray()){
            if(c=='(')stack.push(')');
            else if(c=='[')stack.push(']');
            else if(c=='{')stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())return false;
        }
        return stack.isEmpty();
    }
    /**
     * 合并有序列表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode _21mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        if(list1.val<=list2.val){
            list1.next=_21mergeTwoLists(list1.next,list2);
            return list1;
        }else{
            list2.next=_21mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
    /**
     * 移除排序数组中的重复元素
     * @param nums
     * @return 返回新数组的长度
     */
    public int _26removeDuplicates(int[] nums) {
        int pos=0;
        for(int i=1;i<nums.length;i++){
            if(nums[pos]!=nums[i]){
                nums[++pos]=nums[i];
            }
        }
        return pos+1;
    }
    /**
     * 移除所有重复元素
     * @param nums
     * @param val
     * @return 返回移除后的长度
     */
    public int _27removeElement(int[] nums, int val) {
        int pos=0;
        for(int num:nums){
            if(num!=val){
                nums[pos++]=num;
            }
        }
        return pos;
    }
    /**
     * 插入位置
     * @param nums
     * @param target
     * @return
     */
    public int _35searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left++;
            }else if(nums[mid]>target){
                right--;
            }else{
                return mid;
            }
        }
        return left;
    }
    /**
     * 58最后一个单词的长度
     * @param s
     * @return
     */
    public int _58lengthOfLastWord(String s) {
        int pos=s.length()-1;
        int ans=0;
        while(pos>=0&&s.charAt(pos)==' '){
            pos--;
        }
        while(pos>=0&&s.charAt(pos)!=' '){
            ans++;
            pos--;
        }
        return ans;
    }
    /**
     * 66数组加一
     * @param digits
     * @return
     */
    public int[] _66plusOne(int[] digits) {
        int pos=digits.length-1;
        while(pos>=0){
            if(digits[pos]!=9){
                digits[pos]+=1;
                return digits;
            }else{
                digits[pos--]=0;
            }
        }
        int[]ret=new int[digits.length+1];
        ret[0]=1;
        return ret;
    }
    /**
     * 67字符串01相加
     * @param a
     * @param b
     * @return
     */
    public String _67addBinary(String a, String b) {
        int carry=0;
        int index1=a.length()-1,index2=b.length()-1;
        StringBuilder sb=new StringBuilder();
        while(index1>=0||index2>=0){
            int c=index1>=0?a.charAt(index1--)-'0':0;
            int d=index2>=0?b.charAt(index2--)-'0':0;
            carry+=c+d;
            sb.append(carry%2);
            carry/=2;
        }
        if(carry!=0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    /**
     * 69平方根
     * @param x
     * @return
     */
    public int _69mySqrt(int x) {
        //二分
        if(x==0){
            return 0;
        }
        int left=1,right=x/2;
        int ans=1;
        while(left<=right){
            int mid=left+(right-left)/2;
            long t=(long)mid*mid;
            if(t<=x){
                left=mid+1;
                ans=mid;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
    /**
     * 70爬楼梯
     * @param n
     * @return
     */
    public int _70climbStairs(int n) {
        if(n<=1){
            return n;
        }
        int a=1,b=2;
        for(int i=3;i<=n;i++){
            int tmp=b;
            b+=a;
            a=tmp;
        }
        return b;
    }
    /**
     * 83删除有序链表重复元素
     * @param head
     * @return
     */
    public ListNode _83deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode cur=head;
        ListNode p=head.next;
        while(p!=null){
            if(p.val!=cur.val){
                cur.next=p;
                cur=p;
            }
            p=p.next;
        }
        cur.next=null;
        return dummy.next;
    }
    /**
     * 合并两个有序列表
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }
    /**
     * 94中序遍历
     * @param root
     * @return
     */
    public List<Integer> _94inorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;

        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                list.add(cur.val);
                cur=cur.right;
            }
        }
        return list;
    }
    /**
     * 相同的树
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null||p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    /**
     * 101 对称树
     * @param root
     * @return
     */
    public boolean _101isSymmetric(TreeNode root) {
        return isSymmetric(root,root);

    }
    private boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null||left.val!=right.val){
            return false;
        }
        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);
    }
    /**
     * 104最大深度
     * @param root
     * @return
     */
    public int _104maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(_104maxDepth(root.left),_104maxDepth(root.right))+1;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        //排序数组转化为平衡二叉树
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    private TreeNode sortedArrayToBST(int []nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=sortedArrayToBST(nums,left,mid-1);
        node.right=sortedArrayToBST(nums,mid+1,right);
        return node;
    }
}



















































































