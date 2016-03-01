import edu.gatech.buzzmovieselector.server.dao.ProfileDao;
import edu.gatech.buzzmovieselector.server.dao.UserDao;
import edu.gatech.buzzmovieselector.server.dao.impl.ProfileDaoImpl;
import edu.gatech.buzzmovieselector.server.dao.impl.UserDaoImpl;
import edu.gatech.buzzmovieselector.server.entity.Profile;
import edu.gatech.buzzmovieselector.server.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by yangjianing on 2/16/16.
 */
public class Main {


    public static void main(final String[] args) throws Exception {
        UserDao ud = new UserDaoImpl();
        ProfileDao pd = new ProfileDaoImpl();

        User user = new User();
        user.setUsername("haha1");
        user.setPassword("hehe");
        user.setUserLevel(User.UserLevel.USER);

        Profile profile = new Profile();
        profile.setEmail("434@aa.com");
        profile.setFirstName("yag");
        profile.setMajor("COMPUTER SCIENCE");

        user.setProfile(profile);

        pd.createOrUpdate(profile);
        ud.createOrUpdate(user);
    }
}
