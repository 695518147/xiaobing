package entity;

import java.util.Date;
import lombok.Data;

@Data
public class OrderType {
    private Integer id;

    private String ordertypename;

    private Integer number;

    private Date createtime;

    private Boolean isshow;
}