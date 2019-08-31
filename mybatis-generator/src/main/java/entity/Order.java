package entity;

import java.util.Date;
import lombok.Data;

@Data
public class Order {
    private Integer id;

    private String orderName;

    private Boolean isShow;

    private Boolean isSplit;

    private Integer number;

    private Date createTime;

    private Integer orderType_id;
}