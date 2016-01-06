package uk.co.sammy.classes;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by smlif on 06/01/2016.
 */
public class FakeSqlAddress extends SqlAddress{

    public JdbcTemplate getTemplate(){
        return getJdbcTemplate();
    }
}
