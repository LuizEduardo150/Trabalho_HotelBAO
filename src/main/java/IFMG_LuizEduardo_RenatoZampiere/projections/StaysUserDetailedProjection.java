package IFMG_LuizEduardo_RenatoZampiere.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface StaysUserDetailedProjection {
    Long getUserId();
    Long getRoomId();
    String getRoomName();
    String getClientName();
    String getClientPhone();
    String getClientEmail();
    LocalDate getStartStay();
    LocalDate getEndStay();
    BigDecimal getTotalCost();
}
