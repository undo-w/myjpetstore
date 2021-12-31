package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Daily;
import org.csu.mypetstore.persistence.DailyDAO;
import org.csu.mypetstore.persistence.impl.DailyDAOImpl;

import java.util.List;

public class DailyService {
    private DailyDAO dailyDAO;

    public DailyService(){
        dailyDAO = new DailyDAOImpl();
    }

    public void insertDaily(Daily daily){
        dailyDAO.insertDaily(daily);
    }

    public List<Daily> getDailyListByUserId(String userId){
        return dailyDAO.getDailyListByUserId(userId);
    }
}
