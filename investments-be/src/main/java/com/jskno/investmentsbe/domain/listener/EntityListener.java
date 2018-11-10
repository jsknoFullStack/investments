package com.jskno.investmentsbe.domain.listener;

import com.jskno.investmentsbe.domain.base.AbstractEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class EntityListener {

    @PrePersist
    public void onCreate(AbstractEntity entity) {
        //final String currentUser = SecurityContextHolder.getContext().getAuthentication().
        //                                      getName();
        final String currentUser = "SYSTEM";
        final Date currentDate = new Date();
        entity.setCreatedBy(currentUser);
        entity.setCreatedAt(currentDate);
    }

    @PreUpdate
    public void onUpdate(AbstractEntity entity) {
        final String currentUser = "SYSTEM";
        final Date currentDate = new Date();
        entity.setUpdatedBy(currentUser);
        entity.setUpdatedAt(currentDate);
    }
}
