package entity;

import java.util.Date;
import lombok.Data;

@Data
public class Ordertype {
    private Integer id;

    private String orderTypeName;

    private Integer number;

    private Date createTime;

    private Boolean isShow;
}