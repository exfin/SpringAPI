package com.entrega1.entrega1.services;

import com.entrega1.entrega1.models.RevengePlan;

import java.util.List;

public interface IServiceRevengePlan {
    public List<RevengePlan> getRevengePlan();
    public void addRevengePlan(RevengePlan revengePlan);
    public void deleteRevengePlan(RevengePlan revengePlan);

}
