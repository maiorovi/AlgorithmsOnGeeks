package tasks

def minInEachWindow(Integer[] arr, Integer size) {
    LinkedList<Integer> ll = new LinkedList<Integer>();

    for (int i = 0; i < size; i++) {
        ll.addLast(arr[i])
    }

    print "${ll.min()} "
//    ll.pollFirst()


    for (int i = size; i < arr.length; i++) {
        ll.pollFirst()
        ll.addLast(arr[i])
        if (ll.min() != null) print "${ll.min()} "

    }
}

minInEachWindow((Integer[])[12, 3, 4, 10, 6, 5].toArray(), 4)