package eg.edu.alexu.csd.datastructure.stack.cs73;
//we use the linked list to implement the stack so we create a node class
class node{
    // to avoid any messing with our node we made every thing private and built methods to handel our fields
   private Object data;
   private node next;
   public void setData(Object info){
       this.data=info;
   }
   public void setNext(node m){
       this.next=m;
   }
   public Object getData(){
       return data;
   }
   public node getNext(){
       return next;
   }
}

public class stack implements IStack {
    // here we made the head node private to not risk messing with it in the main
    private  node head ;
    // here we made the size private to not risk messing with it in the main
   private int size=0;
    public void push (Object data){
        // here we create a new node and save the data in it
        node x=new node();
        x.setData(data);
           // here we see if the stack is empty or not if it is we make the node is the head
        if (size==0){
            head=x;
            size++;
        }else {
            // if the stack is not empty we add the node to the top and make it the new head
            x.setNext(head);
            head=x;
            size++;
        }
    }
    public Object pop(){
        // here we check if the stack is empty or not if it is we throw an exception
        if (size()==0){
            throw new RuntimeException();
        }else {
              // here we get the data from the head and remove the head
            Object hold = head.getData();
            node n = head;
            node m = head;
            n = n.getNext();
            head = n;
            m.setNext(null);
            size--;
            return hold;
        }
    }

    public Object peek(){
        // here we check if the stack is empty or not if it is we throw an exception

        if(size==0){
            throw new RuntimeException();
        }else {

            return head.getData();
    }
    }
    public boolean isEmpty(){
        // here we check the size if it is zero then we return true if not we return false
        boolean good;
        if (size==0){
            good=true;
        }else{
            good=false;
        }
        return good;
    }
    public int size(){
        return size;
    }


}

