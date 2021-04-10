 class Node{
    int data;
    Node next;
    public Node(int x){
        data = x;
        next = null;
    }
}
 
class HashTable {
    private Node[] table;
    private int[] tableSize;
    private int size;
 
    public HashTable(int size) {
        table = new Node[size];
        tableSize = new int[size];
        this.size = size;
    }
    public void push(int val){
        Node temp = new Node(val);
        int key = hash(val);              
        if (table[key] == null){
            table[key] = temp;
        } else {
            temp.next = table[key];
            table[key] = temp;
        }
        tableSize[key]++;
    }
    public Node get(int val) {
        int key = hash(val);    
        Node temp = table[key];
        while(temp != null && temp.data != val) {
            temp = temp.next;
        }
        return temp;
    }
    public void pop(int val) {
        int key = hash(val);
        Node temp = table[key];

        if (temp == null){
            return;
        }
        if (temp.data == val) {
            table[key] = temp.next;
            tableSize[key]--;
            return;
        }
        while (temp.next != null && temp.next.data != val){
            temp = temp.next;
        }
        if (temp.next == null){
            return;
        }
        if (temp.next.next == null) {
            temp.next = null;
        } else {
            temp.next = temp.next.next;
        }
        tableSize[key]--;
    }
    private int hash(int x) {
        int hash = 5381;
        for(int i = 0; i < x; i++){
            int c = i;//array
            hash = ((hash << 5) + hash) + c;
        }
        hash %= size;
        if (hash < 0) hash *= -1;
        return hash;
    }
}
