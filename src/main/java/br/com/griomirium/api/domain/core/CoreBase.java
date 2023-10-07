package br.com.griomirium.api.domain.core;


import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="core_base")
@Table(name="core_base")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CoreBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private int buildings;
    private int units;
    private int gold;

    private double exp;

    @Column(name="base_level")
    private int baseLevel;
    private int food;

    @Column(name="core_element_type")
    @Enumerated(EnumType.STRING)
    private CoreElementType coreElementType;

    private boolean active;
    public CoreBase(CoreRecord coreRecord){
        this.name = coreRecord.name();
        this.coreElementType = coreRecord.coreElementType();
        this.food = coreRecord.food();
        this.gold = coreRecord.gold();
        this.baseLevel = 1;
        this.active = true;
    }

    public void updateExp(){
        this.exp += (this.buildings * 2) + (this.units);
    }

    public void consumeFood(){
        this.food -= this.units * 2;
    }

    public void produceResources(){
        this.gold += this.units * (2 + Math.round(baseLevel/2));
        this.food += (buildings + baseLevel) * 2;
    }

    public void updateData(UpdateCoreBase updateCoreBase) {
        if(updateCoreBase.name() != null){
            this.name = updateCoreBase.name();
        }

        if(updateCoreBase.gold() != this.gold && updateCoreBase.gold() >0)
            this.gold = updateCoreBase.gold();
        if(updateCoreBase.food() != this.gold && updateCoreBase.food() >0)
            this.food = updateCoreBase.food();
        if(updateCoreBase.units() != this.units && updateCoreBase.units() >0)
            this.units = updateCoreBase.units();
        if(updateCoreBase.buildings() != this.buildings && updateCoreBase.buildings() >0)
            this.buildings = updateCoreBase.buildings();

    }

    public void deactivate() {
        this.active = false;
    }
}
