package com.fitness.service.impl;


import com.fitness.dao.CommentDao;
import com.fitness.entity.NewsListItem;
import com.fitness.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 刘冠麟
 * @Date: 2019-06-21 16:46
 */
@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    CommentDao dao;


    @Override
    public List<NewsListItem> getCommentsList(Integer userId) {
        return castEntity(dao.getCommentsList(userId), NewsListItem.class);
    }

    @Transactional
    @Override
    public boolean addNewComment(Integer userId, Integer newsId, String comment, String replyUser) {
        return dao.addNewComment(userId, newsId, comment, replyUser)==1;
    }


    public <T> List<T> castEntity(List<Object[]> list, Class<T> clazz) {
        List<T> returnList = new ArrayList();
        if (list.isEmpty()) {
            return returnList;
        }

        Object[] co = list.get(0);
        Class[] c2 = new Class[co.length];


        for (int i = 0; i < co.length; i++) {
            c2[i] = co[i].getClass();
        }

        for (Object[] o : list) {
            Constructor<T> constructor = null;
            try {
                constructor = clazz.getConstructor(c2);
                returnList.add(constructor.newInstance(o));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return returnList;
    }


}
