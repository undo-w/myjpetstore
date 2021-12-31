package org.csu.mypetstore.persistence;
import org.csu.mypetstore.domain.Daily;

import java.util.List;

public interface DailyDAO {
    void insertDaily(Daily daily);

    List<Daily> getDailyListByUserId(String userid);


}
