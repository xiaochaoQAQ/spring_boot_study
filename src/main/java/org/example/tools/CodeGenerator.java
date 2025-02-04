package org.example.tools;



import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author
 * @since 2018/12/13
 */
public class CodeGenerator {

    public static void main(String[] args) {

        // 1、创建代码生成器
        AutoGenerator generator = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("D:\\ideaproject\\spring_boot_study" + "/src/main/java");
        gc.setAuthor("");
        gc.setOpen(false); //生成后是否打开生成目录
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        //gc.setServiceName("%sService");    //去掉Service接口的首字母I
        gc.setIdType(IdType.AUTO); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(false);//开启Swagger2模式
        gc.setBaseResultMap(true);// 开启 BaseResultMap，默认是false
        gc.setBaseColumnList(true);// 开启 baseColumnList，默认是false

        generator.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/shopping_car?useUnicode=true&&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowMultiQueries=true");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
        generator.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(""); //模块名
        //包
        pc.setParent("org.example");
        //包
        pc.setController("controller");
        pc.setEntity("model");
        pc.setService("service");
        pc.setMapper("dao");
        generator.setPackageInfo(pc);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();

        strategy.setInclude("t_produce");

        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setTablePrefix("t_"); //生成实体时去掉表前缀

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok注解

        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

        generator.setStrategy(strategy);


        // 6、执行
        generator.execute();
    }

}