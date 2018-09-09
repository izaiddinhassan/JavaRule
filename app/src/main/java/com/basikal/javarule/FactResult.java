package com.basikal.javarule;

import android.support.annotation.NonNull;
import android.util.Log;

import com.deliveredtechnologies.rulebook.lang.RuleBuilder;
import com.deliveredtechnologies.rulebook.model.rulechain.cor.CoRRuleBook;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FactResult extends CoRRuleBook {

    private static final String TAG = "Something";
    private List<ApplicantBean> mBeanList;
    @Override
    public void defineRules() {

        addRule(RuleBuilder.create().withFactType(ApplicantBean.class).withResultType(String.class)
                .when(facts -> facts.getOne().getRuleFact() == "Rain")
                .then((facts, result) -> result.setValue("don't go to school"))
                .build());
        addRule(RuleBuilder.create().withFactType(ApplicantBean.class).withResultType(String.class)
                .when(facts -> facts.getOne().getRuleFact() == "Clear")
                .then((facts, result) -> result.setValue("go to school"))
                .build());
        addRule(RuleBuilder.create().withFactType(ApplicantBean.class).withResultType(String.class)
                .when(facts -> facts.getOne().getRuleFact() == "Cloudy")
                .then((facts, result) -> result.setValue("Maybe go to school"))
                .build());
        addRule(RuleBuilder.create().withFactType(ApplicantBean.class).withResultType(String.class)
                .when(facts -> facts.getOne().getRuleFact() == "Rain" &&
                                facts.getOne().getRuleFact2() == "Yes")
                .then((facts, result) -> result.setValue("go to school by car"))
                .build());

    }
}
