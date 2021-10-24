package com.deliverysaurus.product.domain;

import com.deliverysaurus.domain.BaseEntity;
import com.deliverysaurus.domain.Price;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {
    @Embedded
    private Name name;

    @Embedded
    private Description description;

    @Embedded
    private Price price;

    @OneToOne(fetch = FetchType.LAZY)
    private ProductOptionGroup productOptionGroup;

    public Product(Name name, Description description, Price price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void addOptionGroup(OptionGroup optionGroup) {
        initializeProductOptionGroupLazily();
        productOptionGroup.addOptionGroup(optionGroup);
    }

    public void addOptionGroups(Set<OptionGroup> optionGroups) {
        initializeProductOptionGroupLazily();
        productOptionGroup.addOptionGroups(optionGroups);
    }

    public void removeOptionGroup(OptionGroup optionGroup) {
        initializeProductOptionGroupLazily();
        productOptionGroup.removeOptionGroup(optionGroup);
    }

    public void removeOptionGroups(Set<OptionGroup> optionGroups) {
        initializeProductOptionGroupLazily();
        productOptionGroup.removeOptionGroups(optionGroups);
    }

    private void initializeProductOptionGroupLazily() {
        if(productOptionGroup == null) {
            productOptionGroup = new ProductOptionGroup();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, price);
    }
}
