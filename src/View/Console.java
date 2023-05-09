package View;

import presenter.DemoArray;

import java.util.Scanner;

public class Console {
    public Console(){
        dd = new DemoArray();
    }
    private DemoArray dd;
    public void userConsole() throws Exception{
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println(" Выберите тип данных: 1- Integer, 2- Double, 3- String, 99- завершить работу: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    this.intDemo();
                    break;
                case 2:
                    this.dblDemo();
                    break;
                case 3:
                    this.strDemo();
                    break;
            }
        }while (choice != 99);
    }
    private void intDemo() throws Exception {
        System.out.println("тип Integer");
        System.out.println(dd.intDA);
        dd.intDA.add(10);
        System.out.println("Добавление элемента со значением 10");
        System.out.println(dd.intDA);
        dd.intDA.add(45, 2);
        System.out.println("Добавление элемента со значением 45 на позицию 2");
        System.out.println(dd.intDA);
        dd.intDA.remove(10);
        System.out.println("Удаление элемента с позиции 10");
        System.out.println(dd.intDA);
        dd.intDA.remove((Integer) 45);
        System.out.println("Удаление элемента со значением 45");
        System.out.println(dd.intDA);
        System.out.println("Минимум");
        System.out.println(dd.intDA.min(Integer::compare));
        System.out.println("Максимум");
        System.out.println(dd.intDA.max(Integer::compare));
        System.out.println("Замена элемента №10 значением 77");
        dd.intDA.replace(77, 10);
        System.out.println(dd.intDA);
        System.out.println("Длина массива");
        System.out.println(dd.intDA.size());
        System.out.println("Сумма элементов массива");
        System.out.println(dd.intDA.sum());
        System.out.println("Сортировка пузырьком");
        dd.intDA.bubbleSort(Integer::compare);
        System.out.println(dd.intDA);

    }

    private void strDemo() throws Exception {
        System.out.println("Пример использования DynArray с типом данных String");
        System.out.println(dd.strDA);
        dd.strDA.add("LAST");
        System.out.println("Добавление в конец элемента со значением LAST");
        System.out.println(dd.strDA);
        dd.strDA.add("SECOND", 2);
        System.out.println("Добавление элемента со значением SECOND на позицию 2");
        System.out.println(dd.strDA);
        dd.intDA.remove(10);
        System.out.println("Удаление элемента с позиции 10");
        System.out.println(dd.strDA);
        dd.strDA.remove("SECOND");
        System.out.println("Удаление элемента со значением SECOND");
        System.out.println(dd.strDA);
        System.out.println("Минимум (длина строки)");
        System.out.println(dd.strDA.min((s0, s1) -> s0.length() - s1.length()));
        System.out.println("Максимум (длина строки)");
        System.out.println(dd.strDA.max((s0, s1) -> s0.length() - s1.length()));
        System.out.println("Замена элемента №10 значением TEN");
        dd.strDA.replace("TEN", 10);
        System.out.println(dd.strDA);
        System.out.println("Длина массива");
        System.out.println(dd.strDA.size());
        System.out.println("Сортировка вставками");
        dd.strDA.insertSort((s0, s1) -> s0.length() - s1.length());
        System.out.println(dd.strDA);
    }

    private void dblDemo() throws Exception {
        System.out.println("Пример использования DynArray с типом данных Double");
        System.out.println(dd.dblDA);
        dd.dblDA.add(10.0);
        System.out.println("Добавление в конец элемента со значением 10.0");
        System.out.println(dd.dblDA);
        dd.dblDA.add(45.0, 2);
        System.out.println("Добавление элемента со значением 45.0 на позицию 2");
        System.out.println(dd.dblDA);
        dd.dblDA.remove(3);
        System.out.println("Удаление элемента с позиции 3");
        System.out.println(dd.dblDA);
        dd.dblDA.remove(45.0);
        System.out.println("Удаление элемента со значением 45.0");
        System.out.println(dd.dblDA);
        System.out.println("Минимум");
        System.out.println(dd.dblDA.min(Double::compare));
        System.out.println("Максимум");
        System.out.println(dd.dblDA.max(Double::compare));
        System.out.println("Замена элемента №4 значением 77.8");
        dd.dblDA.replace(77.8, 4);
        System.out.println(dd.dblDA);
        System.out.println("Длина массива");
        System.out.println(dd.dblDA.size());
        System.out.println("Сумма элементов массива");
        System.out.println(dd.dblDA.sum());
        System.out.println("Произведение элементов массива");
        System.out.println(dd.dblDA.multiply());
        System.out.println("Сортировка выбором");
        dd.dblDA.simpleChoiceSort(Double::compare);
        System.out.println(dd.dblDA);
    }
}
