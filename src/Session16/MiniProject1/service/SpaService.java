package Session16.MiniProject1.service;

import Session16.MiniProject1.model.Pet;

import java.util.LinkedList;
import java.util.Queue;

public class SpaService {
    private Queue<Pet> queue = new LinkedList<>();

    public void addToQueue(Pet pet) {
        queue.offer(pet);
    }

    public Pet serveNext() {
        return queue.poll();
    }

    public void showQueue() {
        for (Pet pet : queue) {
            System.out.println(pet);
        }
    }
}
