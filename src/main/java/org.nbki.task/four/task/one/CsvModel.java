package org.nbki.task.four.task.one;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CsvModel {

    private Integer fid;
    private String serialNum;
    private String member;
    private String acctType;
    private String openedDt;
    private String acctRteCde;
    private String reportingDt;
    private String creditLimit;

    public String[] getMassField(){
        return new String[]{
                fid.toString(),
                serialNum,
                member,
                acctType,
                openedDt,
                acctRteCde,
                reportingDt,
                creditLimit
        };
    }
}

