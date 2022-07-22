package org.nbki.task.four.task.one;

public enum FieldCsv {
        FID, SERIAL_NUM, MEMBER_CODE, ACCT_TYPE, OPENED_DT, ACCT_RTE_CDE, REPORTING_DT, CREDIT_LIMIT;

    public static String[] getMassFieldName(){
        return new String[]{
                FID.toString(),
                SERIAL_NUM.toString(),
                MEMBER_CODE.toString(),
                ACCT_TYPE.toString(),
                OPENED_DT.toString(),
                ACCT_RTE_CDE.toString(),
                REPORTING_DT.toString(),
                CREDIT_LIMIT.toString()
        };
    }
}
