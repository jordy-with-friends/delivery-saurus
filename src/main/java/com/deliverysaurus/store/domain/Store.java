package com.deliverysaurus.store.domain;

import com.deliverysaurus.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Store extends BaseEntity {
    @Embedded
    private Name name;

    @Embedded
    private Address address;
}
