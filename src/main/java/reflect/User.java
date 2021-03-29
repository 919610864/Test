package reflect;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class User<T> implements Serializable {

    private Long id;

    private String name;

    private int age;

    private Date createTime;

    private T t;
}
