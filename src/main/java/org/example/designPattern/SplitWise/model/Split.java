package org.example.designPattern.SplitWise.model;

/*
    Get from request - UI
    User1 - ows X Rupees
 */

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Split {
    User user;
    int amountOwed;
}
