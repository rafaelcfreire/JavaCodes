package algoexpert.linkedlist;

public final class LinkedListConstruction {

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
//        Node threeTwo = new Node(3);
//        Node threeThree = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        DoublyLinkedList list = new DoublyLinkedList();
//        list.setHead(five);
//        list.setHead(four);
//        list.setHead(three);
//        list.setHead(two);
//        list.setHead(one);
//        list.setHead(four);
//
//        list.setTail(six);
//        list.insertBefore(six, three);
//        list.insertAfter(six, threeTwo);
//        list.insertAtPosition(1, threeThree);
//        list.removeNodesWithValue(3);
//        list.containsNodeWithValue(5);

//        list.setHead(one);
//        list.insertAfter(one, two);
//        list.insertAfter(two, three);
//        list.insertAfter(three, four);
//        list.setTail(one);
        list.setHead(one);
        list.insertAfter(one, two);
        list.insertAfter(two, three);
        list.insertAfter(three, four);
        list.insertAfter(four, five);
        list.insertAfter(five, six);
        list.insertAfter(six, seven);
        list.insertAtPosition(7, one);
        list.insertAtPosition(1, one);
        list.insertAtPosition(2, one);
        list.insertAtPosition(3, one);
        list.insertAtPosition(4, one);
        list.insertAtPosition(5, one);
        list.insertAtPosition(6, one);
    }

    public static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public void setHead(Node node) {
            remove(node);
            if (this.head != null) {
                Node temp = this.head;
                node.next = temp;
                temp.prev = node;
            }
            if (this.tail == null)
                this.tail = node;
            this.head = node;
        }

        public void setTail(Node node) {
            remove(node);
            if (this.tail != null) {
                Node temp = this.tail;
                temp.next = node;
                node.prev = temp;
            }
            if (this.head == null)
                this.head = node;
            this.tail = node;
        }

        public void insertBefore(Node node, Node nodeToInsert) {
            if (node != null && node.prev == nodeToInsert) return;
            if (node == null || node.prev == null)
                setHead(nodeToInsert);
            else {
                remove(nodeToInsert);

                Node prevTemp = node.prev;
                if (prevTemp != null)
                    prevTemp.next = nodeToInsert;
                node.prev = nodeToInsert;
                nodeToInsert.prev = prevTemp;
                nodeToInsert.next = node;
            }
        }

        public void insertAfter(Node node, Node nodeToInsert) {
            if (node.next == null) {
                setTail(nodeToInsert);
            } else {
                remove(nodeToInsert);

                Node nextTemp = node.next;
                if (nextTemp != null)
                    node.next.prev = nodeToInsert;
                node.next = nodeToInsert;
                nodeToInsert.prev = node;
                nodeToInsert.next = nextTemp;
            }
        }

        public void insertAtPosition(int position, Node nodeToInsert) {
            Node node = head;
            int currentPosition = 1;
            while (node != null && currentPosition++ != position)
                node = node.next;
            if (node != null)
                insertBefore(node, nodeToInsert);
            else
                setTail(nodeToInsert);
//            Node currentNode = head;
//
//            for(int i = 1; i <= position; i++) {
//                currentNode = currentNode.next;
//            }
//            insertBefore(currentNode, nodeToInsert);
        }

        public void removeNodesWithValue(int value) {
            Node currentNode = head;

            while (currentNode != null) {
                Node temp = currentNode.next;

                if(currentNode.value == value)
                    remove(currentNode);
                currentNode = temp;
            }
        }

        public void remove(Node node) {
            Node tempPrev = node.prev;
            Node tempNext = node.next;

            if (node == head)
                head = tempNext;
            if (node == tail)
                tail = tempPrev;
            if (tempPrev != null)
                tempPrev.next = node.next;
            if (tempNext != null)
                tempNext.prev = tempPrev;
            node.prev = null;
            node.next = null;
        }

        public boolean containsNodeWithValue(int value) {
            Node currentNode = head;

            while (currentNode != null) {
                if(currentNode.value == value)
                    return true;
                currentNode = currentNode.next;
            }
            return false;
        }
    }

    public static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
