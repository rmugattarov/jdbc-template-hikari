package rmugattarov.jdbc_template_hikari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void printAll() {
        System.out.println(jdbcTemplate.queryForList("select * from user"));
    }
}
