public class IterateLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.prepend("Batman");
        list.prepend("Bezos");
        list.prepend("dog");

        for (String ss : list) {
            System.out.println(ss);
        }
    }
}
