package main.java.com.giorop.leetcode.simple;

import java.util.*;

/**
 * @Description TODO
 * @ClassName SimpleDay2
 * @Author 夏雨人
 * @DateTime 2023/3/3 15:02
 * @Version 1.0
 */
public class SimpleDay2 {
    /**
     * 下一个更大元素
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] _496nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer>map=new HashMap<>();
        Stack<Integer>stack=new Stack<>();
        for(int i=0;i<nums2.length;i++){
            while(!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]){
                map.put(nums2[stack.pop()],nums2[i]);
            }
            stack.push(i);
        }
        int[]ans=new int[nums1.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<nums1.length;i++){
            Integer next=map.get(nums1[i]);
            if(next!=null){
                ans[i]=next;
            }
        }
        return ans;
    }
    public String[] _500findWords(String[] words) {
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        List<String> list = new ArrayList<>();
        for(String  word : words){
            int n1 = 0, n2 = 0 , n3 = 0 ,leng = word.length();
            for(int i = 0 ; i < leng ; i++){
                if(s1.contains(word.charAt(i)+"")) n1++;
                else if(s2.contains(word.charAt(i)+"")) n2++;
                else  n3++;
            }
            if(n1 == leng || n2 == leng || n3 == leng) list.add(word);
        }
        return list.toArray(new String[list.size()]);
    }
    /**
     * 转换成7进制
     * @param num
     * @return
     */
    public String _504convertToBase7(int num) {
        if(num==0){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        boolean flag=false;
        if(num<0){
            flag=true;
            num=-num;
        }
        while(num!=0){
            sb.append(num%7);
            num/=7;
        }
        if(flag){
            sb.append("-");
        }
        return sb.reverse().toString();
    }
    /**
     * 单词数量
     * @param s
     * @return
     */
    public int _434countSegments(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '&&(i==0||s.charAt(i-1)==' ')){
                ans++;
            }
        }
        return ans;
    }
    /**
     * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
     *
     * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/arranging-coins
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public int _441arrangeCoins(int n) {
        // a*(a+1)/2
        int left=1,right=n;
        int ans=1;
        while(left<=right){
            int mid=left+(right-left)/2;
            long a=(long)mid*(mid+1)/2;
            if(a<=n){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     *
     * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/assign-cookies
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param g
     * @param s
     * @return
     */
    public int _455findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans=0;
        int pos=0;
        for(int a:g){
            while(pos<s.length&&s[pos]<a){
                pos++;
            }
            if(pos>=s.length){
                break;
            }
            ans++;
            pos++;
        }
        return ans;
    }
    /**
     * 汉明距离
     * @param x
     * @param y
     * @return
     */
    public int _461hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
    /**
     * 岛屿周长 没有被包围的0
     * @param grid
     * @return
     */
    public int _463islandPerimeter(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    continue;
                }
                ans+=4;
                if(i-1>=0&&grid[i-1][j]==1){
                    ans-=2;
                }
                if(j-1>=0&&grid[i][j-1]==1){
                    ans-=2;
                }
            }
        }
        return ans;
    }
    /**
     * 二进制每位取反
     * @param num
     * @return
     */
    public int _476findComplement(int num) {
        //取最高位 然后掩码
        int highbit = 0;
        for (int i = 1; i <= 30; ++i) {
            if (num >= 1 << i) {
                highbit = i;
            } else {
                break;
            }
        }
        int mask = highbit == 30 ? 0x7fffffff : (1 << (highbit + 1)) - 1;
        return num ^ mask;
    }
    /**
     * 最大连续1
     * @param nums
     * @return
     */
    public int _485findMaxConsecutiveOnes(int[] nums) {
        int max=0,cur=0;
        for(int num:nums){
            if(num==1){
                cur++;
                max=Math.max(cur,max);
            }else{
                cur=0;
            }
        }
        return max;
    }
    /**
     * t比s 多一个字母 找出该字
     * @param s
     * @param t
     * @return
     */
    public char _389findTheDifference(String s, String t) {
        int[]counts=new int[26];
        counts[t.charAt(t.length()-1)-'a']++;
        for(int i=0;i<s.length();i++){
            counts[s.charAt(i)-'a']--;
            counts[t.charAt(i)-'a']++;
        }
        for(int i=0;i<counts.length;i++){
            if(counts[i]==1){
                return (char)(i+'a');
            }
        }
        return ' ';
    }
    /**
     * 最先出现的唯一数
     * @param s
     * @return
     */
    public int _387firstUniqChar(String s) {
        int[]lefts=new int[26];
        int[]rights=new int[26];
        Arrays.fill(lefts,-1);
        Arrays.fill(rights,-1);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(lefts[c-'a']==-1){
                lefts[c-'a']=i;
            }
            rights[c-'a']=i;
        }
        int ans=s.length();
        for(int i=0;i<lefts.length;i++){
            if(lefts[i]==-1){
                continue;
            }
            if(lefts[i]==rights[i]){
                ans=Math.min(ans,lefts[i]);
            }
        }
        return ans==s.length()?-1:ans;
    }
    /**
     * 判断完全平方 1<=num
     * @param num
     * @return
     */
    public boolean _367isPerfectSquare(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;

    }
    /**
     * ransomNote是否可以由magazine字符构成 消耗
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean _383canConstruct(String ransomNote, String magazine) {
        int[]counts=new int[26];
        for(char c:magazine.toCharArray()){
            counts[c-'a']++;
        }
        for(char c:ransomNote.toCharArray()){
            if(counts[c-'a']==0){
                return false;
            }
            counts[c-'a']--;
        }
        return true;
    }
}