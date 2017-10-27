package cn.demo.dao;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.demo.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	

	@Override
	public User getByUserCode(String code) {
		
		return getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String sql = "SELECT * FROM `user` WHERE `code`=?";
				SQLQuery query = session.createSQLQuery(sql);
				query.addEntity(User.class);
				query.setParameter(0, code);
				User user = (User) query.uniqueResult();
				return user;
			}
			
		});
		
	}


}
