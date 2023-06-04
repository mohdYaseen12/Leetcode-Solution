class MyLinkedList {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    
    public Node head;
    public MyLinkedList() {
        head = null;
    }
    
    public int get(int index) {
        Node curr = head;
        if(curr == null || index < 0) return -1;
        
        while(curr != null && index > 0){
            curr = curr.next;
            index--;
        }
        
        if(curr == null || index < 0) return -1;
        return curr.data;
    }
    
    public void addAtHead(int val) {
        Node nn = new Node(val);
        if(head == null){
            head = nn;
        }
        else{
            nn.next = head;
            head = nn;
        }
        
    }
    
    public void addAtTail(int val) {
        Node nn = new Node(val);
        if(head == null){
            head = nn;
        }
        else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = nn;
        }
        
    }
    
    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
            return;
        }
        Node curr = head;
        Node prev = null;
        Node nn = new Node(val);
        while(curr != null && index != 0){
            prev = curr;
            curr = curr.next;
            index--;
        }
        if(index != 0){
            return;
        }
        nn.next = curr;
        prev.next = nn;
    }
    
    public void deleteAtIndex(int index) {
        if(head == null) return;
        
        Node curr = head;
        Node prev = null;
        
        while(curr != null && index != 0){
            prev = curr;
            curr = curr.next;
            index--;
        }
        
        if(curr != null && index == 0){
            if(prev == null){
                head = curr.next;
                return;
            }
            prev.next = curr.next;
        }
        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */