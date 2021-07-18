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
package myself.test.use;

import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseTest extends BaseDataTest {

  SqlSessionFactory sqlSessionFactory = null;

  @Before
  public void before() throws IOException {
    URL resource = UseTest.class.getResource("/resources/mybatis-config.xml");
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource.openStream());
  }

  @Test
  public void select()throws Exception{
    SqlSession sqlSession = sqlSessionFactory.openSession();
    Map param = new HashMap();
    param.put("scheduleName","SCHEDULE_DAKA");
    List<Object> objects = sqlSession.selectList("myself.test.use.UseMapper.select", "SCHEDULE_DAKA");
    List<Object> objects2 = sqlSession.selectList("myself.test.use.UseMapper.select", "SCHEDULE_DAKA");
    System.out.println(objects == objects2);
    System.out.println(objects);
  }
}
