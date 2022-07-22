package org.nbki.task.four.task.two.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "csv")
@AllArgsConstructor
@NoArgsConstructor
public class CsvModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fid")
    private Integer fid;

    @Column(name = "serial_num")
    private String serialNum;

    @Column(name = "member_code")
    private String member;

    @Column(name = "acct_type")
    private String acctType;

    @Column(name = "opened_dt")
    private String openedDt;

    @Column(name = "acct_rte_cde")
    private String acctRteCde;

    @Column(name = "reporting_dt")
    private String reportingDt;

    @Column(name = "credit_limit")
    private String creditLimit;

    public CsvModel(Integer fid, String serialNum, String member, String acctType, String openedDt, String acctRteCde, String reportingDt, String creditLimit) {
        this.fid = fid;
        this.serialNum = serialNum;
        this.member = member;
        this.acctType = acctType;
        this.openedDt = openedDt;
        this.acctRteCde = acctRteCde;
        this.reportingDt = reportingDt;
        this.creditLimit = creditLimit;
    }

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

