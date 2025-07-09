package IFMG_LuizEduardo_RenatoZampiere.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface StaysDetailedWithoutUserDataProjection {
    String getRoomName();
    String getScore();
    BigDecimal getRoomCost();
    BigDecimal getTotalStayCost();
    LocalDate getStartStay();
    LocalDate getEndStay();
}
