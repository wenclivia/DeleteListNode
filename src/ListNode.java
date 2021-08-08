import java.util.HashSet;
import java.util.Stack;

class LinkedListDemo {
    ListNode head;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
}
public ListNode removeElements(ListNode head,int val){
    while(head!=null){
        if(head.val!=val){
            break;
        }
        head=head.next;
    }
    ListNode cur=head;
    ListNode pre =head;
    while(cur!=null){
        if(cur.val==val){
            pre.next=cur.next;
        }else{
            pre=cur;
        }
        cur=cur.next;
    }
    return head;
}
public ListNode removeElementsByStack(ListNode head,int val){
    Stack<ListNode> stack=new Stack<ListNode>();
    while(head!=null){
        if(head.val!=val){
            stack.push(head);
        }
        head=head.next;
    }
    while(!stack.isEmpty()){
        stack.peek().next=head;
        head=stack.pop();
    }
    return head;
}
public ListNode removePepeat(ListNode head){
    if(head==null){
        return null;
    }
    HashSet<Integer> set=new HashSet<Integer>();
    set.add(head.val);
    ListNode pre=head;
    ListNode cur=head.next;
    while(cur!=null){
        if(set.contains(cur.val)){
            pre.next=cur.next;
        }else{
            set.add(cur.val);
            pre=cur;
        }
        cur=cur.next;
    }
    return head;
}
    public void display(ListNode head){
        System.out.print("list:");
        ListNode cur = head;
        while(cur!=null){
            System.out.print(cur.val+"->");
            cur = cur.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public void insert(int val){
        if(head==null){
            head = new ListNode(val);
        }else{
            ListNode cur = head;
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = new ListNode(val);
        }
    }

    public static void main(String[] args) {
        LinkedListDemo list = new LinkedListDemo();
        list.insert(1);
        list.insert(2);
        list.insert(6);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.display(list.head);
        ListNode head = list.removeElements(list.head, 6);
        list.display(head);
    }

}