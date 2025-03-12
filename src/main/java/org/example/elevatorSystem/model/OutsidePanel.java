package org.example.elevatorSystem.model;

import lombok.Getter;
import org.example.elevatorSystem.enums.Direction;
import org.example.elevatorSystem.interfaces.Panel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
public class OutsidePanel implements Panel {
    List<DirectionButton> directionButtons;  // Can be a map (Action --> Button)
    HashMap<Direction, DirectionButton> directionButtonHashMap;

    public OutsidePanel() {
        directionButtonHashMap = new HashMap<>();
        for(int i=0;i<3;i++) {
            directionButtonHashMap.put(Direction.values()[i] ,new DirectionButton(false, Direction.values()[i]) );
        }
    }

    public Direction moveUp() {
        directionButtonHashMap.get(Direction.UP).pressButton();
        System.out.println("Moving Up");
        return Direction.UP;
    }

    public Direction moveDown() {
        directionButtonHashMap.get(Direction.DOWN).pressButton();
        System.out.println("Moving Down");
        return Direction.DOWN;
    }
}
