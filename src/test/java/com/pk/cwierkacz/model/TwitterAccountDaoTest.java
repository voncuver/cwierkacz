package com.pk.cwierkacz.model;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.junit.Test;

import com.pk.cwierkacz.model.dao.TwitterAccountDao;
import com.pk.cwierkacz.model.dao.UserDao;

public class TwitterAccountDaoTest
{

    @Test
    public void simpleTest( ) throws JsonGenerationException, JsonMappingException, IOException {
        UserDao userDao = new UserDao();
        userDao.setName("sss");

        TwitterAccountDao accountDao = new TwitterAccountDao();
        accountDao.setAccessToken("1234");
        accountDao.setAccessTokenSecret("456");
        accountDao.setAccountName("test");
        accountDao.setDeleted(false);
        accountDao.setExternalId(1l);
        accountDao.setId(1l);

        userDao.setAccounts(new HashSet<>(Arrays.asList(accountDao)));
        accountDao.addUser(userDao);

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.getSerializationConfig().withSerializationInclusion(Inclusion.NON_NULL);
        String result = objectMapper.writeValueAsString(userDao);
    }
}
