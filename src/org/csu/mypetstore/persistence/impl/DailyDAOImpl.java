package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Daily;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.DailyDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class DailyDAOImpl implements DailyDAO {
    private static final String INSERT_DAILY="INSERT INTO daily (userid,operationtime,operationtype) VALUES (?,?,?)";
    private  static final String GET_DAILYLIST_BY_USERID="SELECT dailyid,userid,operationtime,operationtype FROM daily WHERE daily.userid = ? ";

    @Override
    public void insertDaily(Daily daily) {
      try {
          Timestamp timestamp=new Timestamp(daily.getDate().getTime());

          Connection connection= DBUtil.getConnection();
          PreparedStatement preparedStatement=connection.prepareStatement(INSERT_DAILY);
          preparedStatement.setString(1,daily.getUserid());
          preparedStatement.setTimestamp(2,timestamp);
          preparedStatement.setString(3,daily.getOperationtype());

          preparedStatement.executeUpdate();

          DBUtil.closePreparedStatement(preparedStatement);
          DBUtil.closeConnection(connection);
      }catch (Exception e){
          e.printStackTrace();
      }

    }

    @Override
    public List<Daily> getDailyListByUserId(String userid) {
     List<Daily> dailyList=new ArrayList<>();
        try {
            Connection connection=DBUtil.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_DAILYLIST_BY_USERID);
            preparedStatement.setString(1,userid);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Daily daily=new Daily();
//                Date date = new Date(resultSet.getDate(3).getTime());

                daily.setDailyid(resultSet.getInt(1));
                daily.setUserid(resultSet.getString(2));
                daily.setDate(resultSet.getTimestamp(3));
                daily.setOperationtype(resultSet.getString(4));

                dailyList.add(daily);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        }catch (Exception e){

        }
        return dailyList;
    }

}
