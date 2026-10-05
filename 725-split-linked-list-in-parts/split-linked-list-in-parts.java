class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        int size = len / k;
        int extra = len % k;
        temp = head;
        for(int i = 0; i < k; i++){
            ans[i] = temp;
            int partSize = size + (extra > 0 ? 1 : 0);
            for(int j = 1; j < partSize && temp != null; j++){
                temp = temp.next;
            }
            if(temp != null){
                ListNode next = temp.next;
                temp.next = null;
                temp = next;
            }
            if(extra > 0){
                extra--;
            }
        }
        return ans;
    }
}