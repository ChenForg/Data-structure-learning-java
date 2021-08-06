package DataStruct;

public class List {
    private Node head;
    private Node tail;
    private int count = 0;

    public class Node {
        int data;
        Node next;

        public void Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int item) {

        Node newNode = new Node();
        newNode.Node(item);
        if(this.count==0)
        {
            this.head = newNode;
            this.tail = newNode;
            count++;
        }else if(this.count>0)
        {
            newNode.next = this.head;
            this.head=newNode;//为什么只用更新头节点，不用链接
            this.count++;
        }
    }

    public void addEnd(int item) {
        Node newNode = new Node();
        newNode.Node(item);
        if(this.count==0)
        {
            this.head = newNode;
            this.tail = newNode;
            this.count++;
        }else
        {
            this.tail.next = newNode;
            this.tail = newNode;
            this.count++;
        }
    }

    public void insert(int idx,int val)
    {
        Node temp = this.head;
        Node addNode = new Node();
        addNode.Node(val);
        if(idx==0) this.addFirst(val);
        else if(idx==this.count) this.addEnd(val);
        else{
            for(int i=1;i<idx;i++)
            {
                temp=temp.next;
            }
            Node t = temp.next;
            temp.next = addNode;
            addNode.next = t;
            count++;
        }
    }

    public int getFirst()throws Exception{
        if (this.count == 0) {
            throw new Exception("It's Empty");
        } else return this.head.data;
    }

    public int getEnd()throws Exception{
        if (this.count > 0)
            return this.tail.data;
        else throw new Exception("It's Empty");
    }

    public int getAt(int index) throws Exception {
        if (this.count == 0) throw new Exception("It's Empty");
        if (index < 0 || index > this.count) throw new Exception("Invalid Index");

        Node temp = this.head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public Node getNodeAt(int idx)throws Exception {
        if (this.count == 0) throw new Exception("It's Empty");
        if (idx < 0 || idx > this.count) throw new Exception("Invalid Index");

        Node temp = this.head;
        for (int i = 1; i < idx; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void removeFirst()throws Exception
    {
        if (this.count == 0) throw new Exception("It's Empty");
        else if(this.count>1)
        {
            this.head = this.head.next;
            this.count --;
        }else
        {
            this.head=null;
            this.tail=null;
            this.count = 0;
        }
    }
    public void removeLast()throws Exception
    {
        if (this.count == 0) throw new Exception("It's Empty");
        else if(this.count>1)
        {
            Node sm2=getNodeAt(this.count-1);
            sm2.next=null;
            this.tail=sm2;
            this.count--;
        }else
        {
            this.head=null;
            this.tail=null;
            this.count = 0;
        }
    }

    public void removeAt(int idx)throws Exception
    {
        if (this.count == 0) throw new Exception("It's Empty");
        else if (idx < 0 || idx > this.count) throw new Exception("Invalid Index");
        else if(idx==0) this.removeFirst();
        else if(idx==count-1) this.removeLast();
        else{
            Node tempnode=getNodeAt(idx-1);
            Node n = tempnode.next;
            Node m = n.next;
            tempnode.next = m;
            count--;
        }
    }

    public void display (){
        System.out.println("-------------------");
        Node temp = this.head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println("\n-------------------");
    }
    public static void main(String[] args)throws Exception
    {
        //System.out.println("test");
        List list = new List();
        list.addFirst(1);
        list.addEnd(2);
        list.addFirst(3);
        list.insert(2,6);//3162
        list.display();
        list.removeAt(2);
        System.out.println(list.count);
        list.display();
        list.insert(3,9);
        list.display();
        list.removeFirst();
        System.out.println(list.count);
        list.display();
        list.removeLast();
        System.out.println(list.count);
        list.display();

    }
}

