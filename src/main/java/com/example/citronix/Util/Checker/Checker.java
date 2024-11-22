package com.example.citronix.Util.Checker;

import com.example.citronix.Entity.Enums.TreeStatus;
import com.example.citronix.Entity.Field;
import com.example.citronix.Entity.Harvest;
import com.example.citronix.Entity.Tree;
import com.example.citronix.Repository.TreeRepository;

import java.time.Month;
import java.util.List;

public class Checker {
    public boolean fieldCheck(Field field) {
        if (field.getArea() <= 1000) {
            throw new RuntimeException("The area of the field must be at least 0.1 hectares (1000 m²).");
        }

        if (field.getArea() >= (field.getFarm().getArea() * 0.5)) {
            throw new RuntimeException("The area of the field exceeds 50% of the total farm area.");
        }

        if (field.getFarm().getFields().size() >= 10) {
            throw new RuntimeException("The farm cannot have more than 10 fields.");
        }

        Integer leftArea = field.getFarm().getArea()
                - field.getFarm().getFields().stream()
                .map(Field::getArea)
                .reduce(0, Integer::sum);

        if (field.getArea() > leftArea) {
            throw new RuntimeException("The field area exceeds the remaining area available in the farm.");
        }

        return true;
    }

    public boolean treeCheck(Tree tree){

        List<Tree>trees= tree.getField().getTrees();

        if (trees.isEmpty()){
            if (tree.getNumber()>(tree.getField().getArea()/10)){
                throw new RuntimeException("you exceeded what you can farm in that field");
            }
        }else {
            Integer remainingArea=tree.getField().getArea()-(trees.stream()
                    .map(Tree::getNumber)
                    .map(e->e*2)
                    .reduce(0,Integer::sum));
            if (tree.getNumber()*10>remainingArea){
                throw new RuntimeException("the number of trees you entered far exceeded the size of the area left in that field");
            }
        }
        if (tree.getAge()>20){
            tree.setStatus(TreeStatus.UNPRODUCTIVE);
            tree.setProductivityRate(0.0);
        }
        int month=tree.getPlantingDate().getMonthValue();
        if (month<3 || month>5){
            throw new RuntimeException("Trees can only be planted between March and May.");
        }


        return true;
    }


}
