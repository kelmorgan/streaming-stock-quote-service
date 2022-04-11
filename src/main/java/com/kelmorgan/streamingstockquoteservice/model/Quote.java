package com.kelmorgan.streamingstockquoteservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.MathContext;

@Data
@NoArgsConstructor
public class Quote {

    private static final MathContext MATH_CONTEXT = new MathContext(2);
}
