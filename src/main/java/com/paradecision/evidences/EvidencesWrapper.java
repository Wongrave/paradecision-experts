package com.paradecision.evidences;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvidencesWrapper {
    private List<Evidence> evidences;
}
