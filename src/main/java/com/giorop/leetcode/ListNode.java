package com.giorop.leetcode;

/**
 * @Description TODO
 * @ClassName ListNode
 * @Author 夏雨人
 * @DateTime 2023/3/2 9:05
 * @Version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val=val;
    }
    public ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}
