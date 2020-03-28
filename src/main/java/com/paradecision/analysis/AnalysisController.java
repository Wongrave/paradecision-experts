package com.paradecision.analysis;

import com.paradecision.evidences.Evidence;
import com.paradecision.evidences.EvidenceRepository;
import com.paradecision.propositions.factors.Factor;
import com.paradecision.propositions.factors.FactorRepository;
import com.paradecision.propositions.groups.Group;
import com.paradecision.propositions.groups.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/analysis")
@AllArgsConstructor
public class AnalysisController {

    private final EvidenceRepository evidenceRepository;
    private final GroupRepository groupRepository;
    private final FactorRepository factorRepository;

    //private final AnalysisModel analysisModel;

    @GetMapping("/from/{propositionId}")
    List<Evidence> analysis(@PathVariable Long propositionId) throws CloneNotSupportedException {
        BigDecimal gce;
        BigDecimal gin;
        Evidence finalEvidenceFavorable = new Evidence();
        Evidence finalEvidenceUnfavorable = new Evidence();
        List<Evidence> maxMinFavorable = new ArrayList<Evidence>();
        List<Evidence> maxMinUnfavorable = new ArrayList<Evidence>();
        List<Group> groups = groupRepository.findAllByPropositionId(propositionId);
        List<Factor> factors = factorRepository.findAllByPropositionId(propositionId);
        List<Evidence> miLambda = new ArrayList<Evidence>();
        for(Group group : groups) {
            List<Evidence> evidences = evidenceRepository.findAllByGroupId(group.getId());
            for (Factor factor : factors) {
                Evidence templateEvidence = new Evidence(BigDecimal.valueOf(0), BigDecimal.valueOf(100), factor);
                for (Evidence evidence : evidences) {
                    if (evidence.getFactor().getId() == factor.getId()) {
                        if (templateEvidence.getFavorable().compareTo(evidence.getFavorable()) == -1) {
                            templateEvidence.setFavorable(evidence.getFavorable());
                        }
                        if (templateEvidence.getUnfavorable().compareTo(evidence.getUnfavorable()) == 1) {
                            templateEvidence.setUnfavorable(evidence.getUnfavorable());
                        }
                    }
                }
                maxMinFavorable.add((Evidence) templateEvidence.clone());
            }
        }

        for(Factor factor : factors){
            Evidence templateEvidence = new Evidence(BigDecimal.valueOf(100), BigDecimal.valueOf(0), factor);
            for (Evidence evidence : maxMinFavorable){
                if (evidence.getFactor().getId() == factor.getId()){
                    if (templateEvidence.getFavorable().compareTo(evidence.getFavorable()) == 1){
                        templateEvidence.setFavorable(evidence.getFavorable());
                    }
                    if (templateEvidence.getUnfavorable().compareTo(evidence.getUnfavorable()) == -1){
                        templateEvidence.setUnfavorable(evidence.getUnfavorable());
                    }
                }
            }

            BigDecimal mi = templateEvidence.getFavorable().subtract(templateEvidence.getUnfavorable());
            BigDecimal lambda = templateEvidence.getFavorable().add(templateEvidence.getUnfavorable()).subtract(BigDecimal.valueOf(100));
            templateEvidence.setFavorable(mi);
            templateEvidence.setUnfavorable(lambda);
            miLambda.add((Evidence) templateEvidence.clone());
        }

        return miLambda;
    }

}
