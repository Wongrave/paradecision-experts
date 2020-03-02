package com.paradecision.evidences;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class EvidenceDto {

    private Long id;
    private BigDecimal favorable;
    private BigDecimal unfavorable;

    public EvidenceDto(Evidence ev) {
        this(ev.getId(), ev.getFavorable(), ev.getUnfavorable());
    }

}
