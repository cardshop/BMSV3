/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gamersrepublic.services.impl;

import com.gamersrepublic.config.ConnectionConfig;
import com.gamersrepublic.domain.Decoration;
import com.gamersrepublic.domain.InkCardridge;
import com.gamersrepublic.domain.Paper;
import com.gamersrepublic.repository.DecorationRepository;
import com.gamersrepublic.repository.InkRepository;
import com.gamersrepublic.repository.PaperRepository;
import com.gamersrepublic.services.InventoryService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Luke
 */
public class InventoryServiceImpl implements InventoryService{
    private final ApplicationContext ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    private PaperRepository paperRepo;
    private DecorationRepository decorationRepo;
    private InkRepository inkRepo;
            
    @Override
    public Object addInventory(Map model) {
        if(model.get("type").toString().equals("Paper")){
            paperRepo = ctx.getBean(PaperRepository.class);
            Paper paper = new Paper.Builder(model.get("type").toString())
                    .grammage(model.get("grammage").toString())
                    .inventory(Integer.parseInt(model.get("inventory").toString()))
                    .price(Double.parseDouble(model.get("price").toString()))
                    .size(model.get("size").toString())
                    .colour(model.get("colour").toString())
                    .build();
            
            paperRepo.save(paper);
            
            return paperRepo.getOne(paper.getId());
        }
        else if(model.get("type").toString().equals("Decorations")){
            decorationRepo = ctx.getBean(DecorationRepository.class);
            Decoration decoration = new Decoration.Builder(model.get("type").toString())
                    .inventory(Integer.parseInt(model.get("inventory").toString()))
                    .price(Double.parseDouble(model.get("price").toString()))
                    .decSize(model.get("size").toString())
                    .colour(model.get("colour").toString())
                    .build();
            
            decorationRepo.save(decoration);
            
            return decorationRepo.getOne(decoration.getId());
        }
        else if(model.get("type").toString().equals("Ink")){
            inkRepo = ctx.getBean(InkRepository.class);
            InkCardridge inkCardridge = new InkCardridge.Builder(model.get("type").toString())
                    .inventory(Integer.parseInt(model.get("inventory").toString()))
                    .price(Double.parseDouble(model.get("price").toString()))
                    .colour(model.get("colour").toString())
                    .build();
            
            inkRepo.save(inkCardridge);
            
            return inkRepo.getOne(inkCardridge.getId());
        }
        else{
            return null;
        }
    }

    @Override
    public Object updateInventory(Map model) {
        if(model.get("type").toString().equals("Paper")){
            paperRepo = ctx.getBean(PaperRepository.class);
            
            Paper paperOld = paperRepo.findOne((Long)model.get("id"));
            
            Paper paper = new Paper.Builder(model.get("type").toString())
                    .clone(paperOld)
                    .grammage(model.get("grammage").toString())
                    .inventory(Integer.parseInt(model.get("inventory").toString()))
                    .price(Double.parseDouble(model.get("price").toString()))
                    .size(model.get("size").toString())
                    .colour(model.get("colour").toString())
                    .build();
            
            paperRepo.save(paper);
            
            return paperRepo.getOne(paper.getId());
        }
        else if(model.get("type").toString().equals("Decorations")){
            decorationRepo = ctx.getBean(DecorationRepository.class);
            
            Decoration decorationOld = decorationRepo.findOne((Long)model.get("id"));
            
            Decoration decoration = new Decoration.Builder(model.get("type").toString())
                    .clone(decorationOld)
                    .inventory(Integer.parseInt(model.get("inventory").toString()))
                    .price(Double.parseDouble(model.get("price").toString()))
                    .decSize(model.get("size").toString())
                    .colour(model.get("colour").toString())
                    .build();
            
            decorationRepo.save(decoration);
            
            return decorationRepo.getOne(decoration.getId());
        }
        else if(model.get("type").toString().equals("Ink")){
            inkRepo = ctx.getBean(InkRepository.class);
            
            InkCardridge inkCardridgeOld = inkRepo.findOne((Long)model.get("id"));
            
            InkCardridge inkCardridge = new InkCardridge.Builder(model.get("type").toString())
                    .clone(inkCardridgeOld)
                    .inventory(Integer.parseInt(model.get("inventory").toString()))
                    .price(Double.parseDouble(model.get("price").toString()))
                    .colour(model.get("colour").toString())
                    .build();
            
            inkRepo.save(inkCardridge);
            
            return inkRepo.getOne(inkCardridge.getId());
        }
        else{
            return null;
        }
    }

    @Override
    public List<Object> populateInventoryList() {
        paperRepo = ctx.getBean(PaperRepository.class);
        decorationRepo = ctx.getBean(DecorationRepository.class);
        inkRepo = ctx.getBean(InkRepository.class);
        List<Object> masterList = new ArrayList();
        List<Paper> paperList = paperRepo.findAll();
        List<Decoration> decorationList = decorationRepo.findAll();
        List<InkCardridge> inkList = inkRepo.findAll();
        
        for(Paper page : paperList){
            masterList.add(page);
        }
        
        for(Decoration decoration : decorationList){
            masterList.add(decoration);
        }
        
        for(InkCardridge ink : inkList){
            masterList.add(ink);
        }
        
        return masterList;
    }

    @Override
    public boolean deleteInventory(Map model) {
        if(model.get("type").toString().equals("Paper")){
            paperRepo = ctx.getBean(PaperRepository.class);
            Paper paper = paperRepo.findOne((Long)model.get("id"));
            paperRepo.delete(paper);

            Paper deleted = paperRepo.findOne((Long)model.get("id"));

            if (deleted != null)
                return true;
            else
                return false;
        }
        else if(model.get("type").toString().equals("Decorations")){
            decorationRepo = ctx.getBean(DecorationRepository.class);
            Decoration decoration = decorationRepo.findOne((Long)model.get("id"));
            decorationRepo.delete(decoration);

            Decoration deleted = decorationRepo.findOne((Long)model.get("id"));

            if (deleted != null)
                return true;
            else
                return false;
        }
        else if(model.get("type").toString().equals("Ink")){
            inkRepo = ctx.getBean(InkRepository.class);
            InkCardridge inkCardridge = inkRepo.findOne((Long)model.get("id"));
            inkRepo.delete(inkCardridge);

            InkCardridge deleted = inkRepo.findOne((Long)model.get("id"));

            if (deleted != null)
                return true;
            else
                return false;
        }
        else{
            return false;
        }
    }
    
}
