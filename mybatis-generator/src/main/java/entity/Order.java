package entity;

import java.util.Date;
import lombok.Data;

@Data
public class Order {
    private Integer id;

    private String ordername;

    private Boolean isshow;

    private Boolean issplit;

    private Integer number;

    private Date createtime;

    private Integer ordertypeId;
}