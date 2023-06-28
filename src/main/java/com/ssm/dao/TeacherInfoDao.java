package com.ssm.dao;

import com.ssm.dao.provider.StudentInfoDynaSqlProvider;
import com.ssm.dao.provider.TeacherInfoDynaSqlProvider;
import com.ssm.pojo.DepartmentInfo;
import com.ssm.pojo.StudentInfo;
import com.ssm.pojo.TeacherInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface TeacherInfoDao {

    //学生登录验证
    @Results({@Result(id = true,column = "tno",property = "tno"),
            @Result(column = "tname",property = "tname"),
            @Result(column = "password",property = "password"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "email",property = "email"),
            @Result(column = "address",property ="address"),
            @Result(column = "idcard",property = "idcard"),
    })
    @Select("select * from teacher where tno=#{tno} and password=#{password}")
    TeacherInfo login(TeacherInfo stu);


    //根据条件查询学生总数
    //    @Select("select count(*) from teacher")
    @SelectProvider(type = TeacherInfoDynaSqlProvider.class,method ="count")
    Integer count(Map<String, Object> params);

    @Results({
            @Result(id = true,column = "tno",property = "tno"),
            @Result(column = "tname",property = "tname")
    })
    @Select("select tno, tname from teacher")
    List<TeacherInfo> getAll();

    //分页获取学生列表
    @Results({
            @Result(id = true,column = "tno",property = "tno"),
            @Result(column = "tname",property = "tname"),
            @Result(column = "password",property = "password"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "email",property = "email"),
            @Result(column = "address",property ="address"),
            @Result(column = "idcard",property = "idcard")
    })
    @SelectProvider(type = TeacherInfoDynaSqlProvider.class,method="selectWithParam")
    List<TeacherInfo> selectByPage(Map<String,Object> params);

    //添加学生
    @Insert("insert into teacher(tno,tname,password,sex,dep_id) values(#{tno},#{tname},#{password},#{sex},#{departmentInfo.id})")
    int addTeacher(TeacherInfo teacherInfo);

    //删除学生
    @Delete("delete from teacher where tno in (${tno})")
    int deleteTeacher(@Param("tno") String tno);

    //更新学生
    @UpdateProvider(type = TeacherInfoDynaSqlProvider.class,method = "updateWithParam")
    int updateTeacher(TeacherInfo teacherInfo);

    //根据条件查询可分配宿舍的学生列表
    @Results({@Result(id = true,column = "tno",property = "tno"),
            @Result(column = "tname",property = "tname"),
            @Result(column = "password",property = "password"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "email",property = "email"),
            @Result(column = "address",property ="address"),
            @Result(column = "idcard",property = "idcard"),
    })
    @SelectProvider(type = TeacherInfoDynaSqlProvider.class,method ="allocationTeacher")
    List<TeacherInfo> allocationTeacher(TeacherInfo teacherInfo);

    //根据宿舍编号查学生
//    @Results({@Result(id = true,column = "tno",property = "tno"),
//            @Result(column = "tname",property = "tname"),
//            @Result(column = "password",property = "password"),
//            @Result(column = "sex",property = "sex"),
//            @Result(column = "phone",property = "phone"),
//            @Result(column = "email",property = "email"),
//            @Result(column = "address",property ="address"),
//            @Result(column = "idcard",property = "idcard"),
//    })
//    @Select("select * from teacher where dorm_id=#{dorm_id}")
//    List<TeacherInfo> selectTeacherById(@Param("dorm_id") String dorm_id);

    @Select("select * from teacher where tno=#{tno}")
    TeacherInfo selectById(@Param("tno") int tno);



    //为学生分配宿舍
    @Update("update teacher set dorm_id=#{dormInfo.id} where tno=#{tno}")
    int updateTeacherDorm(TeacherInfo teacherInfo);


    //根据院系编号查询学生列表
    @Results({@Result(id = true,column = "tno",property = "tno"),
            @Result(column = "tname",property = "tname"),
            @Result(column = "password",property = "password"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "email",property = "email"),
            @Result(column = "address",property ="address"),
            @Result(column = "acquireStatus",property = "acquireStatus"),
            @Result(column = "checkStatus",property = "checkStatus"),
            @Result(column = "checkTime",property = "checkTime"),
            @Result(column = "dorm_id",property = "dormInfo",
                    one=@One(select = "com.ssm.dao.DormInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "idcard",property = "idcard"),
            @Result(column = "dep_id",property ="departmentInfo",
                    one = @One(select = "com.ssm.dao.DepartmentInfoDao.selectById", fetchType = FetchType.EAGER))
    })
    @Select("select * from teacher where dep_id=#{dep_id}")
    List<TeacherInfo> selectTeacherByDepId(@Param("dep_id") int dep_id);


    //获取所有学生列表
    @Results({@Result(id = true,column = "tno",property = "tno"),
            @Result(column = "tname",property = "tname"),
            @Result(column = "password",property = "password"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "email",property = "email"),
            @Result(column = "address",property ="address"),
            @Result(column = "acquireStatus",property = "acquireStatus"),
            @Result(column = "checkStatus",property = "checkStatus"),
            @Result(column = "checkTime",property = "checkTime"),
            @Result(column = "dorm_id",property = "dormInfo",
                    one=@One(select = "com.ssm.dao.DormInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "idcard",property = "idcard"),
            @Result(column = "dep_id",property ="departmentInfo",
                    one = @One(select = "com.ssm.dao.DepartmentInfoDao.selectById", fetchType = FetchType.EAGER))
    })
    @Select("select * from teacher")
    List<TeacherInfo> getAllTeacher();

    //获取已分配的学生列表

    @Select("select count(tno) from teacher where dorm_id is not null group by dep_id order by dep_id")
    List<Integer> getAlreadyDistribute();

    //获取未分配的学生列表

    @Select("select count(tno) from teacher where dorm_id is null group by dep_id order by dep_id")
    List<Integer> getNoDistribute();


    //报到
    @UpdateProvider(type = TeacherInfoDynaSqlProvider.class,method ="updateWithParam")
    int changeMessage(TeacherInfo teacherInfo);




    @Results({@Result(id = true,column = "tno",property = "tno"),
            @Result(column = "tname",property = "tname"),
            @Result(column = "password",property = "password"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "phone",property = "phone"),
            @Result(column = "email",property = "email"),
            @Result(column = "address",property ="address"),
            @Result(column = "acquireStatus",property = "acquireStatus"),
            @Result(column = "checkStatus",property = "checkStatus"),
            @Result(column = "checkTime",property = "checkTime"),
            @Result(column = "dorm_id",property = "dormInfo",
                    one=@One(select = "com.ssm.dao.DormInfoDao.selectById", fetchType = FetchType.EAGER)),
            @Result(column = "idcard",property = "idcard"),
            @Result(column = "dep_id",property ="departmentInfo",
                    one = @One(select = "com.ssm.dao.DepartmentInfoDao.selectById", fetchType = FetchType.EAGER))
    })
    @Select("select * from teacher where tno=#{tno}")
    TeacherInfo getTeacher(TeacherInfo teacherInfo);


    //修改密码
    @Update("update teacher set password=#{password} where tno=#{tno}")
    int changePassword(TeacherInfo teacherInfo);

}
