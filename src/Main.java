//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(4);
        list.insertFirst(18);
        list.reverse();
//        System.out.println("The value you are looking for is at Node " + list.findNode(18));
       list.display();
    }
}