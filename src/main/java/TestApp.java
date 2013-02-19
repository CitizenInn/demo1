import java.util.ArrayList;

import org.citizeninn.Opinion;
import org.citizeninn.OpinionPoll;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestApp {

	
	static SessionFactory sessionFactory;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		OpinionPoll opinionPoll = new OpinionPoll();
//		opinionPoll.setName("What do you think about this new law?");
//		opinionPoll.setDescription("This is first pool of opinions for citizen inn");
//
//		Opinion opinion1 = new Opinion();
//		opinion1.setName("It is fine");
//		opinionPoll.addOpinion(opinion1);
//		
//		Opinion opinion2 = new Opinion();
//		opinion2.setName("Needs to be changed");
//		opinionPoll.addOpinion(opinion2);
//		
//		showOpinionPool(opinionPoll);
		
		System.out.println("Working Directory = "
				+ System.getProperty("user.dir"));

		try {
			setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Opinion opinion = new Opinion();
		opinion.setDescription("second opinion");
		opinion.setName("option name");
		opinion.setComments("some comments");
		session.save(opinion);
		
		//session.save( new Event( "Our very first event!", new Date() ) );
		//session.save( new Event( "A follow up event", new Date() ) );
		session.getTransaction().commit();
		session.close();
		
		
		
	}

	static void showOpinionPool(OpinionPoll pool) {
		System.out.println("SPool name:       " + pool.getName());
		System.out.println("Pool description: " + pool.getDescription());
		
		ArrayList<Opinion> options = pool.getOpinions();
		int opinionCounter = 1;
		for (Opinion opinion : options) {
			System.out.println("Option " + opinionCounter + ": " + opinion.getName());
			opinionCounter++;
		}

	}
	
	@SuppressWarnings("deprecation")
	protected static void setUp() throws Exception {
	    // A SessionFactory is set up once for an application
	    sessionFactory = new Configuration()
	            .configure() // configures settings from hibernate.cfg.xml
	            .buildSessionFactory();
	}

}
