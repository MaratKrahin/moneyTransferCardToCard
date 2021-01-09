
package com.mtService.dto;

import lombok.Data;

@Data
public class TransferDto {

    private Amount amount;
    private String cardFromNumber;
    private String cardToNumber;

}
