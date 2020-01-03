package com.fred.microstage.service.goods.request;


import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsFindRequest implements Serializable {

    private static final long serialVersionUID = -1292908802923838211L;

    private Long userId;

    private String name;
}
