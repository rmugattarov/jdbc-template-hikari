package rmugattarov.jdbc_template_hikari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void printAll() {
        System.out.println(jdbcTemplate.queryForList("select * from user"));
    }

    public void persist() {
        List<Object[]> vals = new ArrayList<>(100);
        Random random = new Random();

        for (int i=0;i<100;i++) {
            Object[] row = new Object[3];
            row[0]= random.nextInt();
            row[1] = String.valueOf(row[0]);
            row[2] = row[1];
            vals.add(row);
        }

        jdbcTemplate.batchUpdate("insert into user(id,name,email) values(?,?,?)",vals);
    }
}
