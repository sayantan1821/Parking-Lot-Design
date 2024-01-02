package strategies;

import models.SlotAssignmentStrategyType;

public class SlotAssignmentStrategyFactory {
    public static SlotAssignmentStrategy getSlotByType(SlotAssignmentStrategyType slotAssignmentStrategy) {
        return new RandomSlotAssignmentStrategy();
    }
}
