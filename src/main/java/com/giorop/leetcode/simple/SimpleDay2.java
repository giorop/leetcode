package main.java.com.giorop.leetcode.simple;

/**
 * @Description TODO
 * @ClassName SimpleDay2
 * @Author 夏雨人
 * @DateTime 2023/3/3 15:02
 * @Version 1.0
 */
public class SimpleDay2 {
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















































