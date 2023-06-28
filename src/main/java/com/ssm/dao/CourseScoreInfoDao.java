//package com.ssm.dao;
//
//import com.ssm.dao.provider.CourseScoreInfoDynaSqlProvider;
//import com.ssm.pojo.CourseScoreInfo;
//import org.apache.ibatis.annotations.*;
//import org.apache.ibatis.mapping.FetchType;
//
//import java.util.List;
//import java.util.Map;
//
//public interface CourseScoreInfoDao {
//
//    //根据条件查询成绩总数
//    //    @Select("select count(*) from courseScore")
//    @SelectProvider(type = CourseScoreInfoDynaSqlProvider.class,method ="count")
//    Integer count(Map<String, Object> params);
//
//    //分页获取成绩列表
//    @Results({@Result(id = true,column = "sno",property = "sno"),
//            @Result(column = "sname",property = "sname"),
//            @Result(column = "password",property = "password"),
//            @Result(column = "sex",property = "sex"),
//            @Result(column = "phone",property = "phone"),
//            @Result(column = "email",property = "email"),
//            @Result(column = "address",property ="address"),
//            @Result(column = "acquireStatus",property = "acquireStatus"),
//            @Result(column = "checkStatus",property = "checkStatus"),
//            @Result(column = "checkTime",property = "checkTime"),
//            @Result(column = "dorm_id",property = "dormInfo",
//                    one=@One(select = "com.ssm.dao.DormInfoDao.selectById", fetchType = FetchType.EAGER)),
//            @Result(column = "idcard",property = "idcard"),
//            @Result(column = "dep_id",property ="departmentInfo",
//                    one = @One(select = "com.ssm.dao.DepartmentInfoDao.selectById", fetchType = FetchType.EAGER))
//    })
//    @SelectProvider(type = CourseScoreInfoDynaSqlProvider.class,method="selectWithParam")
//    List<CourseScoreInfo> selectByPage(Map<String,Object> params);
//
//    //添加成绩
//    @Insert("insert into courseScore(sno,sname,password,sex,dep_id) values(#{sno},#{sname},#{password},#{sex},#{departmentInfo.id})")
//    int addCourseScore(CourseScoreInfo courseScoreInfo);
//
//    //删除成绩
//    @Delete("delete from courseScore where sno in (${sno})")
//    int deleteCourseScore(@Param("sno") String sno);
//
//    //更新成绩
//    @UpdateProvider(type = CourseScoreInfoDynaSqlProvider.class,method = "updateWithParam")
//    int updateCourseScore(CourseScoreInfo courseScoreInfo);
//
//    //获取所有成绩列表
//    @Results({@Result(id = true,column = "sno",property = "sno"),
//            @Result(column = "sname",property = "sname"),
//            @Result(column = "password",property = "password"),
//            @Result(column = "sex",property = "sex"),
//            @Result(column = "phone",property = "phone"),
//            @Result(column = "email",property = "email"),
//            @Result(column = "address",property ="address"),
//            @Result(column = "acquireStatus",property = "acquireStatus"),
//            @Result(column = "checkStatus",property = "checkStatus"),
//            @Result(column = "checkTime",property = "checkTime"),
//            @Result(column = "dorm_id",property = "dormInfo",
//                    one=@One(select = "com.ssm.dao.DormInfoDao.selectById", fetchType = FetchType.EAGER)),
//            @Result(column = "idcard",property = "idcard"),
//            @Result(column = "dep_id",property ="departmentInfo",
//                    one = @One(select = "com.ssm.dao.DepartmentInfoDao.selectById", fetchType = FetchType.EAGER))
//    })
//    @Select("select * from courseScore")
//    List<CourseScoreInfo> getAllCourseScore();
//
//
//
//    @Results({@Result(id = true,column = "sno",property = "sno"),
//            @Result(column = "sname",property = "sname"),
//            @Result(column = "password",property = "password"),
//            @Result(column = "sex",property = "sex"),
//            @Result(column = "phone",property = "phone"),
//            @Result(column = "email",property = "email"),
//            @Result(column = "address",property ="address"),
//            @Result(column = "acquireStatus",property = "acquireStatus"),
//            @Result(column = "checkStatus",property = "checkStatus"),
//            @Result(column = "checkTime",property = "checkTime"),
//            @Result(column = "dorm_id",property = "dormInfo",
//                    one=@One(select = "com.ssm.dao.DormInfoDao.selectById", fetchType = FetchType.EAGER)),
//            @Result(column = "idcard",property = "idcard"),
//            @Result(column = "dep_id",property ="departmentInfo",
//                    one = @One(select = "com.ssm.dao.DepartmentInfoDao.selectById", fetchType = FetchType.EAGER))
//    })
//    @Select("select * from courseScore where sno=#{sno}")
//    CourseScoreInfo getCourseScore(CourseScoreInfo courseScoreInfo);
//}
