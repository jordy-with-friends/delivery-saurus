package com.deliverysaurus.product.domain;

import com.deliverysaurus.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static java.lang.String.format;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OptionGroup extends BaseEntity {
    public static final int MIN_OPTIONS_SIZE = 2;

    @Embedded
    private Name name;

    @Enumerated(EnumType.STRING)
    private OptionMethod optionMethod;

    @OneToMany
    private Set<Option> options;

    public OptionGroup(Name name, OptionMethod optionMethod, Set<Option> options) {
        validate(options);

        this.name = name;
        this.optionMethod = optionMethod;
        this.options = options;
    }

    private void validate(Set<Option> options) {
        if(options.size() < MIN_OPTIONS_SIZE) {
            throw new IllegalArgumentException(format("최소 %d개 이상의 옵션이 설정되어야 합니다.", MIN_OPTIONS_SIZE));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OptionGroup that = (OptionGroup) o;
        return Objects.equals(name, that.name) && optionMethod == that.optionMethod && Objects.equals(options, that.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, optionMethod, options);
    }
}
