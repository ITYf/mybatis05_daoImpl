package top.ityf.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import top.ityf.domain.User;

import java.util.List;

/**
 * ClassName:UserDao
 * Package: top.ityf.dao.impl
 * Description:
 *
 * @Date: 2020/1/1 10:45
 * @Author: YanFei
 */
public class UserDaoImpl implements top.ityf.dao.UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        //1、根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2、调用SqlSession中的方法，实现查询列表
        //参数就是能获取配置信息的key，也就是namespace.方法名
        List<User> users = session.selectList("top.ityf.dao.UserDao.findAll");
        //3、释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {
        //1、根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2、调用方法，实现保存
        session.insert("top.ityf.dao.UserDao.saveUser",user);
        //3、提交事务
        session.commit();
        //4、释放资源
        session.close();

    }

    public void updateUser(User user) {
        //1、根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2、调用方法，实现更新
        session.update("top.ityf.dao.UserDao.updateUser",user);
        //3、提交事务
        session.commit();
        //4、释放资源
        session.close();
    }

    public void deleteUser(Integer userId) {
        //1、根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2、调用方法，实现删除
        session.update("top.ityf.dao.UserDao.deleteUser",userId);
        //3、提交事务
        session.commit();
        //4、释放资源
        session.close();
    }

    public User findById(Integer userId) {
        //1、根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2、调用SqlSession中的方法，实现查询一个
        //参数就是能获取配置信息的key，也就是namespace.方法名
        User user = session.selectOne("top.ityf.dao.UserDao.findById",userId);
        //3、释放资源
        session.close();
        return user;
    }

    public List<User> findByName(String username) {
        //1、根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2、调用SqlSession中的方法，实现模糊查询
        //参数就是能获取配置信息的key，也就是namespace.方法名
        //这里需要注意，如果实现类的方法没有给 "%" ，在测试方法中要给 "%" 以实现模糊查询
        List<User> users = session.selectList("top.ityf.dao.UserDao.findByName",username);
        //3、释放资源
        session.close();
        return users;
    }

    public int findTotal() {
        //1、根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2、调用SqlSession中的方法，实现查询一个
        //参数就是能获取配置信息的key，也就是namespace.方法名
        Integer count = session.selectOne("top.ityf.dao.UserDao.findTotal");
        //3、释放资源
        session.close();
        return count;
    }
}
