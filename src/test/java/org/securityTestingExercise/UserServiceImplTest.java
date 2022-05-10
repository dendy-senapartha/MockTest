package org.securityTestingExercise;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Project: Quiz8
 * Package: securityTestingExercise
 * Description : lakukan verifikasi jika object user berhasil mendapatkan pasword barunya,
 * dan method updateUser() pada userDAO dipanggil dengan benar.
 * hint : gunakan method static any() untuk melakukan stub test
 */
public class UserServiceImplTest {
    SecurityService securityService = mock(SecurityService.class);
    User user = mock(User.class);
    UserDAO userDao = mock(UserDAO.class);
    final String NEW_PASSWORD = "passwordBaru";

    @Test
    public void verifyCheckUpdatePassword()  throws Exception{
        UserServiceImpl sut = new UserServiceImpl(userDao, securityService);
        when(user.getPassword()).thenReturn(NEW_PASSWORD);
        when(securityService.md5(user.getPassword())).thenReturn(NEW_PASSWORD);
        sut.assignPassword(user);
        verify(user).setPassword(NEW_PASSWORD);
        verify(userDao).updateUser(user);
    }
}
