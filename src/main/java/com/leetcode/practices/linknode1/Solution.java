package com.leetcode.practices.linknode1;

import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while (!Objects.isNull(l1) || !Objects.isNull(l2)) {
            int x = Objects.isNull(l1.val) ? 0 : l1.val;
            int y = Objects.isNull(l2.val) ? 0 : l2.val;
            sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;

            curr.next = new ListNode(sum);

            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            curr.next = new ListNode(carry);
        }
        return pre.next;

    }
}
