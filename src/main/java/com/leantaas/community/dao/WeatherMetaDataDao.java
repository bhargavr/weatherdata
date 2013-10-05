package com.leantaas.community.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.hibernate.Session;

import com.leantaas.community.constants.WeatherDataConstants;
import com.leantaas.community.util.HibernateUtil;
import com.leantaas.community.vo.WeatherMetaDataVO;

/**
 * @author Bhargav
 */
public class WeatherMetaDataDao {

    public synchronized void saveDataHeader(HashMap<String,String> headerInfo){
        
        Session session = HibernateUtil.getHeaderSessionFactory().openSession();
        
        session.beginTransaction();
        WeatherMetaDataVO headerObj = new WeatherMetaDataVO();
        headerObj.setAreaId(headerInfo.get(WeatherDataConstants.AREA_ID));
        
        if(headerInfo.get(WeatherDataConstants.FIXTURE_POSITION) != null)
            headerObj.setFixturePosition(Integer.parseInt(headerInfo.get(WeatherDataConstants.FIXTURE_POSITION)));
        
        headerObj.setId_no(headerInfo.get(WeatherDataConstants.ID_NO));
        headerObj.setInstrumentIds(headerInfo.get(WeatherDataConstants.INSTRUMENT_IDS));
        headerObj.setLineId(headerInfo.get(WeatherDataConstants.LINE_ID));
        headerObj.setMark(headerInfo.get(WeatherDataConstants.MARK));
        headerObj.setOnline(headerInfo.get(WeatherDataConstants.ONLINE));
        headerObj.setOperator(headerInfo.get(WeatherDataConstants.OPERATOR));
        headerObj.setProduct(headerInfo.get(WeatherDataConstants.PRODUCT));
        headerObj.setProductRState(headerInfo.get(WeatherDataConstants.PRODUCT_RSTATE));
        
        if(headerInfo.get(WeatherDataConstants.RECORD_TYPE) != null)
            headerObj.setRecordType(Integer.parseInt(headerInfo.get(WeatherDataConstants.RECORD_TYPE)));
        
        headerObj.setSecurityCode(headerInfo.get(WeatherDataConstants.SECURITY_CODE));
        headerObj.setSsn(headerInfo.get(WeatherDataConstants.SSN));
        headerObj.setStationId(headerInfo.get(WeatherDataConstants.STATION_ID));
        headerObj.setStatus(headerInfo.get(WeatherDataConstants.STATUS));
        
        if(headerInfo.get(WeatherDataConstants.TEST_CATEGORY) != null)
            headerObj.setTestCategory(Integer.parseInt(headerInfo.get(WeatherDataConstants.TEST_CATEGORY)));
        
        headerObj.setTestCriteria(headerInfo.get(WeatherDataConstants.TEST_CRITERIA));
        headerObj.setTestCriteriaRev(headerInfo.get(WeatherDataConstants.TEST_CRITERIA_REV));
        
        if(headerInfo.get(WeatherDataConstants.TEST_POSITION) != null)
            headerObj.setTestPosition(Integer.parseInt(headerInfo.get(WeatherDataConstants.TEST_POSITION)));
        
        headerObj.setTestProgram(headerInfo.get(WeatherDataConstants.TEST_PROGRAM));
        headerObj.setTestProgramRState(headerInfo.get(WeatherDataConstants.TEST_PROGRAM_RSTATE));
        if(headerInfo.get(WeatherDataConstants.TIME_INTERACTIVE) != null)
            headerObj.setTimeInteractive(Integer.parseInt(headerInfo.get(WeatherDataConstants.TIME_INTERACTIVE)));
        
        if(headerInfo.get(WeatherDataConstants.TIME_START) != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            try {
                headerObj.setTimeStart(sdf.parse(headerInfo.get(WeatherDataConstants.TIME_START)));
            } catch (ParseException e) {
                System.err.println(e.getMessage());
            }
        }
        if(headerInfo.get(WeatherDataConstants.TIME_TOTAL) != null)
            headerObj.setTimeTotal(Integer.parseInt(headerInfo.get(WeatherDataConstants.TIME_TOTAL)));
        
        if(headerInfo.get(WeatherDataConstants.TYPE_NUMBER) != null)
            headerObj.setTypeNumber(Integer.parseInt(headerInfo.get(WeatherDataConstants.TYPE_NUMBER)));
        
        headerObj.setFileName(headerInfo.get(WeatherDataConstants.FILE_NAME));
        
        session.save(headerObj);
        session.getTransaction().commit();
        HibernateUtil.shutdownHeader();
    }

}
