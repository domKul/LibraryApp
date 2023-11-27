package nauka.queue;


import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class TaskManager {
    private Queue<Task> taskQueue = new PriorityQueue<>();
    private Scanner scanner = new Scanner(System.in);

    public Queue<Task> getTaskQueue() {
        return taskQueue;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void mainLoop(){
        Option option;
        do {
            printOption();
            System.out.println("wybiez opcje");
            option = Option.createFromint(scanner.nextInt());
            scanner.nextLine();
            switch (option){
                case ADD -> taskQueue.offer(createAndReadTask());
                case TAKE -> takeTask();
                case EXIT -> System.out.println("koniec programu");
            }

        }while (option != Option.EXIT);

    }

    private void takeTask() {
        if(taskQueue.isEmpty()){
            System.out.println("Brak zadan");
        }else{
            Task nextTask = taskQueue.poll();
            System.out.println("zadanie do wykonania");
            System.out.println(nextTask);
        }
    }

    private Task createAndReadTask() {
        System.out.println("podaj nazwe taska");
        String name = scanner.nextLine();
        System.out.println("deskrypcja");
        String desc = scanner.nextLine();
        System.out.println("podaj priorytet");
        for(Task.Priority priority : Task.Priority.values()){
            System.out.println(priority + " ");
        }
        System.out.println();
        Task.Priority priority = Task.Priority.valueOf(scanner.nextLine());
        System.out.println("zadanie dodane do kolejki");
        return new Task(name,desc,priority);
    }


    private void printOption(){
        Option[] values = Option.values();
        for (Option value : values) {
            System.out.println(value);
        }
        
    }


    private enum Option{
        ADD(0, "dodaj zadanie "),

        TAKE(1, "wez kolejne zadanie"),
        EXIT(2, "KONIEC");

        int number;
        String text;

        Option(int number, String text) {
            this.number = number;
            this.text = text;
        }
        static Option createFromint(int option){
            return values()[option];
        }

        @Override
        public String toString() {
            return  number + "-" + text;
        }
    }
}
