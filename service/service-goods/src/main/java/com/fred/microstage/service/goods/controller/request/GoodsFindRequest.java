package com.fred.microstage.service.goods.controller.request;


import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsFindRequest implements Serializable {

    private static final long serialVersionUID = -1292908802923838211L;

    private String userId;

    private String name;
}
