package com.giorop.leetcode.simple;

import com.giorop.leetcode.ListNode;
import com.giorop.leetcode.TreeNode;

import java.util.*;

/**
 * @Description TODO
 * @ClassName Simple
 * @Author 夏雨人
 * @DateTime 2023/3/2 8:45
 * @Version 1.0
 */
public class Simple {
    /**
     * 仅翻转元音字符
     * @param s
     * @return
     */
    public String _345reverseVowels(String s) {
        String str="aeiouAEIOU";
        Set<Character>set=new HashSet<>();
        for(char c:str.toCharArray()){
            set.add(c);
        }
        char[]chars=s.toCharArray();
        int left=0,right=s.length()-1;
        while(left<right){
            while(left<right&&!set.contains(chars[left])){
                left++;
            }
            while(left<right&&!set.contains(chars[right])){
                right--;
            }
            if(left<right){
                char tmp=chars[left];
                chars[left]=chars[right];
                chars[right]=tmp;
            }
            left++;right--;
        }
        return new String(chars);
    }
    /**
     * 翻转数列
     * @param s
     */
    public void _344reverseString(char[] s) {
        int left=0,right=s.length-1;
        while(left<right){
            char tmp=s[left];
            s[left++]=s[right];
            s[right--]=tmp;
        }
    }
    /**
     * 4的幂次方
     * @param n
     * @return
     */
    public boolean _342isPowerOfFour(int n) {
        //最大能整除(只有一个比特位有效) 且 n&(0x55555555)!=0
        if(n<=0||(n&(n-1))!=0){
            return false;
        }
        return (n&0x55555555)!=0;
    }
    /**
     * 比特位计数
     * @param n
     * @return
     */
    public int[] _338countBits(int n) {
        int[]ans=new int[n+1];
        if(n==0){
            return ans;
        }
        ans[1]=1;
        for(int i=2;i<=n;i++){
            ans[i]=ans[i/2];
            if(i%2==1){
                ans[i]+=1;
            }
        }
        return ans;
    }
    /**
     * 3的幂
     * @param n
     * @return
     */
    public boolean _326isPowerOfThree(int n) {
        //反证 如果n中包含其它因子 则一定不能整除
        return n > 0 && 1162261467%n == 0;
    }
    /**
     *区域和 这里需要保证越界问题
     */
    class _303NumArray {
        int[]sums;
        public _303NumArray(int[] nums) {
            this.sums=new int[nums.length+1];
            for(int i=0;i<nums.length;i++){
                sums[i+1]=sums[i]+nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return sums[right+1]-sums[left];
        }
    }
    public boolean _292canWinNim(int n) {
        return n%4!=0;
    }
    /**
     * 一一映射
     * @param pattern
     * @param s
     * @return
     */
    public boolean _290wordPattern(String pattern, String s) {
        String[]strs=s.split(" ");
        if(strs.length!=pattern.length()){
            return false;
        }
        Map<Character,String>map=new HashMap<>();
        Set<String>set=new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            char c=pattern.charAt(i);
            //System.out.println(c+strs[i]);
            if(map.containsKey(c)){
                if(!map.get(c).equals(strs[i])){
                    return false;
                }
            }else if(set.contains(strs[i])){
                return false;
            }else{
                map.put(c,strs[i]);
                set.add(strs[i]);
            }
        }
        return true;
    }
    /**
     * 将数组中0移动到末尾
     * @param nums
     */
    public void _283moveZeroes(int[] nums) {
        int pos=0;
        for(int num:nums){
            if(num!=0){
                nums[pos++]=num;
            }
        }
        for(int i=pos;i<nums.length;i++){
            nums[pos++]=0;
        }
    }
    /**
     * 遍历所有根节点到叶子节点路径
     * @param root
     * @return
     */
    public List<String> _257binaryTreePaths(TreeNode root) {
        List<String>res=new ArrayList<>();
        if(root==null){
            return res;
        }
        binaryTreePaths(res,new StringBuilder(),root);
        return res;
    }
    private void binaryTreePaths(List<String>res,StringBuilder sb,TreeNode root){
        if(root==null){
            return;
        }
        int len=sb.length();
        sb.append("->").append(root.val);
        if(root.left==null&&root.right==null){
            res.add(sb.substring(2).toString());
        }else{
            binaryTreePaths(res,sb,root.left);
            binaryTreePaths(res,sb,root.right);
        }
        for(int i=sb.length()-1;i>=len;i--){
            sb.deleteCharAt(i);
        }
    }
    /**
     * 字母异位词 仅包含小写字符
     * @param s
     * @param t
     * @return
     */
    public boolean _242isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[]counts=new int[26];
        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)-'a']++;
            counts[t.charAt(i)-'a']--;
        }
        for(int i=0;i<counts.length;i++){
            if(counts[i]!=0){
                return false;
            }
        }
        return true;
    }
    /**
     * 回文链表
     * @param head
     * @return
     */
    public boolean _234isPalindrome(ListNode head) {
        List<Integer>list=new ArrayList<>();
        ListNode p=head;
        while(p!=null){
            list.add(p.val);
            p=p.next;
        }
        int left=0,right=list.size()-1;
        while(left<right){
            if(list.get(left++)!=list.get(right--)){
                return false;
            }
        }
        return true;
    }
    /**
     * 2的幂次方
     * @param n
     * @return
     */
    public boolean _231isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        return Integer.bitCount(n)==1;
    }
    /**
     * 区间汇总
     * @param nums
     * @return
     */
    public List<String> _228summaryRanges(int[] nums) {
        List<String>list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            while(j<nums.length&&nums[j]==nums[j-1]+1){
                j++;
            }
            if(i==j-1){
                list.add(""+nums[i]);
            }else{
                list.add(""+nums[i]+"->"+nums[j-1]);
            }
            i=j-1;
        }
        return list;
    }
    /**
     * 是否存在相同元素且距离<k
     * @param nums
     * @param k
     * @return
     */
    public boolean _219containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])&&i-map.get(nums[i])<=k){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
    /**
     * 是否存在重复元素
     * @param nums
     * @return
     */
    public boolean _217containsDuplicate(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int num:nums){
            if(!set.add(num)){
                return  true;
            }
        }
        return false;
    }
    /**
     * 翻转链表
     * @param head
     * @return
     */
    public ListNode _206reverseList(ListNode head) {
        ListNode newHead=null;
        ListNode p=head;
        while(p!=null){
            ListNode next=p.next;
            p.next=newHead;
            newHead=p;
            p=next;
        }
        return newHead;
    }
    /**
     * 反复相加得到一位数
     * @param num
     * @return
     */
    public int _258addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
    /**
     * 只包含235质因数的数字
     * @param n
     * @return
     */
    public boolean _263isUgly(int n) {
        if(n<=0){
            return false;
        }
        while(n%2==0){
            n/=2;
        }
        while(n%3==0){
            n/=3;
        }
        while(n%5==0){
            n/=5;
        }
        return n==1;
    }
    /**
     * 刚好缺少一个数字
     * @param nums
     * @return
     */
    public int _268missingNumber(int[] nums) {
        int xor=nums.length;
        for(int i=0;i<nums.length;i++){
            xor^=i;
            xor^=nums[i];
        }
        return xor;
    }
    /**
     * 同构字符串映射
     * @param s
     * @param t
     * @return
     */
    public boolean _205isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Character>map=new HashMap<>();
        Set<Character>set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            char d=t.charAt(i);
            if(map.containsKey(c)){
                if(map.get(c)!=d){
                    return false;
                }
            }else if(set.contains(d)){
                return false;
            }else{
                map.put(c,d);
                set.add(d);
            }
        }
        return true;
    }
    /**
     * 移除链表中特定val的节点
     * @param head
     * @param val
     * @return
     */
    public ListNode _203removeElements(ListNode head, int val) {
        ListNode dummy=new ListNode();
        ListNode cur=dummy,p=head;
        while(p!=null){
            if(p.val!=val){
                cur.next=p;
                cur=p;
            }
            p=p.next;
        }
        cur.next=null;
        return dummy.next;
    }
    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    public TreeNode _226invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode left=_226invertTree(root.left);
        TreeNode right=_226invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
    /**
     * 平衡二叉树
     * @param root
     * @return
     */
    public boolean _110isBalanced(TreeNode root) {
        return hight(root)!=-1;
    }
    private int hight(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=hight(root.left);
        int right=hight(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }
        return 1+Math.max(left,right);
    }
    /**
     * 最小深度 叶子节点记为1
     * @param root
     * @return
     */
    public int _111minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
        int left=_111minDepth(root.left);
        int right=_111minDepth(root.right);
        if(left==0){
            return right+1;
        }else if(right==0){
            return left+1;
        }else{
            return 1+Math.min(left,right);
        }
    }
    /**
     * 路径和，root到叶子节点路径和是否等于targetSum
     * @param root
     * @param targetSum
     * @return
     */
    public boolean _112hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null&&root.val==targetSum){
            return true;
        }
        return _112hasPathSum(root.left,targetSum-root.val)||_112hasPathSum(root.right,targetSum-root.val);
    }
    /**
     * 杨辉三角所有行
     * @param numRows
     * @return
     */
    public List<List<Integer>> _118generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> lis = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    lis.add(1);
                } else {
                    lis.add(list.get(i - 2).get(j) + list.get(i - 2).get(j - 1));
                }
            }
            list.add(lis);
        }
        return list;
    }
    /**
     * 杨辉三角某一行
     * @param rowIndex
     * @return
     */
    public List<Integer> _119getRow(int rowIndex) {
        //排列组合
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }
    /**
     * 只交易一次的最大利润
     * @param prices
     * @return
     */
    public int _121maxProfit(int[] prices) {
        int min=prices[0];
        int ans=0;
        for(int i=1;i<prices.length;i++){
            ans=Math.max(ans,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return ans;
    }
    /**
     * 判断大小写字符是否回文 排除一些其它字符
     * @param s
     * @return
     */
    public boolean _125isPalindrome(String s) {
        int left=0,right=s.length()-1;
        while(left<=right){
            while (left<=right&&!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<=right&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(left<=right&&Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;right--;
        }
        return true;
    }
    /**
     * 数列中只有一个数字出现那一次 其余出现偶数次
     * @param nums
     * @return 只出现一次的数字
     */
    public int _136singleNumber(int[] nums) {
        int xor=0;
        for(int num:nums){
            xor&=num;
        }
        return xor;
    }
    /**
     * 判断是否有环
     * @param head
     * @return
     */
    public boolean _141hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next;
            fast=fast.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    /**
     * 前序遍历
     * @param root
     * @return
     */
    public List<Integer> _144preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {//前序遍历
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
    /**
     * 后续遍历
     * @param root
     * @return
     */
    public List<Integer> _145postorderTraversal(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        TreeNode pre=null;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                if(cur.right==null||cur.right==pre){
                    list.add(cur.val);
                    pre=cur;
                    cur=null;
                }else{
                    stack.push(cur);
                    cur=cur.right;
                }
            }
        }
        return list;
    }
    /**
     * 链表相交节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode _160getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode a=headA,b=headB;
        while(a!=b){
            if(a==null){
                a=headB;
            }else{
                a=a.next;
            }
            if(b==null){
                b=headA;
            }else{
                b=b.next;
            }
        }
        return a;
    }
    /**
     * 字符转数字 A-1 B-2
     * @param columnNumber
     * @return
     */
    public String _168convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();
        while(columnNumber!=0){
            int a=(columnNumber-1)%26;
            columnNumber=(columnNumber-1)/26;
            sb.append((char)(a+'A'));
        }
        return sb.reverse().toString();
    }
    /**
     * 返回多数元素 题意保证一定存在多数元素
     * @param nums
     * @return
     */
    public int _169majorityElement(int[] nums) {
        int seed=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==seed){
                count++;
            }else{
                count--;
                if(count==0){
                    if(i==nums.length-1){
                        return -1;
                    }else{
                        seed=nums[++i];
                        count=1;
                    }
                }
            }
        }
        return seed;
    }
    /**
     * 大写字符转数字 A-1 B-2
     * @param columnTitle
     * @return
     */
    public int _17titleToNumber(String columnTitle) {
        int ans=0;
        for(char c:columnTitle.toCharArray()){
            ans=ans*26+(c-'A')+1;
        }
        return ans;
    }
    /**
     * 逆转是否一样
     * @param x integer范围
     * @return
     */
    public boolean _9isPalindrome(int x) {
        if(x==0){
            return true;
        }
        if(x<0||x%10==0){
            return false;
        }
        int y=0;
        while(y<x){
            int a=x%10;//低位
            y=y*10+a;
            if(x==y){
                return true;
            }else if(y<0){//一半不会越界
                return false;
            }
            x/=10;
        }
        return x==y;
    }
    /**
     * 罗马符转数字
     * @param s
     * @return
     */
    public int _013romanToInt(String s) {
        String strs="IVXLCDM";
        int[]vals=new int[]{1,5,10,50,100,500,1000};
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<strs.length();i++){
            map.put(strs.charAt(i),vals[i]);
        }

        int ans=0,pre=-1;
        for(char c:s.toCharArray()){
            int val=map.get(c);
            if(pre==-1){
                pre=val;
            }else if(val<=pre){
                ans+=pre;
                pre=val;
            }else{
                ans+=val-pre;
                pre=-1;
            }
        }
        if(pre!=-1){
            ans+=pre;
        }
        return ans;
    }
    /**
     * 最长公共前缀
     * @param strs 长度至少为1
     * @return
     */
    public String _14longestCommonPrefix(String[] strs) {
        int len=strs[0].length();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len;i++){
            char c=strs[0].charAt(i);
            for(String str:strs){
                if(str.length()<=i||str.charAt(i)!=c){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
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



















































































