package com.study.mapper;

import com.study.config.RootConfig;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class MapperTests {
    @Setter(onMethod_ = @Autowired)
    private DataSource dataSource;

    @Test
    public void dataSourceTest() throws SQLException {
        log.info("dataSourceTest...");
        Connection conn = dataSource.getConnection();
        log.info("JDBC connection: " + conn.getClientInfo());
        assertNotNull(conn);
    }
}
