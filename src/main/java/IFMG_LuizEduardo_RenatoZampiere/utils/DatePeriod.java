package IFMG_LuizEduardo_RenatoZampiere.utils;

import IFMG_LuizEduardo_RenatoZampiere.utils.Utils;

import java.text.DateFormat;
import java.time.LocalDateTime;


public class DatePeriod {

    private LocalDateTime init;
    private LocalDateTime end;

    public DatePeriod() {}

    public DatePeriod(LocalDateTime inicio, LocalDateTime fim) {
        if(inicio != null && fim != null && !inicio.isAfter(fim)){
            init = inicio;
            end = fim;
        }
    }

    public DatePeriod(String init, String end) {
        if(init == null | end == null)
            return;
        try {
            LocalDateTime initP = LocalDateTime.parse(init);
            LocalDateTime endP = LocalDateTime.parse(end);

            if(!initP.isAfter(endP)){
                this.init = initP;
                this.end = endP;
            }
        }catch (Exception e){
            return;
        }
    }

    public LocalDateTime getInit() {
        return init;
    }

    public LocalDateTime getEnd() {
        return end;
    }

}
