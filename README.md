# springboot-jpa
> 本项目使用springboot框架，通过jpa进行数据库连接操作

# 目录
* [1 创建项目](#01)
* [2 启动数据库](#02)
* [3 编写代码](#03)
* [4 测试](#04)

## <div id="01"></div>
## 1 创建项目
> 参照或复制springboot-maven项目
> [《springboot-maven》]()

## <div id="02"></div>
## 2 启动数据库
    2.1、docker pull mysql
    2.2、docker run -d -p 3306:3306 -v /F/data/docker/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 mysql
    2.3、确认2.2挂载目录后，开启数据库服务
    2.3、数据库增加zglu库
    2.4、zglu库增加user表，user表增加name字段
    2.5、zglu库增加role表，role表增加name字段
    2.6、zglu库增加user_role表，user_role表增加user_id，role_id字段
> 参照[《test.sql》]()

## <div id="03"></div>
## 3 编写代码
    3.1、pom.xml文件引入依赖
    3.2、application.properties添加配置项
    3.3、编写实体文件
    3.4、编写repo文件
    3.5、编写测试用例

## <div id="04"></div>
## 4 测试
> 访问http://localhost:8080/swagger-ui.html进行测试