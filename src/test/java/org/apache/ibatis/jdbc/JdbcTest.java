/**
 *    Copyright 2009-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.jdbc;

import com.mysql.cj.result.Field;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTest {

  String driverClass = "com.mysql.cj.jdbc.Driver";
  String url = "jdbc:mysql://47.107.188.218:3306/analysis?setUnicode=true&characterEncoding=utf8";
  String userName = "root";
  String password = "Skylbp@@123!";

  @Test
  public void test()throws Exception{
    Class clazz = Class.forName(driverClass);
    Connection connection = DriverManager.getConnection(url,userName,password);
    PreparedStatement ps = connection.prepareStatement("select * from schedule");
    boolean ret = ps.execute();
    if(ret){
      ResultSet resultSet = ps.getResultSet();
      ResultSetMetaData metaData = ps.getMetaData();
      System.out.println(111);
      List<Map> resultList = new ArrayList<>();
      while(resultSet.next()){
        Map<String,Object> map = new HashMap<String,Object>();
        int count = metaData.getColumnCount();
        int i = 1;
        while(i<=count){
          String columnName = metaData.getColumnName(i);
          int columnType = metaData.getColumnType(i);
          map.put(columnName,resultSet.getObject(i));
          i++;
        }
        resultList.add(map);
      }
      System.out.println(resultList);
    }
  }
}

class ResultSetMetaDataWrapper{
  private ResultSetMetaData resultSetMetaData;

  public ResultSetMetaDataWrapper(ResultSetMetaData resultSetMetaData) {
    this.resultSetMetaData = resultSetMetaData;
  }

}
