package com.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnReviewDTO {

    private String productId;
    private String profileName;
    private String helpfulness;
    private String summary;

}
