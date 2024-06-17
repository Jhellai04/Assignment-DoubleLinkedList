package DoubleLinkedList;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    // Create a DLL
    public DoublyNode createDLL(int nodeValue) {
        head = new DoublyNode();
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;
        head = newNode;
        tail = newNode;
        size = 1;
        return head;
    }

    // Insert into a DLL
    public void insertDLL(int nodeValue, int location) {
        DoublyNode newNode = new DoublyNode();
        newNode.value = nodeValue;

        if (head == null) {
            createDLL(nodeValue);
            return;
        } else if (location == 0) {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
        } else if (location >= size) {
            newNode.next = null;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            DoublyNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            newNode.prev = tempNode;
            newNode.next = tempNode.next;
            tempNode.next.prev = newNode;
            tempNode.next = newNode;
        }
        size++;
    }

    // Traverse a Linked List
    public void traverseDLL() {
        if (head == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = head;
            while (tempNode != null) {
                System.out.print(tempNode.value);
                if (tempNode.next != null) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.next;
            }
            System.out.println();
        }
    }

    // Reverse Traverse
    public void reverseTraverseDLL() {
        if (tail == null) {
            System.out.println("DLL does not exist");
        } else {
            DoublyNode tempNode = tail;
            while (tempNode != null) {
                System.out.print(tempNode.value);
                if (tempNode.prev != null) {
                    System.out.print(" <-> ");
                }
                tempNode = tempNode.prev;
            }
            System.out.println();
        }
    }

    // Search Node
    public void search(int value) {
        if (head == null) {
            System.out.println("DLL does not exist");
            return;
        }

        DoublyNode tempNode = head;
        int index = 0;
        boolean found = false;
        while (tempNode != null) {
            if (tempNode.value == value) {
                found = true;
                break;
            }
            tempNode = tempNode.next;
            index++;
        }

        if (found) {
            System.out.println("Value " + value + " found at index " + index);
        } else {
            System.out.println("Value " + value + " not found in DLL");
        }
    }

    // Deletion Method
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("DLL does not exist");
            return;
        }

        if (location == 0) {
            if (head.next == null) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else if (location >= size - 1) {
            if (tail.prev == null) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
        } else {
            DoublyNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            if (tempNode.next != null) {
                tempNode.next.prev = tempNode;
            }
        }
        size--;
    }

    // Delete entire DLL
    public void deleteDLL() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("DLL deleted successfully");
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertDLL(1, 0);
        doublyLinkedList.insertDLL(2, 1);
        doublyLinkedList.insertDLL(3, 2);
        doublyLinkedList.insertDLL(4, 3);

        System.out.print("Forward traversal: ");
        doublyLinkedList.traverseDLL();

        System.out.print("Reverse traversal: ");
        doublyLinkedList.reverseTraverseDLL();

        doublyLinkedList.search(3);

        System.out.print("After deleting node at location 1: ");
        doublyLinkedList.deleteNode(1);
        doublyLinkedList.traverseDLL();

        System.out.print("After deleting entire DLL: ");
        doublyLinkedList.deleteDLL();
        doublyLinkedList.traverseDLL();
    }
}
