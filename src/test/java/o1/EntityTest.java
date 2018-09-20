package o1;

import com.ssh.configurtion.AppConfiguration;
import com.ssh.service.MateService;
import com.ssh.service.SoulmateService;
import com.ssh.service.UserService;
import com.ssh.vo.Mate;
import com.ssh.vo.Soulmate;
import com.ssh.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {AppConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EntityTest {

    @Autowired
    private UserService userService;
    @Autowired
    private MateService mateService;
    @Autowired
    private SoulmateService soulmateService;

    @Test
    public void one2oneTest() {
       /* User user = userService.findById(6);
        System.out.println(user.getSoulmate());*/
        //userService.delete(7);
        Soulmate soulmate = soulmateService.findById(1);
    }

    @Test
    public void many2oneQueryTest() {
        //测试懒加载带来的影响
        mateService.loadById(1);
    }

    @Test
    public void many2oneSaveTest() {
        Mate mate = new Mate();
        mate.setName("test");
        User user = new User() {{
            setId(11);
        }};
        mate.setUser(user);
        mateService.save(mate);
    }

    @Test
    public void one2manyDeleteTest() {
        userService.delete(11);
    }

    @Test
    public void transTest() {
        final User user = new User();
        user.setAge(18);
        user.setLocation("USA");
        user.setName("csn");
        user.setSex("男");
        user.setSoulmate(new Soulmate() {{
            setName("kfc");
            setUser(user);
        }});
       /* Set<Mate> mates = new HashSet<>();
        mates.add(new Mate(){{setName("gyf");setUser(user);}});
        user.setMates(mates);*/
        userService.save(user);
    }
}
