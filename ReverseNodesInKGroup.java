//Time Complexity: O(n); where n is total number of nodes in the input list.
//Space Complexity: O(1)
public class ReverseNodesInKGroup {	
	/**Definition for singly-linked list.**/
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {};
		ListNode(int x) { this.val = x;}
		ListNode(int x, ListNode next) { this.val = x; this.next = next;}
	}
		
	/**Approach: In-place reversal**/
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;        
        ListNode begin = dummy;        
        int i=0;
        while(head != null){
            i++;
            if(i%k != 0){
                head = head.next; 
            }else{
                begin = reverse(begin, head.next);  
                head = begin.next;
            }
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode begin, ListNode end){
        ListNode prev = begin;
        ListNode curr = begin.next;        
        ListNode fast = curr.next;
        ListNode first = curr;
        while(fast != end){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        begin.next = curr;
        first.next = end;
        return first;
    }

	/** Driver code to test above **/
	public static void main (String[] args) {
		ReverseNodesInKGroup ob = new ReverseNodesInKGroup();
		ListNode list= new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4, new ListNode(5)))));
		int k= 2;						  
		ListNode reversed=ob.reverseKGroup(list, k);				
		System.out.print("reversed list:");	
		while(reversed!=null) {
			System.out.print("\t"+reversed.val);
			reversed=reversed.next;
		}
	}	
}
