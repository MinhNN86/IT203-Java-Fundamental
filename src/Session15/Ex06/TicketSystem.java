package Session15.Ex06;

import java.util.LinkedList;
import java.util.Queue;

public class TicketSystem {
    private Queue<Ticket> ticketQueue = new LinkedList<>();
    private int currentNumber = 0;

    public Ticket issueTicket(String time) {
        currentNumber++;
        Ticket ticket = new Ticket(currentNumber, time);
        ticketQueue.offer(ticket);
        return ticket;
    }

    public Ticket callNext() {
        return ticketQueue.poll();
    }
}
