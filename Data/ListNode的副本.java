package yu;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

}

 class list {
	ListNode head;

	list() {
		head = null;
	}

	public void addList(int x) {
		ListNode nl = new ListNode(x);
		nl.next = head;
		head = nl;
	}

	public void deleteList(ListNode r) {
		ListNode cur = head;
		while (cur.next != null) {
			if (cur.val == r.val) {
				cur.next = cur.next.next;
			}
			cur = cur.next;
		}
	}
		
		public ListNode removeElements(ListNode head, int val) {
			
			/*
			 
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode p = dummy;
	    while (p.next != null) {
	        if (p.next.val == val) {
	            p.next = p.next.next;
	        } else {
	            p = p.next;
	        }
	    }
	    
	    return dummy.next;
			 */
			ListNode newl=new ListNode(0);
			newl.next=head;
			ListNode c=newl;
			
			while(c.next!=null){
				if (c.next.val == val) {
					c.next = c.next.next;
				} else
					c = c.next;
			}
			return newl.next;
	}

		
		
		public ListNode deleteDuplicates(ListNode head) {
			ListNode newlt=new ListNode(1);
			newlt.next=head;
			
			ListNode c = head;
			while (c != null) {
				if (c.next == null)
					break;

				if (c.next.val == c.val) {
					c.next = c.next.next;
				} else
					c = c.next;
			}

			return newlt;

		}
		public static void main(String args[]) {
			ListNode h = new ListNode(1);
			h.next = new ListNode(1);
			h.next = new ListNode(1);
		}

	}
