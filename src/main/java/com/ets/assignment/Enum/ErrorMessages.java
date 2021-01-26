package com.ets.assignment.Enum;

import lombok.Getter;

@Getter
public enum ErrorMessages {
    CODE_1 ("1", "İsim bilgisi dolu olmalı"),
    CODE_2 ("2", "Soyisim bilgisi dolu olmalı."),
    CODE_3 ("3", "Kan Grubu bilgisi dolu olmalı."),
    CODE_4 ("4", "Telefon numarası bilgisi dolu olmalı."),
    CODE_5 ("5", "Adres bilgisi dolu olmalı."),
    CODE_6 ("6", "Ok!")
    ;

    private String key;
    private String value;

    ErrorMessages(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getErrorMessageByKey(String key){
        for (ErrorMessages errorMessages : values()) {
            if (errorMessages.getKey().equals(key)) {
                return errorMessages.getValue();
            }
        }
        return null;
    }
}
