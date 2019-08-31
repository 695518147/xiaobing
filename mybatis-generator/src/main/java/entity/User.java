package entity;

import java.util.Date;
import lombok.Data;

@Data
public class User {
    private String user_id;

    private String user_name;

    private Integer user_age;

    private String email;

    private Date create_time;
}