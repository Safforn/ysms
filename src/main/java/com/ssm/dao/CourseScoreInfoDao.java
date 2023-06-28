package com.ssm.dao;

import com.ssm.dao.provider.CourseScoreInfoDynaSqlProvider;
import com.ssm.pojo.CourseInfo;
import com.ssm.pojo.CourseScoreInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface CourseScoreInfoDao {

    //根据条件查询成绩总数
    //    @Select("select count(*) from courseScore")
    @SelectProvider(type = CourseScoreInfoDynaSqlProvider.class,method ="count")
    Integer count(Map<String, Object> params);

    //分页获取成绩列表
    @Results({@Result(id = true,column = "sid",property = "sid"),
            @Result(column = "sno",property = "studentInfo",
                    one=@One(select = "com.ssm.dao.StudentInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "cid",property = "courseInfo",
                    one=@One(select = "com.ssm.dao.CourseInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "credit",property = "credit"),
            @Result(column = "score",property = "score")
    })
    @SelectProvider(type = CourseScoreInfoDynaSqlProvider.class,method="selectWithParam")
    List<CourseScoreInfo> selectByPage(Map<String,Object> params);

    //添加成绩
    @Insert("insert into courseScore(sid,sno,cid,credit,score) values(#{sid},#{studentInfo.sno},#{courseInfo.cid},#{credit},#{score})")
    int addCourseScore(CourseScoreInfo courseScoreInfo);

    //删除成绩
    @Delete("delete from courseScore where sid in (${sid})")
    int deleteCourseScore(@Param("sid") String sid);

    //更新成绩
    @UpdateProvider(type = CourseScoreInfoDynaSqlProvider.class,method = "updateWithParam")
    int updateCourseScore(CourseScoreInfo courseScoreInfo);

    //获取所有成绩列表
    @Results({@Result(id = true,column = "sid",property = "sid"),
            @Result(column = "sno",property = "studentInfo",
                    one=@One(select = "com.ssm.dao.StudentInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "cid",property = "courseInfo",
                    one=@One(select = "com.ssm.dao.CourseInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "credit",property = "credit"),
            @Result(column = "score",property = "score")
    })
    @Select("select * from courseScore")
    List<CourseScoreInfo> getAllCourseScore();

    @Results({@Result(id = true,column = "sid",property = "sid"),
            @Result(column = "sno",property = "studentInfo",
                    one=@One(select = "com.ssm.dao.StudentInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "cid",property = "courseInfo",
                    one=@One(select = "com.ssm.dao.CourseInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "credit",property = "credit"),
            @Result(column = "score",property = "score")
    })
    @Select("select * from courseScore where sid=#{sid}")
    CourseScoreInfo selectById(CourseScoreInfo courseScoreInfo);

    @Results({@Result(id = true,column = "sid",property = "sid"),
            @Result(column = "sno",property = "studentInfo",
                    one=@One(select = "com.ssm.dao.StudentInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "cid",property = "courseInfo",
                    one=@One(select = "com.ssm.dao.CourseInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "credit",property = "credit"),
            @Result(column = "score",property = "score")
    })
    @Select("select * from courseScore where sno=#{studentInfo.sno}")
    List<CourseScoreInfo> selectBySno(CourseScoreInfo courseScoreInfo);


    @Select("SELECT sid, sno, c.cid, credit, score FROM course c " +
            "JOIN courseScore ON c.cid = courseScore.cid " +
            "JOIN teacher t ON c.tno = t.tno WHERE t.tno = #{tno};")
    List<CourseScoreInfo> selectScoreBySno(@Param("tno") String tno);

//    @UpdateProvider(type = CourseScoreInfoDynaSqlProvider.class,method = "selectScore")
//    List<CourseScoreInfo> selectScore(CourseScoreInfo courseScoreInfo);

//    @UpdateProvider(type = CourseScoreInfoDynaSqlProvider.class, method = "selectScoreByTnoAndSid")
//    List<CourseScoreInfo> selectScoreByTnoAndSid(@Param("tno") String tno,
//                                                 @Param("sid") String sid,
//                                                 @Param("sno") String sno,
//                                                 @Param("cid") String cid,
//                                                 @Param("credit") String credit,
//                                                 @Param("score") String score);
}
