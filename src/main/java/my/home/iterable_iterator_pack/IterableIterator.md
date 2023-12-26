Iterable содержит метод по умолчанию forEach():

        ArrayList<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 1, 2, 3, 4);
        arr.forEach(System.out::print); // elem -> System.out.print(elem);

Методы Iterator:
* hasNext()
* next()
* remove()
