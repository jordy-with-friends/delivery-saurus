package com.deliverysaurus.product.domain;

import com.deliverysaurus.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class ProductOptionGroup extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    private Product product;

    @OneToMany
    private Set<OptionGroup> optionGroups = new HashSet<>();

    public ProductOptionGroup(Product product) {
        this.product = product;
    }

    public ProductOptionGroup(Product product, Set<OptionGroup> optionGroups) {
        this.product = product;
        this.optionGroups = optionGroups;
    }

    public void addOptionGroup(OptionGroup optionGroup) {
        if(this.optionGroups.contains(optionGroup)) {
            throw new IllegalArgumentException("이미 존재하는 옵션 그룹 입니다.");
        }
        this.optionGroups.add(optionGroup);
    }

    public void addOptionGroups(Set<OptionGroup> optionGroups) {
        optionGroups.stream()
                .filter((optionGroup -> this.optionGroups.contains(optionGroup)))
                .findFirst()
                .ifPresent((optionGroup) -> {
                    throw new IllegalArgumentException("이미 존재하는 옵션 그룹 입니다.");
                });
        this.optionGroups.addAll(optionGroups);
    }

    public void removeOptionGroup(OptionGroup optionGroup) {
        if(!this.optionGroups.contains(optionGroup)) {
            throw new IllegalArgumentException("존재하지 않는 옵션 그룹 입니다.");
        }
        this.optionGroups.remove(optionGroup);
    }
    public void removeOptionGroups(Set<OptionGroup> optionGroups) {
        int foundOptionGroupsCount = (int) optionGroups.stream()
                .filter((optionGroup -> this.optionGroups.contains(optionGroup)))
                .count();

        if(foundOptionGroupsCount != optionGroups.size()) {
            throw new IllegalArgumentException("존재하지 않는 옵션 그룹 입니다.");
        }
        this.optionGroups.removeAll(optionGroups);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductOptionGroup that = (ProductOptionGroup) o;
        return Objects.equals(product, that.product) && Objects.equals(optionGroups, that.optionGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), product, optionGroups);
    }
}
