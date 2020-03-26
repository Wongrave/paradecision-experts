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
        for(Group group : groups){
            List<Evidence> evidences = evidenceRepository.findAllByGroupId(group.getId());
            for(Factor factor : factors){
                Evidence templateEvidenceFavorable = new Evidence(BigDecimal.valueOf(0), BigDecimal.valueOf(100), factor);
                Evidence templateEvidenceUnfavorable = new Evidence(BigDecimal.valueOf(0), BigDecimal.valueOf(100), factor);
                for (Evidence evidence : evidences){
                    if ( evidence.getFactor().getId() == factor.getId() ){
                        if (templateEvidenceFavorable.getFavorable().compareTo(evidence.getFavorable())==-1){
                            templateEvidenceFavorable = (Evidence) evidence.clone();
                        }
                        if (templateEvidenceUnfavorable.getUnfavorable().compareTo(evidence.getUnfavorable())==1){
                            templateEvidenceUnfavorable = (Evidence) evidence.clone();
                        }
                    }
                }
                maxMinFavorable.add((Evidence) templateEvidenceFavorable.clone());
                maxMinUnfavorable.add((Evidence) templateEvidenceUnfavorable.clone());
            }
            for(Factor factor : factors){
                Evidence templateEvidenceFavorable = new Evidence(BigDecimal.valueOf(100), BigDecimal.valueOf(0), factor);
                Evidence templateEvidenceUnfavorable = new Evidence(BigDecimal.valueOf(100), BigDecimal.valueOf(0), factor);
                for (Evidence evidence : maxMinFavorable){
                    if (evidence.getFactor().getId() == factor.getId()){
                        if (templateEvidenceFavorable.getFavorable().compareTo(evidence.getFavorable())==1){
                            templateEvidenceFavorable = (Evidence) evidence.clone();
                        }
                    }
                }
                for (Evidence evidence : maxMinUnfavorable){
                    if (evidence.getFactor().getId() == factor.getId()){
                        if (templateEvidenceUnfavorable.getUnfavorable().compareTo(evidence.getUnfavorable())==-1){
                            templateEvidenceUnfavorable = (Evidence) evidence.clone();
                        }
                    }
                }
                finalEvidenceFavorable = (Evidence) templateEvidenceFavorable.clone();
                finalEvidenceUnfavorable = (Evidence) templateEvidenceUnfavorable.clone();
            }
        }

        return evidenceRepository.findByPropositionId(propositionId);
    }

}
