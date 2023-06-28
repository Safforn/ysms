//package com.ssm.dao;
//
//import com.ssm.dao.provider.AskForLeaveInfoDynaSqlProvider;
//import com.ssm.pojo.AskForLeaveInfo;
//import org.apache.ibatis.annotations.*;
//import org.apache.ibatis.mapping.FetchType;
//
//import java.util.List;
//import java.util.Map;
//
//public interface AskForLeaveInfoDao {
//
//    //请假登录验证
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
//    @Select("select * from askForLeave where sno=#{sno} and password=#{password}")
//    AskForLeaveInfo login(AskForLeaveInfo stu);
//
//
//    //根据条件查询请假总数
//    //    @Select("select count(*) from askForLeave")
//    @SelectProvider(type = AskForLeaveInfoDynaSqlProvider.class,method ="count")
//    Integer count(Map<String, Object> params);
//
//    //分页获取请假列表
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
//    @SelectProvider(type = AskForLeaveInfoDynaSqlProvider.class,method="selectWithParam")
//    List<AskForLeaveInfo> selectByPage(Map<String,Object> params);
//
//    //添加请假
//    @Insert("insert into askForLeave(sno,sname,password,sex,dep_id) values(#{sno},#{sname},#{password},#{sex},#{departmentInfo.id})")
//    int addAskForLeave(AskForLeaveInfo askForLeaveInfo);
//
//    //删除请假
//    @Delete("delete from askForLeave where sno in (${sno})")
//    int deleteAskForLeave(@Param("sno") String sno);
//
//    //更新请假
//    @UpdateProvider(type = AskForLeaveInfoDynaSqlProvider.class,method = "updateWithParam")
//    int updateAskForLeave(AskForLeaveInfo askForLeaveInfo);
//
//    //获取所有请假列表
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
//    @Select("select * from askForLeave")
//    List<AskForLeaveInfo> getAllAskForLeave();
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
//    @Select("select * from askForLeave where sno=#{sno}")
//    AskForLeaveInfo getAskForLeave(AskForLeaveInfo askForLeaveInfo);
//
//
//    //修改密码
//    @Update("update askForLeave set password=#{password} where sno=#{sno}")
//    int changePassword(AskForLeaveInfo askForLeaveInfo);
//}
