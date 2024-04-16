package com.targetindia.utils;

import com.targetindia.utils.exceptions.InvalidMonthException;
import com.targetindia.utils.exceptions.InvalidYearException;

public class DateUtils {
    public Integer maxDays(Integer month,Integer year) throws Exception {
        if(month<1 || month>12){
            throw new InvalidMonthException("Month should be between 1 and 12");
        }
        if(year<1){
            throw new InvalidYearException("Year must be >= 1");
        }

        Integer days = 31;
        if(year%400==0 || (year%4==0 && year%100!=0)){
            if(month==2){
                return 29;
            }
            else if(month==4 || month==6 || month==9 || month==11){
                return 30;
            }
        }
        else {
            if(month==2){
                return 28;
            }
            else if(month==4 || month==6 || month==9 || month==11){
                return 30;
            }
        }
        return days;
    }
}
