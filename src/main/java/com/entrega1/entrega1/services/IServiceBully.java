package com.entrega1.entrega1.services;

import com.entrega1.entrega1.dto.BullyDTO;
import com.entrega1.entrega1.models.Bully;

import java.util.List;

public interface IServiceBully {
    public List<BullyDTO> getBullyList();
    public void addBully(BullyDTO bully);
    public Bully updateBully(BullyDTO bully);
    public void deleteBully(int id);
    public List<BullyDTO> getBullyListByCliqueId(int id);
}
