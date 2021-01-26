package com.ets.assignment.Enum;

import lombok.Getter;

@Getter
public enum BloodTypesEnum {
    OP ("0P", "0 RH +"),
    ON ("0N", "0 RH -"),
    AP ("AP", "A RH +"),
    AN ("AN", "A RH -"),
    BP ("BP", "B RH +"),
    BN ("BN", "B RH -"),
    ABP ("ABP", "AB RH +"),
    ABN ("ABN", "AB RH -"),
    ;

    private String code;
    private String value;

    BloodTypesEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getBloodTypeByCode(String code){
        for (BloodTypesEnum bloodTypes : values()) {
            if (bloodTypes.getCode().equals(code)) {
                return bloodTypes.getValue();
            }
        }
        return null;
    }
}
