package com.paradecision.analysis;

import com.paradecision.evidences.Evidence;
import com.paradecision.evidences.EvidenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/analysis")
@AllArgsConstructor
public class AnalysisController {

    private final EvidenceRepository evidenceRepository;
    //private final AnalysisModel analysisModel;

    @GetMapping("/from/{propositionId}")
    List<Evidence> analysis(@PathVariable Long propositionId) {

        return evidenceRepository.findByPropositionId(propositionId);
    }

}
