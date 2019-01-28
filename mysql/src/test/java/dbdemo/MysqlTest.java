package dbdemo;

import com.redsun.common.JpaConfiguration;
import com.redsun.dbdemo.entity.Department;
import com.redsun.dbdemo.entity.Role;
import com.redsun.dbdemo.entity.User;
import com.redsun.dbdemo.repository.DepartmentRepository;
import com.redsun.dbdemo.repository.RoleRepository;
import com.redsun.dbdemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;
import base.BaseTest;

import java.util.Date;
import java.util.List;

@Slf4j
@ContextConfiguration(classes = {JpaConfiguration.class})
public class MysqlTest extends BaseTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void initData() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        departmentRepository.deleteAll();

        Department department = new Department();
        department.setName("开发部");
        departmentRepository.save(department);
        Assert.notNull(department.getId(), "department id is null!");

        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.notNull(role.getId(),"role id is null!");

        User user = new User();
        user.setName("user");
        user.setCreatedate(new Date());
        user.setDepartment(department);
        List<Role> roles = roleRepository.findAll();
        Assert.notNull(roles, "roles is null!");
        user.setRoles(roles);

        userRepository.save(user);
        Assert.notNull(user.getId(), "user id is null!");
    }

    @Test
    public void findPage() {
        Pageable pageable = PageRequest.of(0, 10, new Sort(Sort.Direction.ASC, "id"));

        Page<User> page = userRepository.findAll(pageable);

        Assert.notNull(page, "page is null!");

        for(User user : page.getContent()) {
            log.info("=================== user name:{}, department name:{}, role name:{}",
                    user.getName(), user.getDepartment(), user.getRoles().get(0).getName());
        }
    }

}
