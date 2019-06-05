package entity;

import lombok.Data;

@Data
public class OrderWithBLOBs extends Order {
    private String orderdescription;

    private String ordertypedescription;
}