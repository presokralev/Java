package person.salary;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import  java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(reader.readLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] st = reader.readLine().split(" ");
            personList.add(new Person(st[0],st[1],Integer.parseInt(st[2]),Double.parseDouble(st[3])));
        }

        int bonus = Integer.parseInt(reader.readLine());

        for (int i = 0; i < personList.size(); i++) {
            personList.get(i).increaseSalary(bonus);
        }

      /**  personList.sort((firstPerson, secondPerson) -> {
            int comp = firstPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if(comp == 0){
                return Integer.compare(firstPerson.getAge(),secondPerson.getAge());
            }
            return comp;
        }); */



        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
    }
}