package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Hotel {

    private String name;
    private Integer rate;
    private Double weekdayRegularTax;
    private Double weekendRegularTax;
    private Double weekdayRewardTax;
    private Double weekendRewardTax;

}
