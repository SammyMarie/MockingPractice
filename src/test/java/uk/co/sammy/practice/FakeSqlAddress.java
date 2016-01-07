package uk.co.sammy.practice;

import org.springframework.jdbc.core.JdbcTemplate;
import uk.co.sammy.practice.SqlAddress;

/**
 * Created by smlif on 06/01/2016.
 */
public class FakeSqlAddress extends SqlAddress {

    public JdbcTemplate getTemplate(){
        return getJdbcTemplate();
    }
}
