package uk.co.sammy.classes;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Created by smlif on 06/01/2016.
 */
public class SqlAddress extends JdbcDaoSupport {

    private String INSERT_SQL;
    private String UPDATE_SQL;

    public void batchInsertOrUpdate(List<AddressDTO> addressList, User users){
        List<AddressDTO> insertList = buildListWhereLastChangeTimeMissing(addressList);

        List<AddressDTO> updateList = buildListWhereLastChangeTimeValued(addressList);

        int rowCount[] = new int[4];

        if(!insertList.isEmpty()){
            rowCount = getJdbcTemplate().batchUpdate(INSERT_SQL);
        }

        /*if(!updateList.isEmpty()){
            rowCount += getJdbcTemplate().batchUpdate(UPDATE_SQL);
        }

        if(addressList.size() != rowCount){
            raiseErrorForDataInconsistency();
        }*/
    }

    //private void raiseErrorForDataInconsistency() {}

    private List<AddressDTO> buildListWhereLastChangeTimeValued(List<AddressDTO> addressList) {
        return addressList;
    }

    private List<AddressDTO> buildListWhereLastChangeTimeMissing(List<AddressDTO> addressList) {
        return addressList;
    }
}
