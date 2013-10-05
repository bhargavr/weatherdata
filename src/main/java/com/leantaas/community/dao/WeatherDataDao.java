package com.leantaas.community.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.Session;

import com.leantaas.community.util.HibernateUtil;
import com.leantaas.community.vo.WeatherDataVO;
import com.leantaas.community.vo.WeatherMetaDataVO;

/**
 * @author Bhargav
 */
public class WeatherDataDao {

    public synchronized void saveDataContent(ArrayList<String[]> contentInfo, String idNo) {

        Session session = HibernateUtil.getContentSessionFactory().openSession();

        session.beginTransaction();

        for (String[] row : contentInfo) {
            WeatherDataVO contentObj = new WeatherDataVO();
            
            if(row.length==6){
            contentObj.setMpGroup(row[0]);
            contentObj.setTestName((row[1]==null)? "": row[1]);
            contentObj.setDataType(row[2]);
            contentObj.setResultValue(row[3]);
            contentObj.setStatus(row[4]);
            if (row[5] != null)
                contentObj.setTime(Integer.parseInt(row[5]));

            }
            
            if(row.length==7){
                contentObj.setComment(row[6]);
            }

            contentObj.setIdNo(idNo);
            session.save(contentObj);
        }
        session.getTransaction().commit();
        HibernateUtil.shutdownContent();

    }

}
