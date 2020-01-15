package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {

	private SessionFactory sessionFactory;

	public AccountDAO(@Qualifier("sessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean checkLogin(Account users) {
		try {
		Session session = sessionFactory.getCurrentSession();
		String hqlStr = "from Account where username=:user and userpwd=:pwd";
		Query query = session.createQuery(hqlStr);
		// 設定帶進來參數的名稱
		query.setParameter("user", users.getUsername());
		query.setParameter("pwd", users.getUserpwd());
		// 取一筆資料就好強制轉Account物件		
		Account account = (Account)query.uniqueResult();
		
		// 判斷if else
		if(account!=null) {
			return true;
		}
		return false;
		}catch(Exception e) {
			System.out.println("e:"+e);
			return false;
		}
	}

}
