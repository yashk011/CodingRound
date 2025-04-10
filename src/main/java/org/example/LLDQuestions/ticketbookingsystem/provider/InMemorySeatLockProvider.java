package org.example.LLDQuestions.ticketbookingsystem.provider;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import org.example.ticketbookingsystem.model.Seat;
import org.example.ticketbookingsystem.model.SeatLock;
import org.example.ticketbookingsystem.model.Show;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class InMemorySeatLockProvider implements SeatLockProvider{

    private int timeout;
    private HashMap<Show, Map<Seat, SeatLock>> seatLocks;

    public InMemorySeatLockProvider() {
        timeout = 60;
        seatLocks = new HashMap<>();
    }

    @Override
    @SneakyThrows
    public void lockSeats(Show show, List<Seat> seatList) {
        for (Seat seat : seatList) {
            if (isSeatAlreadyLocked(show, seat)) {
                throw new Exception("Seat Already Locked");
            }
        }

        for (Seat seat : seatList) {
            lockSeat(seat, show, timeout);
        }
    }

    @SneakyThrows
    @Override
    public void unlockSeats(Show show, List<Seat> seats) {

        if(!seatLocks.containsKey(show))
            throw new Exception("Show Not availble");
        for(Seat seat : seats) {
            unLockSeat(seat, show);
        }
    }

    private void unLockSeat(Seat seat, Show show) {
        seatLocks.get(show).remove(seat);
    }

    private void lockSeat(Seat seat, Show show, int timeout) {
        if(!seatLocks.containsKey(show)) {
            seatLocks.put(show, new HashMap<>());
        }
        seatLocks.get(show).put(seat,
                new SeatLock("124", seat, timeout, new Date(), show));

    }

    private boolean isSeatAlreadyLocked(Show show, Seat seat) {
        if(!seatLocks.containsKey(show))
            return false;
        if(seatLocks.get(show).containsKey(seat))
            return true;
        return false;
    }

    @SneakyThrows
    @Override
    public List<Seat> getLockedSeats(Show show){
        if(!seatLocks.containsKey(show))
            return new ArrayList<>();

        return seatLocks.get(show).keySet().stream().collect(Collectors.toList());
    }

}
