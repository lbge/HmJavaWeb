package com.xducs.service.impl;

import com.xducs.dao.UserDao;
import com.xducs.dao.impl.UserDaoImpl;
import com.xducs.domain.Admin;
import com.xducs.domain.PageBean;
import com.xducs.domain.User;
import com.xducs.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author Linbo Ge
 * @date 2020/3/16 - 16:08
 */
public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public Admin login(Admin admin) {
        return dao.findAdmin(admin.getUsername(), admin.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void delUser(String id) {
        dao.delUser(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delSelected(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                dao.delUser(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if (currentPage <=0){
            currentPage =1;
        }
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        int totulCount = dao.findTotalCount(condition);
        pageBean.setTotalCount(totulCount);
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows,condition);
        pageBean.setList(list);
        int totalPage = (totulCount % rows) == 0 ? totulCount / rows : (totulCount / rows) + 1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }
}
