package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.dao.MLATeamDao;
import com.test.dao.MLATeamDAO1;
import com.test.model.MLATeam;


public class testDemo {

	public static void main(String[] args) {
//		MLATeamDao dao = new MLATeamDao();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		MLATeamDao dao = ctx.getBean("tdao",MLATeamDao.class);
		MLATeamDAO1 dao1= ctx.getBean("tdao1",MLATeamDAO1.class);
		MLATeam obj = new MLATeam();
		
		obj.setId(102);
		obj.setName("Rohith");
		obj.setSkill("c++");
		obj.setManager("kohli");
		
		dao1.createMLATeam(obj);
		
//		dao.saveMLATeam(obj); //insert
//		dao.updateMLATeam(obj); //update
//		dao.deletMLATeamMember(obj); //delete
		

		
		
		List<MLATeam> list = dao.getAllMembers();
		list.forEach(team->System.out.println(team.getId()+" "+team.getName()+" "+team.getSkill()+" "+team.getManager()));
		
	}

}
